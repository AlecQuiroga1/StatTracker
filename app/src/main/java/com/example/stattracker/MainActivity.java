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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addRound = (Button) findViewById(R.id.addRoundButton);
        addRound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(startIntent);
            }
        });

        Button checkStatsButton = (Button) findViewById(R.id.statChecker);
        checkStatsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startCheckerIntent = new Intent(getApplicationContext(), StatsChecker.class);
                startActivity(startCheckerIntent);
            }
        });
    }
    public static int addition(ArrayList<Integer> list){
        int totalscore = 0;
        for(int i = 0; i < list.size(); i++){
            totalscore = totalscore + list.get(i);
        }
        return totalscore;
    }
}
