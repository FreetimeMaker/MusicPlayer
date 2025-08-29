package com.freetime.musicplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the RecyclerView in the layout
        RecyclerView recyclerView = findViewById(R.id.mainGridRecyclerView);

        // Set up the RecyclerView with a GridLayoutManager (4 columns)
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));

        // Create and set the adapter for the RecyclerView
        recyclerView.setAdapter(new GridAdapter());
    }
}