package com.example.stattracker;
/**
 * Alec Quiroga
 * 4/29/20
 * Advanced Java
 *
 */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        String scores = "Your Score: "+ MainActivity.addition(SecondActivity.allScores);
        TextView scoreDisplay = (TextView) findViewById(R.id.totalScore);
        scoreDisplay.setText(scores);

        // Displaying the total par input.
        String totalPar = "Par: "+ MainActivity.addition(SecondActivity.parOfHoles);
        TextView parDisplay = (TextView) findViewById(R.id.parTotal);
        parDisplay.setText(totalPar);

        String totalGreens = "Greens In Regulation: " + SecondActivity.greenCount +
                "/"+ SecondActivity.totalNumOfHoles;
        TextView greenDisplay = (TextView) findViewById(R.id.greenInRegDisplay);
        greenDisplay.setText(totalGreens);

        String totalUpNDown = "Up and Downs: " + SecondActivity.upNDown +
                "/"+ (SecondActivity.totalNumOfHoles - SecondActivity.greenCount);
        TextView upAndDownDisplay = (TextView) findViewById(R.id.upAndDown);
        upAndDownDisplay.setText(totalUpNDown);


        Button backToMain = (Button) findViewById(R.id.endOfRound);
        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(Intent);
            }
        });
    }
}
