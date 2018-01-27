package com.example.niragmehta.assignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class PotList extends AppCompatActivity {

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
                startActivity (intent);
            }
        });

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
