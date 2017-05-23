package com.example.guynever.lista_v1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MinhasLista extends AppCompatActivity {

    ListView listadeProdutos;
    ArrayList<EditText> produtos;
    ArrayAdapter<EditText> adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minhas_lista);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listadeProdutos = (ListView) findViewById(R.id.listProduto);
        produtos = new ArrayList<>();
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, produtos);


        listadeProdutos.setAdapter(adapter);


        FloatingActionButton btnCriarProduto = (FloatingActionButton) findViewById(R.id.CriarProduto);
        btnCriarProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MinhasLista.this);
                View mView = getLayoutInflater().inflate(R.layout.fragment_criar_nome_da_lista, null);
                final EditText edtproduto = (EditText)mView.findViewById(R.id.produto);
                final EditText edtpreco = (EditText)mView.findViewById(R.id.preco);
                Button salvarProdutos = (Button) mView.findViewById(R.id.btnSalvarItens);
                salvarProdutos.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        produtos.add(edtproduto);
                    }
                });
                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        });
    }

}
