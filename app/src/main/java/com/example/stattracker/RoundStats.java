package com.example.stattracker;
/**
 * Alec Quiroga
 * 4/29/20
 * Advanced Java
 *
 */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RoundStats extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round_stats);

        // Displaying total Score of the round.
        final int yourScore = MainActivity.addition(HoleChoice.allScores);
        String scores = "Your Score: "+ yourScore;
        TextView scoreDisplay = (TextView) findViewById(R.id.totalScore);
        scoreDisplay.setText(scores);

        // Displaying the total par input.
        final int totalPar = MainActivity.addition(HoleChoice.parOfHoles);
        String stringOfPar = "Par: "+ totalPar;
        TextView parDisplay = (TextView) findViewById(R.id.parTotal);
        parDisplay.setText(stringOfPar);

        final String totalGreens = "Greens In Regulation: " + HoleChoice.greenCount +
                "/"+ HoleChoice.totalNumOfHoles;
        TextView greenDisplay = (TextView) findViewById(R.id.greenInRegDisplay);
        greenDisplay.setText(totalGreens);

        String totalUpNDown = "Up and Downs: " + HoleChoice.upNDown +
                "/"+ (HoleChoice.totalNumOfHoles - HoleChoice.greenCount);
        TextView upAndDownDisplay = (TextView) findViewById(R.id.upAndDown);
        upAndDownDisplay.setText(totalUpNDown);


        Button backToMain = (Button) findViewById(R.id.endOfRound);
        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Makes it so that rounds Statistics are only saved
                // it is a full eighteen holes
                if(HoleChoice.totalNumOfHoles == 18) {
                    String allOfStats = totalPar + "," + yourScore + "," + HoleChoice.greenCount +
                            "," + HoleChoice.upNDown;
                }
                Intent Intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(Intent);
            }
        });
    }

    /**
     * Saves the Strings into shared preferences.
     * @param stats the statistics from the current round.
     */
    public void save(String stats){
        String allOfStats = stats;

        // Makes it so that at most the stats only go for the five previous rounds
        if (MainActivity.allStats.size() == 5){
            MainActivity.allStats.remove(4);
        }

        for (int i = 0; i < MainActivity.allStats.size(); i++ ){
            allOfStats = allOfStats + " " + MainActivity.allStats.get(i);
        }
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("text", allOfStats);
    }
}
