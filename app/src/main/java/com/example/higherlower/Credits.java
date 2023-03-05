package com.example.higherlower;

import android.content.*;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Credits extends AppCompatActivity {

    private Button bReturn;
    private Button bNewGame;
    private EditText editTextUsername;
    private TextView scoreTextView;
    private TextView rankingTextView;
    private int score;
    private String ranking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        // Obtener una referencia al botón Atrás
        bReturn = findViewById(R.id.breturn);

        // Obtener una referencia al botón New Game
        bNewGame = findViewById(R.id.newGame);

        // Obtener una referencia al control EditText
        editTextUsername = findViewById(R.id.user);

        // Obtener una referencia al control TextView que muestra la puntuación
        scoreTextView = findViewById(R.id.score);

        // Obtener una referencia al control TextView que muestra la clasificación
        rankingTextView = findViewById(R.id.ranking);

        // Recibir los parámetros de puntuación del juego aprobados
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            ranking = extras.getString("ranking");
            score = extras.getInt("Score");
            // Mostrar la puntuación en TextView
            scoreTextView.setText(getString(R.string.score) + score);
        }

        // agregar evento de clic para el botón Atrás
        bReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Crea un objeto Intent para volver al juego
                Intent data = new Intent();
                data.putExtra("RESPOSTA MIRADA", 3);
                setResult(RESULT_OK, data);
                finish();
            }
        });

        // Agregue un evento de clic para el botón Nuevo juego
        bNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Crea un objeto Intent para volver a StartGameActivity
                Intent intent = new Intent(Credits.this, game.class);
                finish();
                startActivity(intent);
            }
        });

        // Agregar un evento de clic para el botón de enviar
        Button submitButton = findViewById(R.id.submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener el contenido del texto en EditText
                String username = editTextUsername.getText().toString();

                int ranking = score;

                ranking_add(ranking, username);

                // guardar nombre de usuario, puntaje y rango

                Toast.makeText(Credits.this, "submit！", Toast.LENGTH_SHORT).show();

                // Crea un objeto Intent para regresar a MainActivity
                finish();
            }
        });
        // mostrar rango de usuario
        ranking_set();
    }
    private void ranking_add(int ranking, String user){
//        try {
//            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
//                    context.openFileOutput("ranking", Context.MODE_PRIVATE));
//            outputStreamWriter.write(user + "   " + Integer.toString(ranking));
//            outputStreamWriter.close();
//        } catch (IOException e) {
//            Log.e("Exception", "Error al escribir en el archivo: " + e.toString());
//        }
        this.ranking = this.ranking + user + "   " + Integer.toString(ranking) + "\n";

    }
    private void ranking_set (){
//        String temp = "";
//        try {
//            InputStream inputStream = context.openFileInput("ranking");
//            if (inputStream != null) {
//                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//                String receiveString;
//                StringBuilder stringBuilder = new StringBuilder();
//                while ((receiveString = bufferedReader.readLine()) != null) {
//                    stringBuilder.append(receiveString);
//                }
//                inputStream.close();
//                String contenido = stringBuilder.toString();
//            }
//        } catch (FileNotFoundException e) {
//            Log.e("Exception", "Archivo no encontrado: " + e.toString());
//        } catch (IOException e) {
//            Log.e("Exception", "Error al leer el archivo: " + e.toString());
//        }

        rankingTextView.setText(getString(R.string.ranking) + "\n" + ranking);
    }
}
