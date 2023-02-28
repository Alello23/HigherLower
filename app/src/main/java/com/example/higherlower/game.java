package com.example.higherlower;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.color.utilities.Score;

import java.util.Random;

public class game extends AppCompatActivity {
    private ImageView imageQuestion;
    private ImageView imageAnswer;
    private Button bLower;
    private Button bHigher;
    private TextView textAnswer;
    private TextView textQuestion;
    private int index = 1;
    private Pregunta[] preguntes;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Relacionamos todas las variables.
        imageQuestion = (ImageView) findViewById(R.id.imagenQuestion);
        imageAnswer = (ImageView) findViewById(R.id.imageAnswer);

        bLower = (Button) findViewById(R.id.bLower);
        bHigher = (Button) findViewById(R.id. bHigher);

        textAnswer = (TextView) findViewById(R.id.textAnswer);
        textQuestion = (TextView) findViewById(R.id.textQuestion);

        //Añadimos todas las preguntas
        preguntes = new Pregunta[]{
                new Pregunta(R.string.question1,R.string.total1),
                new Pregunta(R.string.question2,R.string.total2),
                new Pregunta(R.string.question3,R.string.total3),
                new Pregunta(R.string.question4,R.string.total4)
        };

        //Esperamos a la accion de un boton.
        bLower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkPregunta(0);
            }
        });

        bHigher.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                checkPregunta(1);
            }
        });

        setContentView(R.layout.activity_game);
    }

    //Comprueba si es correcto
    public void checkPregunta(int boto_id) {
        //Caso correcto
        if (preguntes[index-1].getResposta_correcte() == boto_id){
            int temp = index;
            update_preguntes();
            if (Integer.parseInt(getString(preguntes[index - 1].getTotal())) > Integer.parseInt(getString(preguntes[temp - 1].getTotal()))){
                preguntes[index - 1].setResposta_correcte(1);
            }
            else{
                preguntes[index - 1].setResposta_correcte(0);
            }
            score++;
        }
        //Caso Incorrecto
        else {
            Intent intent = new Intent(game.this, Credits.class);
            intent.putExtra("Score", score);
            startActivity(intent);
            finish();
        }
    }
    public void update_preguntes(){
        imageAnswer.setImageResource(preguntes[index - 1].getImagen());
        textAnswer.setText("\"" + getString(preguntes[index - 1].getPregunta()) + "\"\n" + getString(R.string.answer_extra) + "\n" + getString(preguntes[index - 1].getTotal()) + "\n" + getString(R.string.answer_extra2) );

        int temp = index;
        while (index == temp){
            Random rand = new Random();
            temp = rand.nextInt(preguntes.length);
        }
        index = temp;

        imageQuestion.setImageResource(preguntes[index - 1].getImagen());
        textQuestion.setText("\"" + getString(preguntes[index - 1].getPregunta()) + "\"\n" + getString(R.string.answer_extra));
    }
}