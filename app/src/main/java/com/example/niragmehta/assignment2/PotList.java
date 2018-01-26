package com.example.niragmehta.assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PotList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pot_list);

        PotCollection potCollection=new PotCollection();

        ArrayAdapter<Pot> adapter=new ArrayAdapter<Pot>(
                this,
                R.layout.activity_pot_list,
                potCollection.getPots()
        );

        ListView listView=findViewById(R.id.listViewListPots);
        listView.setAdapter(adapter);

    }


}
