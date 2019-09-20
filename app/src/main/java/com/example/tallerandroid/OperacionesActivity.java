package com.example.tallerandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tallerandroid.operaciones.OperacionesLogica;

import java.util.Random;

public class OperacionesActivity extends AppCompatActivity {
    Random r = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final OperacionesLogica operacionesLogica = new OperacionesLogica();


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operaciones);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        final int ramdomNumber = r.nextInt(4);
        final int n1 = r.nextInt(50);
        final int n2 = r.nextInt(50);

        final EditText resultado = (EditText) findViewById(R.id.txtresultado);
        TextView ope = (TextView) findViewById(R.id.lbloperacion);
        TextView nn1 = (TextView) findViewById(R.id.lbln1);
        TextView nn2 = (TextView) findViewById(R.id.lbln2);
        nn1.setText(String.valueOf(n1));
        nn2.setText(String.valueOf(n2));
        final ImageView feliz = (ImageView) findViewById(R.id.imgfeliz);
        final ImageView triste = (ImageView) findViewById(R.id.imgtriste);

        switch (ramdomNumber) {
            case 0:
                ope.setText("+");

                break;
            case 1:
                ope.setText("-");
                break;
            case 2:
                ope.setText("*");
                break;
            case 3:
                ope.setText("/");
                break;
            default:
                ope.setText("error");
                break;
        }


        findViewById(R.id.btnvalidar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                feliz.setVisibility(View.INVISIBLE);
                triste.setVisibility(View.INVISIBLE);
                operacionesLogica.setNumero1(n1);
                operacionesLogica.setNumero2(n2);
                operacionesLogica.setResultado(Double.parseDouble(resultado.getText().toString()));
                operacionesLogica.setOperacion(ramdomNumber);
                if (operacionesLogica.mate()) {
                    Toast.makeText(OperacionesActivity.this, "correcto", Toast.LENGTH_LONG).show();
                    feliz.setVisibility(View.VISIBLE);


                } else {
                    Toast.makeText(OperacionesActivity.this, "incorrecto", Toast.LENGTH_LONG).show();
                    triste.setVisibility(View.VISIBLE);

                }

            }
        });
        findViewById(R.id.btnregresar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
