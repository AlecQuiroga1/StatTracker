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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class HolePrompts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Starts the activity over and over until the total number of holes has been filled in.
        if (HoleChoice.allScores.size() < HoleChoice.totalNumOfHoles){
            setContentView(R.layout.activity_holeprompts);

            String holeNumber = "Hole: "+ (HoleChoice.allScores.size() +1);

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


                    // Makes it so that if green in regulation is checked
                    // then up and down cannot count
                    if(green.isChecked()){
                        HoleChoice.greenCount += 1;

                    }else if(upDown.isChecked()){
                        HoleChoice.upNDown += 1;
                    }

                    int currentScore = Integer.parseInt(scoreEditText.getText().toString());
                    int currentPar = Integer.parseInt(parEditText.getText().toString());


                    int currentToPar = currentScore - currentPar;

                    HoleChoice.parOfHoles.add(currentPar);
                    HoleChoice.allScores.add(currentScore);
                    HoleChoice.toPar.add(currentToPar);

                    // Starts the same activity over
                    Intent Intent = getIntent();
                    startActivity(Intent);

                }
            });

        } else{
            // Opens the Round stats Activity
            Intent startCheckerIntent = new Intent(getApplicationContext(), RoundStats.class);
            startActivity(startCheckerIntent);
        }

    }

}
