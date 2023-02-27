package com.example.higherlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class game extends AppCompatActivity {
    private Button bLower;
    private Button bHigher;
    private ImageView imagenQuestion;
    private ImageView imageAnswer;
    private TextView textAnswer;
    private TextView textQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }
}