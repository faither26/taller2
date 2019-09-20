package com.example.tallerandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Porsentajes1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_porsentajes1);

        findViewById(R.id.btnpromedio).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Porsentajes1Activity.this,PromedioActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btnporsentaje).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Porsentajes1Activity.this,PorsentajeActivity.class);
                startActivity(intent);
            }
        });

    }
}
