package com.example.stattracker;

/**
 * Alec Quiroga
 * 4/29/20
 * Advanced Java
 * Controls the two buttons that chose whether you want to play 18 or 9 holes.
 */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class HoleChoice extends AppCompatActivity {

    // Arraylists to store the values needed for hole pars.
    public static ArrayList<Integer> parOfHoles = new ArrayList<Integer>();

    // Arraylist that stores inputted scores.
    public static ArrayList <Integer> allScores = new ArrayList<Integer>();

    // Subtracts the two other arraylist to get the difference between the score and par.
    public static ArrayList <Integer> toPar = new ArrayList<Integer>();

    // Initializing global variable
    public static int totalNumOfHoles;
    public static int upNDown = 0;
    public static int greenCount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Button that sets the values if the person it going to play eighteen holes.
        Button eighteenHolePrompts = (Button) findViewById(R.id.eighteenHoles);
        eighteenHolePrompts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Sets the total of holes.
                totalNumOfHoles = 18;

                // Moves to the hole prompts activity.
                Intent startIntent = new Intent(getApplicationContext(), HolePrompts.class);
                startActivity(startIntent);

            }
        });

        // Button for if the user wants to play nine holes.
        Button nineHolePrompts = (Button) findViewById(R.id.nineHoles);
        nineHolePrompts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Sets the total of holes.
                totalNumOfHoles = 9;

                // Move the app to the whole prompts activity.
                Intent startIntent = new Intent(getApplicationContext(), HolePrompts.class);
                startActivity(startIntent);

            }
        });
    }
}
