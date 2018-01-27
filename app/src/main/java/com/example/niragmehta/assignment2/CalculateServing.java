package com.example.niragmehta.assignment2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculateServing extends AppCompatActivity {

    private static final String EXTRA_POT_NAME = "The pot's name";
    private static final String EXTRA_POT_WEIGHT = "The pot's weight";
    private String potName;
    private int emptyPotWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_serving);

        TextView txtViewPotName=findViewById(R.id.textViewPotName);
        TextView txtViewWeightEmpty=findViewById(R.id.textViewWeightEmpty);

        //txtViewPotName.setText(potName);
        //txtViewWeightEmpty.setText(emptyPotWeight);

        validateAndUpdateLabels();

        extractDataFromIntent();

        goBack();

        Log.i("Debug", "pot name is = " + potName + "\n"
                + "pot weight is = " + emptyPotWeight + ".");
    }

    public static Intent makeIntent(Context context, String potName, int potWeight) {
        Intent intent = new Intent(context, CalculateServing.class);
        intent.putExtra(EXTRA_POT_NAME,potName);
        intent.putExtra(EXTRA_POT_WEIGHT, potWeight);
        return intent;
    }

    private void extractDataFromIntent() {
        Intent intent = getIntent();
        potName = intent.getStringExtra(EXTRA_POT_NAME);
        emptyPotWeight = intent.getIntExtra(EXTRA_POT_WEIGHT, 0);
    }

    public void validateAndUpdateLabels()
    {
        TextView label=findViewById(R.id.ResultLabel);

        EditText wtWithFood=findViewById(R.id.PTWtWithFood);
        EditText numServings=findViewById(R.id.PTnumServings);
        TextView wtOfFood=findViewById(R.id.txtViewfoodWeight);
        TextView servingWeightLabel=findViewById(R.id.txtViewServingWt);

        int wtWithFoodnum;
        int numServingsnum;

        int wtEmptynum=emptyPotWeight;

        try {
            wtWithFoodnum=Integer.parseInt(wtWithFood.getText().toString());
            numServingsnum=Integer.parseInt(numServings.getText().toString());
        }
        catch (Exception e)
        {

            label.setText("You did not enter an integer into the text field(s)");
            return;
        }

        if(wtWithFoodnum<0 || numServingsnum<0)
        {

            label.setText("Please enter a whole number into the text field(s)");
            return;
        }


        int wtOfFoodResult=wtWithFoodnum-wtEmptynum;
        int servingWtNum=wtOfFoodResult/numServingsnum;

        wtOfFood.setText(wtOfFoodResult);
        servingWeightLabel.setText(servingWtNum);




    }

    public void goBack()
    {
        Button button=findViewById(R.id.btnBack);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
