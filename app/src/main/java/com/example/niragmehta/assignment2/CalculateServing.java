package com.example.niragmehta.assignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculateServing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_serving);

        EditText wtWithFood=findViewById(R.id.PTWtWithFood);
        EditText numServings=findViewById(R.id.PTnumServings);


        goBack();

    }

    public void validateAndUpdateLabels()
    {
        TextView wtOfFood=findViewById(R.id.txtViewfoodWeight);
        TextView servingWeight=findViewById(R.id.txtViewfoodWeight);
        TextView servingWeightLabel=findViewById(R.id.txtViewServingWt);



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
