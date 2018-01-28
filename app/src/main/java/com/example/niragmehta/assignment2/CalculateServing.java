package com.example.niragmehta.assignment2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculateServing extends AppCompatActivity implements TextWatcher {

    private static final String EXTRA_POT_NAME = "The pot's name";
    private static final String EXTRA_POT_WEIGHT = "The pot's weight";
    private String potName;
    private int emptyPotWeight;
    private int wtOfFoodnum;

    EditText wtWithFood;
    EditText numServings;
    TextView wtOfFood;
    TextView servingWeightLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_serving);

        TextView txtViewPotName = findViewById(R.id.textViewPotName);
        TextView txtViewWeightEmpty = findViewById(R.id.textViewWeightEmpty);

        extractDataFromIntent();
        goBack();

        txtViewPotName.setText(potName);
        txtViewWeightEmpty.setText("" + emptyPotWeight);

        wtWithFood=findViewById(R.id.PTWtWithFood);
        numServings=findViewById(R.id.PTnumServings);
        wtOfFood=findViewById(R.id.txtViewfoodWeight);
        servingWeightLabel=findViewById(R.id.txtViewServingWt);

        wtWithFood.addTextChangedListener(this);
        numServings.addTextChangedListener(this);

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        try {
            Integer.parseInt(editable.toString());
        }
        catch (Exception e){Toast.makeText(getApplicationContext(),
                "The text you have entered in weight field is not a number",
                Toast.LENGTH_SHORT).show();
                //wtOfFood.setText("");
                //servingWeightLabel.setText("");
                return;
        }



        try {

            if(editable==wtWithFood.getEditableText())
            {


                int temp=Integer.parseInt(wtWithFood.getText().toString());
                temp=temp-emptyPotWeight;


                wtOfFoodnum=temp;
                wtOfFood.setText(""+wtOfFoodnum);

                temp=Integer.parseInt(numServings.getText().toString());
                temp=wtOfFoodnum/temp;


                servingWeightLabel.setText(""+temp);
            }

            else if(editable==numServings.getEditableText())
            {
                int temp=Integer.parseInt(numServings.getText().toString());
                temp=wtOfFoodnum/temp;
                
                servingWeightLabel.setText(""+temp);
            }
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(),
                "Text Field is empty",
                Toast.LENGTH_SHORT).show();
        }


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
