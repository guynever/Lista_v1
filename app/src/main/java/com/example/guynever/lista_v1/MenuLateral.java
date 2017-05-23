package com.example.guynever.lista_v1;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MenuLateral extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    // ============ criaçao de variaveis ====================
    String nome_da_lista;
    ListView minhasListas;
    ArrayList<String> nomedasLista;
    ArrayAdapter<String> adapter;
    EditText edtNomedaLista;

    //======================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_lateral);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


//----------------------Codigo de dialog do botao + da primeira tela de menu -------------------
        FloatingActionButton btnCriar = (FloatingActionButton) findViewById(R.id.criar);
        btnCriar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MenuLateral.this);
                View mView = getLayoutInflater().inflate(R.layout.fragment_criar_nome_da_lista, null);
                Button salvarNomeDaLista = (Button) mView.findViewById(R.id.btnSalvaNomeDaLista);
                edtNomedaLista = (EditText)mView.findViewById(R.id.edtNomedaLista);
                salvarNomeDaLista.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nome_da_lista = edtNomedaLista.getText().toString();
                        nomedasLista.add(nome_da_lista);
                    }
                });
                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // ============ criaçao do listview ==========================
        minhasListas = (ListView) findViewById(R.id.MinhasListas);
        nomedasLista = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nomedasLista);


        minhasListas.setAdapter(adapter);
        //============================================================

    }

    public void onListItemClick (ListView l, View v, int position, long id){

        switch (position) {
            case 0:
                Intent intent = new Intent (this, MinhasLista.class);
                startActivity(intent);

                break;
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lateral, menu);
        return true;
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_minhasListas) {
            Intent intent = new Intent (this, MenuLateral.class);
            startActivity(intent);

        } else if (id == R.id.nav_novaLista) {

            AlertDialog.Builder mBuilder = new AlertDialog.Builder(MenuLateral.this);
            View mView = getLayoutInflater().inflate(R.layout.fragment_criar_nome_da_lista, null);
            final Button salvarNomeDaLista = (Button) mView.findViewById(R.id.btnSalvaNomeDaLista);
            edtNomedaLista = (EditText)mView.findViewById(R.id.edtNomedaLista);
            salvarNomeDaLista.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nome_da_lista = edtNomedaLista.getText().toString();
                    nomedasLista.add(nome_da_lista);
                }
            });
            mBuilder.setView(mView);
            AlertDialog dialog = mBuilder.create();
            dialog.show();

        } else if (id == R.id.nav_favorito) {

        } else if (id == R.id.nav_sobrenos) {
            Intent intent = new Intent(this, SobreNos.class);
            startActivity(intent);
        } else if (id == R.id.nav_configuracao) {
            Toast.makeText(this,"Em desenvolvimento", Toast.LENGTH_SHORT).show();
        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
