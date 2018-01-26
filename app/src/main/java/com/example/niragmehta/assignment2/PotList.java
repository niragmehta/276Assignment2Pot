package com.example.niragmehta.assignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

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

        Button button=findViewById(R.id.btnAddPot);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PotList.this,AddPot.class));
            }
        });


    }


}
