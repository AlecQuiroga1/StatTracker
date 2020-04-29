package com.example.stattracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class HolePrompts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (SecondActivity.allScores.size() < SecondActivity.totalNumOfHoles){
            setContentView(R.layout.activity_holeprompts);

            String holeNumber = "Hole: "+ (SecondActivity.allScores.size() +1);

            TextView tv = (TextView) findViewById(R.id.holeNum);
            tv.setText(holeNumber);

            Button nextHole = (Button) findViewById(R.id.nextHole);

            nextHole.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // Getting input for the Par of the Hole.
                    EditText parEditText = (EditText) findViewById(R.id.par);

                    // Getting input for the score made on hole.
                    EditText scoreEditText = (EditText) findViewById(R.id.score);

                    CheckBox green = (CheckBox) findViewById(R.id.greenInReg);
                    CheckBox upDown = (CheckBox) findViewById(R.id.upAndDown);

                    if(green.isChecked()){
                        SecondActivity.greenCount += 1;

                    }else if(upDown.isChecked()){
                        SecondActivity.upNDown += 1;
                    }

                    int currentScore = Integer.parseInt(scoreEditText.getText().toString());
                    int currentPar = Integer.parseInt(parEditText.getText().toString());


                    int currentToPar = currentScore - currentPar;

                    SecondActivity.parOfHoles.add(currentPar);
                    SecondActivity.allScores.add(currentScore);
                    SecondActivity.toPar.add(currentToPar);

                    Intent Intent = getIntent();
                    startActivity(Intent);
                }
            });

        } else{
            Intent startCheckerIntent = new Intent(getApplicationContext(), RoundStats.class);
            startActivity(startCheckerIntent);
        }




    }

}
