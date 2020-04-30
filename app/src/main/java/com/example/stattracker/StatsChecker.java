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

public class StatsChecker extends AppCompatActivity {

    public double eighteenHoles = 18.0;
    public double averageScore;
    public double averagePar;
    public double averageGreen;
    public double averageUpPercent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats_checker);

        averages();
        String scores = "Average Score: " + averageScore;
        TextView scoreDisplay = (TextView) findViewById(R.id.scoreAverage);
        scoreDisplay.setText(scores);

        // Displaying the Average par of the Courses input
        String stringOfPar = "Average Course Par: "+ averagePar;
        TextView parDisplay = (TextView) findViewById(R.id.averageParText);
        parDisplay.setText(stringOfPar);

        String totalGreens = "Average Greens In Regulation: " + averageGreen;
        TextView greenDisplay = (TextView) findViewById(R.id.greensPercent);
        greenDisplay.setText(totalGreens);

        String totalUpNDown = "Up and Down Percent: " + averageUpPercent;
        TextView upAndDownDisplay = (TextView) findViewById(R.id.percentUpAndDown);
        upAndDownDisplay.setText(totalUpNDown);


        Button back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(startIntent);

            }
        });
    }

    /**
     * Displays the averages when you click into this activity.
     */
    public void averages(){

        //Setting basic variables needed for calculations
    double totalPar = 0.0;
    double totalScore = 0.0;
    double totalGreens = 0.0;
    double totalUp = 0.0;
    String currentStats;

    for(int i = 0; i < MainActivity.allStats.size(); i++){

        //Pulls the string in the array list
        currentStats = MainActivity.allStats.get(i);

        //Tokenizes the string.
        String[] token = currentStats.split(",");

        // Adds the numbers that were tokenized to the total.
        totalPar += Double.parseDouble(token[0]);
        totalScore += Double.parseDouble(token[1]);
        totalGreens += Double.parseDouble(token[2]);
        totalUp += Double.parseDouble(token[3]);
    }

    // Calculating averages to be dispalyed.
        if (totalGreens > 0) {
            averageScore = totalScore/ MainActivity.allStats.size();
            averagePar = totalPar/ MainActivity.allStats.size();
            averageGreen = totalGreens / MainActivity.allStats.size();
            averageUpPercent = totalUp/ ((eighteenHoles*MainActivity.allStats.size()) - totalGreens);

        }

    }

}
