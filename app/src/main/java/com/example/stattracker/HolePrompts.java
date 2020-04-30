package com.example.stattracker;
/**
 * Alec Quiroga
 * 4/29/20
 * Advanced Java
 *
 * Prompts the user for the different inputs needed to keep track of the stats.
 */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This class contains the prompts from which the inputs used for the Stats are gained.
 * Keeps on activating itself until the max number of holes are filled.
 */
public class HolePrompts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Starts the activity over and over until the total number of holes has been filled in.
        if (HoleChoice.allScores.size() < HoleChoice.totalNumOfHoles){
            setContentView(R.layout.activity_holeprompts);

            // String that will be used to display the hole number.
            String holeNumber = "Hole: "+ (HoleChoice.allScores.size() +1);

            //Displays the Hole number
            TextView tv = (TextView) findViewById(R.id.holeNum);
            tv.setText(holeNumber);

            // Button to clear and save the stored values.
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

                    // Converting the inputs to integers
                    int currentScore = Integer.parseInt(scoreEditText.getText().toString());
                    int currentPar = Integer.parseInt(parEditText.getText().toString());


                    int currentToPar = currentScore - currentPar;

                    // Stores the input values to arrayLists
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
