package com.example.ex_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Stark Button - when clicked goes to Stark Screen
    Button starkBtn = findViewById(R.id.starkButton);
    starkBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), StarkScreen.class);
            startActivity(intent);
           // startActivity(new Intent(v.getContext(), StarkScreen.class));
        }

    });

        // Lannister Button - when clicked goes to Lannister Screen
        Button lannisterBtn = findViewById(R.id.lannisterButton);

        lannisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(v.getContext(), LannisterScreen.class);
                startActivity(intent);
            }
        });
   }
}