package com.example.niragmehta.assignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class PotList extends AppCompatActivity {

    public static final int REQUEST_CODE_POT = 2412;
    public PotCollection potCollection = new PotCollection();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pot_list);

        ListView listView = (ListView) findViewById(R.id.listViewListPots);

        switchActivityOnClick();
        populateListView();
        //registerOnClickCallback();

    }

    public void switchActivityOnClick(){

    }

    //switch to add pot
    public void switchActivityonClick()
    {
        Button button=findViewById(R.id.btnAddPot);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AddPot.makeIntent(PotList.this);//new Intent(PotList.this, AddPot.class);
                startActivityForResult(intent, REQUEST_CODE_POT);
            }
        });

    }



    private void populateListView() {

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
        ListView listView = (ListView) findViewById(R.id.listViewListPots);
        listView.setAdapter(adapter);
    }

    //switch to calculate serving size activity

    private void registerOnClickCallback() {


    }




}
