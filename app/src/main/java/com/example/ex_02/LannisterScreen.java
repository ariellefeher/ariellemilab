package com.example.ex_02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class LannisterScreen extends AppCompatActivity {
        RecyclerView recyclerView;
    RecyclerView.Adapter programAdapter;
    RecyclerView.LayoutManager layoutManager;

    String[] programNameList = {"Tywin Lannister", "Tyrion Lannister", "Cersei Lannister", "Jaime Lannister", "Joffrey Lannister", "Tommen Lannister", "Myrcella Lannister"};
    int[] programImages = {R.drawable.tywin, R.drawable.tyrion,  R.drawable.cersei,  R.drawable.jaime,  R.drawable.joffrey,  R.drawable.tommen,  R.drawable.myrcella};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lannister_screen);

        recyclerView = findViewById(R.id.lannisterList);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        programAdapter = new ListAdapter(this, programNameList, programImages);
        recyclerView.setAdapter(programAdapter);
    }
}