package com.example.ex_02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class StarkScreen extends AppCompatActivity {
        RecyclerView recyclerView;
        RecyclerView.Adapter programAdapter;
        RecyclerView.LayoutManager layoutManager;

        String[] programNameList = {"Ned Stark", "Catelyn Stark", "Robb Stark", "Jon Snow", "Sansa Stark", "Arya Stark", "Bran Stark"};
        int[] programImages = {R.drawable.ned, R.drawable.catelyn,  R.drawable.robb,  R.drawable.jonsnow,  R.drawable.sansa,  R.drawable.arya,  R.drawable.bran};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stark_screen);

        recyclerView = findViewById(R.id.starkList);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        programAdapter = new ListAdapter(this, programNameList, programImages);
        recyclerView.setAdapter(programAdapter);
    }
}