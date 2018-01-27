package com.example.niragmehta.assignment2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class PotList extends AppCompatActivity {

    public static final int REQUEST_CODE_GET_POT = 2407;
    public PotCollection potCollection = new PotCollection();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pot_list);

        ListView listView = (ListView) findViewById(R.id.listViewListPots);

        switchToAddPotActivityonClick();
        populateListView(listView);
        //registerOnClickCallback();
    }

    //switch to add pot
    public void switchToAddPotActivityonClick()
    {
        Button button=findViewById(R.id.btnAddPot);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AddPot.makeIntent(PotList.this);
                startActivityForResult(intent, REQUEST_CODE_GET_POT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode) {
            case REQUEST_CODE_GET_POT:
                if(resultCode == Activity.RESULT_OK){
                    String potName = data.getStringExtra("The pot name");
                    int potWeight = data.getIntExtra("The pot weight",0);

                    Pot pot = new Pot(potName, potWeight);
                    potCollection.addPot(pot);

                    Toast.makeText(getApplicationContext(),
                            "My favorite pot is " + pot.getName(),
                            Toast.LENGTH_LONG).show();
                    Log.i("PotApp", "Return successful.");
                } else {
                    Log.i("PotApp", "Add pot activity canceled.");
                }
        }
    }

    private void populateListView(ListView listView) {

        // Instantiate a data collection object
        // ===============  to delete later
        potCollection.addPot(new Pot("Super bowl", 999));
        potCollection.addPot(new Pot("My mini bowl", 1));

        //================


        // Build adaptor
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.pots,
                potCollection.getPotDescriptions());

        // Configure list view
        listView.setAdapter(adapter);
    }

    //switch to calculate serving size activity

    private void registerOnClickCallback() {


    }




}
