package com.example.higherlower;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button bStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bStart = (Button) findViewById(R.id.bStart);

        bStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, game.class);
                intent.putExtra("Extra_Resposta_Correcte", 4);
                startActivityForResult(intent, 4);
            }
        });
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (resultCode != Activity.RESULT_OK){
            return;
        }
        if (requestCode == 4){
            if (data == null){
                return;
            }
            Boolean haMiratResposta = data.getBooleanExtra("RESPOSTA_MIRADA",false);
        }
    }
}