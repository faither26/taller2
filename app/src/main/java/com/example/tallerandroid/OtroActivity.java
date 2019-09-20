package com.example.tallerandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tallerandroid.otro.OtroLogica;

import java.util.Random;

public class OtroActivity extends AppCompatActivity {
    Random r = new Random();
    OtroLogica otroLogica = new OtroLogica();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otro);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        final String[] preguntas = new String[15];
        final String[] respuestas = new String[15];
        preguntas[0] = "cual es el lugar mas fio de la tierra?";
        respuestas[0] = "la antartida";
        preguntas[1] = "quien escribio la odisea?";
        respuestas[1] = "homero";
        preguntas[2] = "cual es el rio mas largo del mudo?";
        respuestas[2] = "el amazonas";
        preguntas[3] = "como se llama la reina del reino unido?";
        respuestas[3] = "isabel ll";
        preguntas[4] = "que tipo de animal es la ballena?";
        respuestas[4] = "mamifero";
        preguntas[5] = "cual es la cantidad de huesos que posee el cuerpo humano?";
        respuestas[5] = "206";
        preguntas[6] = "cuando acabo la segunda guerra mundial?";
        respuestas[6] = "1945";
        preguntas[7] = "en que pais se encuentra la torre de pizza?";
        respuestas[7] = "italia";
        preguntas[8] = "como se denomina el resultado de la multiplicacion?";
        respuestas[8] = "producto";
        preguntas[9] = "cual es el oceano mas grande?";
        respuestas[9] = "pacifico";
        preguntas[10] = "cual es el pais mas grande del mundo?";
        respuestas[10] = "rusia";
        preguntas[11] = "donde se encuentra la famosa torre eiffel";
        respuestas[11] = "francia";
        preguntas[12] = "en que año comenso la segunda guerra mundial?";
        respuestas[12] = "1939";
        preguntas[13] = "cual es el tercer olaneta en el sistema solar";
        respuestas[13] = "tierra";
        preguntas[14] = "cual es el pais mas poblado de la tierra";
        respuestas[14] = "china";


        final int ramdom = r.nextInt(15);
        final TextView pregunta = findViewById(R.id.txtpregunta);
        final EditText respuesta = findViewById(R.id.txtrespuesta);

        pregunta.setText(preguntas[ramdom] + ramdom);


        findViewById(R.id.btnverificar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                otroLogica.setPreguntas(respuestas[ramdom]);
                otroLogica.setRespuestas(respuesta.getText().toString());

                if (otroLogica.validacion() == 0) {
                    Toast.makeText(OtroActivity.this, "correcto", Toast.LENGTH_LONG).show();

                } else if (otroLogica.validacion() == 1) {
                    Toast.makeText(OtroActivity.this, "incorrecto", Toast.LENGTH_LONG).show();

                }

            }
        });


        findViewById(R.id.btnsalir).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}

