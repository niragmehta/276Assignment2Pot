package com.example.niragmehta.assignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PotList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pot_list);

        Button button=findViewById(R.id.btnAddPot);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PotList.this,AddPot.class));
            }
        });

        pupulateListView();
        registerOnClickCallback();
    }

    private void pupulateListView() {
        // Create a list of item
        // Instantiate a data collection object
        PotCollection potCollection = new PotCollection();


        // ===============
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

    private void registerOnClickCallback() {
        final ListView listView = (ListView) findViewById(R.id.listViewListPots);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long is) {
                TextView textView = (TextView) viewClicked;
                String message = "Pot #" + position
                        + " " + textView.getText().toString();
            }
        });

    }
}
