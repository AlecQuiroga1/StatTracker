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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<String> allStats = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addRound = (Button) findViewById(R.id.addRoundButton);
        addRound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), HoleChoice.class);
                startActivity(startIntent);
            }
        });

        Button checkStatsButton = (Button) findViewById(R.id.statChecker);
        checkStatsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                load();
                Intent startCheckerIntent = new Intent(getApplicationContext(), StatsChecker.class);
                startActivity(startCheckerIntent);
            }
        });
    }

    /**
     * It takes in a arraylist of integers and adds up the entire thing.
     * Then returns the total.
     *
     * @param list an ArrayList of integers that
     * @return The total of the integer array list.
     */
    public static int addition(ArrayList<Integer> list){
        int totalscore = 0;
        for(int i = 0; i < list.size(); i++){
            totalscore = totalscore + list.get(i);
        }
        return totalscore;
    }

    /**
     * Loads in the string from SharedPreferences then tokenizes it to add to the arraylist.
     */
    public void load(){
        // Makes an instance of shared preferences to save the string values.
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
        String inputText = sharedPreferences.getString("text", "");

        // As long as the input text is not the default value it will execute.
        if(!inputText.equals("")){
           String[] array = inputText.split(" ");

           //Adds the tokens to the arraylist.
           for(int i = 0; i < array.length; i++){
               allStats.add(array[i]);
           }
        }
    }
}
