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
        setContentView(R.layout.activity_game);

        //Relacionamos todas las variables.
        imageQuestion = (ImageView) findViewById(R.id.imagenQuestion);
        imageAnswer = (ImageView) findViewById(R.id.imageAnswer);

        bLower = (Button) findViewById(R.id.bLower);
        bHigher = (Button) findViewById(R.id. bHigher);

        textAnswer = (TextView) findViewById(R.id.textAnswer);
        textQuestion = (TextView) findViewById(R.id.textQuestion);

        //Añadimos todas las preguntas
        preguntes = new Pregunta[]{
                new Pregunta(R.string.question1,R.string.total1, R.drawable.logo_),
                new Pregunta(R.string.question2,R.string.total2, R.drawable.logo_),
                new Pregunta(R.string.question3,R.string.total3, R.drawable.logo_),
                new Pregunta(R.string.question4,R.string.total4, R.drawable.logo_),
                new Pregunta(R.string.question5,R.string.total5, R.drawable.logo_),
                new Pregunta(R.string.question6,R.string.total6, R.drawable.logo_),
                new Pregunta(R.string.question7,R.string.total7, R.drawable.logo_),
                new Pregunta(R.string.question8,R.string.total8, R.drawable.logo_),
                new Pregunta(R.string.question9,R.string.total9, R.drawable.logo_),
                new Pregunta(R.string.question10,R.string.total10, R.drawable.logo_)
        };

        first_update_preguntes();

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

    }

    //Comprueba si es correcto
    public void checkPregunta(int boto_id) {
        //Caso correcto
        if (preguntes[index].getResposta_correcte() == boto_id){
            int temp = index;
            update_preguntes();
            if (Integer.parseInt(getString(preguntes[index].getTotal())) > Integer.parseInt(getString(preguntes[temp].getTotal()))){
                preguntes[index].setResposta_correcte(1);
            }
            else{
                preguntes[index].setResposta_correcte(0);
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
        imageQuestion.setImageResource(preguntes[index].getImagen());
        textQuestion.setText("\"" + getString(preguntes[index].getPregunta()) + "\"\n" + getString(R.string.answer_extra) + "\n" + num_view(getString(preguntes[index].getTotal())) + "\n" + getString(R.string.answer_extra2) );

        int temp = index;
        while (index == temp){
            Random rand = new Random();
            temp = rand.nextInt(preguntes.length);
        }
        index = temp;

        imageAnswer.setImageResource(preguntes[index].getImagen());

//        textAnswer.setText("\"" + getString(preguntes[index].getPregunta()) + "\"\n" + getString(R.string.answer_extra) + "\n" + getString(preguntes[index].getTotal()) + "\n" + getString(R.string.answer_extra2) );
        textAnswer.setText("\"" + getString(preguntes[index].getPregunta()) + "\"\n" + getString(R.string.answer_extra));
    }

    public void first_update_preguntes(){

        Random rand = new Random();


        int temp = rand.nextInt(preguntes.length);

        imageQuestion.setImageResource(preguntes[temp].getImagen());
        textQuestion.setText("\"" + getString(preguntes[temp].getPregunta()) + "\"\n" + getString(R.string.answer_extra) + "\n" + num_view(getString(preguntes[temp].getTotal())) + "\n" + getString(R.string.answer_extra2) );

        index = temp;

        while (index == temp){
            index = rand.nextInt(preguntes.length);
        }

        imageAnswer.setImageResource(preguntes[index].getImagen());
//        textAnswer.setText("\"" + getString(preguntes[index].getPregunta()) + "\"\n" + getString(R.string.answer_extra) + "\n" + getString(preguntes[index].getTotal()) + "\n" + getString(R.string.answer_extra2) );
        textAnswer.setText("\"" + getString(preguntes[index].getPregunta()) + "\"\n" + getString(R.string.answer_extra));

        if (Integer.parseInt(getString(preguntes[index].getTotal())) > Integer.parseInt(getString(preguntes[temp].getTotal()))){
            preguntes[index].setResposta_correcte(1);
        }
        else{
            preguntes[index].setResposta_correcte(0);
        }
    }
    public String num_view (String number){

        int temp = Integer.parseInt (number);
        String a = "";
        while (temp >= 1000){
            int num = temp % 1000;
            temp = temp/1000;
            if(num == 0){
                a = ",000" + a;
            }
            else if(num < 10){
                a = ",00" + String.valueOf(num) + a;
            }
            else if (num < 100){
                a = ",0" + String.valueOf(num) + a;
            }
        }
        if (temp != 0) {
            a = String.valueOf(temp) + a;
        }

        return a;
    }
}