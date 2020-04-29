package com.example.stattracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    public static ArrayList<Integer> parOfHoles = new ArrayList<Integer>();
    public static ArrayList <Integer> allScores = new ArrayList<Integer>();
    public static ArrayList <Integer> toPar = new ArrayList<Integer>();
    public static int totalNumOfHoles;
    public static int upNDown = 0;
    public static int greenCount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button eighteenHolePrompts = (Button) findViewById(R.id.eighteenHoles);
        eighteenHolePrompts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalNumOfHoles = 18;
                Intent startIntent = new Intent(getApplicationContext(), HolePrompts.class);
                startActivity(startIntent);

            }
        });
        Button nineHolePrompts = (Button) findViewById(R.id.nineHoles);
        nineHolePrompts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalNumOfHoles = 3;
                Intent startIntent = new Intent(getApplicationContext(), HolePrompts.class);
                startActivity(startIntent);

            }
        });
    }
}
