package com.example.guynever.lista_v1;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TelaInicial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        FloatingActionButton btnInicar = (FloatingActionButton) findViewById(R.id.btnIniciar);
        btnInicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaInicial.this, MenuLateral.class);
                startActivity(intent);
            }
        });
    }
}
