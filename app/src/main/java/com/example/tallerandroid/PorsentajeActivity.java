package com.example.tallerandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tallerandroid.model.Notas;
import com.example.tallerandroid.promedio.promedio2.NotasPorsentajeLogica;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.auth.FirebaseAuth;

import static java.lang.Double.*;

public class PorsentajeActivity extends AppCompatActivity {
    private EditText nota;
    private int a = 0;
    private int b = 100;
    private double porsentaje = 0;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final NotasPorsentajeLogica notasPorsentajeLogica = new NotasPorsentajeLogica();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_porsentaje);
        nota = findViewById(R.id.txtnota);
        TextView lbl = findViewById(R.id.textView4);
        final EditText cantidad = findViewById(R.id.txtcantidad);
        final TextView lblresultado = findViewById(R.id.textView5);
        final EditText porsentajess = findViewById(R.id.txtporsentaje);
        final EditText documento = findViewById(R.id.txtnombre);
        firebaseAuth = FirebaseAuth.getInstance();

        inicializarFirebase();


        findViewById(R.id.btningresar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.txtcantidad).setVisibility(View.INVISIBLE);
                findViewById(R.id.btningresar).setVisibility(View.INVISIBLE);
                findViewById(R.id.btnenviar).setVisibility(View.VISIBLE);
                findViewById(R.id.txtnota).setVisibility(View.VISIBLE);
                findViewById(R.id.txtporsentaje).setVisibility(View.VISIBLE);
                findViewById(R.id.txtnombre).setVisibility(View.VISIBLE);

            }
        });

        findViewById(R.id.btnenviar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                porsentaje = (parseDouble(porsentajess.getText().toString()) / 100) * Integer.parseInt(nota.getText().toString());
                Notas notas = new Notas();
                notas.setNota(String.valueOf(porsentaje));
                if (b > 0) {
                    if (a < Integer.parseInt(cantidad.getText().toString())) {
                        b = b - Integer.parseInt(porsentajess.getText().toString());

                        notasPorsentajeLogica.setCantidad(Integer.parseInt(cantidad.getText().toString()));
                        notasPorsentajeLogica.setNotaa(porsentaje);
                        notasPorsentajeLogica.calcularPorsentaje();
                        nota.setText("");
                        porsentajess.setText("");
                        lblresultado.setText(String.valueOf(notasPorsentajeLogica.getNotaa()));

                        a++;
                        databaseReference.child(documento.getText().toString()).child("nota" + a).setValue(notas);


                        if (a == Integer.parseInt(cantidad.getText().toString())) {
                            findViewById(R.id.txtnota).setEnabled(false);
                            findViewById(R.id.btnenviar).setEnabled(false);
                            lblresultado.setText(String.valueOf(notasPorsentajeLogica.calcularPorsentaje()));

                            notas.setPromedio(lblresultado.getText().toString());
                            databaseReference.child(documento.getText().toString()).child("promedio").setValue(lblresultado.getText().toString());
                        }
                    }

                } else {
                    Toast.makeText(PorsentajeActivity.this, "porsentaje incorrecto", Toast.LENGTH_LONG).show();
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
