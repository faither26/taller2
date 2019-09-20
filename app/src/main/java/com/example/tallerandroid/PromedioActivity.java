package com.example.tallerandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tallerandroid.model.Notas;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.FirebaseApp;


import com.example.tallerandroid.promedio.promedio1.PromedioLogica;

public class PromedioActivity extends AppCompatActivity {
    private EditText nota;
    private int a = 0;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final PromedioLogica promedioLogica = new PromedioLogica();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promedio);
        nota = findViewById(R.id.txtnota);
        final TextView lbl = findViewById(R.id.textView);
        final EditText cantidad = findViewById(R.id.txtcantidad);
        final TextView lblresultado = findViewById(R.id.textView2);
        final EditText documento = findViewById(R.id.txtnombre);
        firebaseAuth = FirebaseAuth.getInstance();


        inicializarFirebase();
        findViewById(R.id.btningresar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                findViewById(R.id.btnenviar).setVisibility(View.VISIBLE);
                findViewById(R.id.txtnota).setVisibility(View.VISIBLE);
                findViewById(R.id.btningresar).setVisibility(View.INVISIBLE);
                findViewById(R.id.txtcantidad).setVisibility(View.INVISIBLE);
                findViewById(R.id.txtnombre).setVisibility(View.VISIBLE);
                lbl.setText("ingresar nota");
            }
        });


        findViewById(R.id.btnenviar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Notas notas = new Notas();
                notas.setNota(nota.getText().toString());

                if (a < Integer.parseInt(cantidad.getText().toString())) {
                    promedioLogica.setCantidad(Integer.parseInt(cantidad.getText().toString()));
                    promedioLogica.setNotas(Double.parseDouble(nota.getText().toString()));
                    promedioLogica.calcular();
                    nota.setText("");
                    lblresultado.setText(String.valueOf(promedioLogica.getNotas()));

                    a++;
                    databaseReference.child(documento.getText().toString()).child("nota" + a).setValue(notas);

                    if (a == Integer.parseInt(cantidad.getText().toString())) {
                        findViewById(R.id.txtnota).setEnabled(false);
                        findViewById(R.id.btnenviar).setEnabled(false);
                        lblresultado.setText(String.valueOf(promedioLogica.calcular()));

                        notas.setPromedio(lblresultado.getText().toString());
                        databaseReference.child(documento.getText().toString()).child("promedio").setValue(lblresultado.getText().toString());
                    }
                }

            }
        });


    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }


}
