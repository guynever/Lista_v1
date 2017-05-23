package com.example.guynever.lista_v1;

/**
 * Created by Guynever on 23/05/2017.
 */

public class Lista {
    private String nomeLista;
    private String nomeProduto;
    private double preco;

public Lista() {
}

public Lista(String nomeLista){
    this.setNomeLista(nomeLista);
}

public Lista(String nomeProduto,double preco){
    this.setNomeProduto(nomeProduto);
    this.setPreco(preco);
}


    public String getNomeLista() {
        return nomeLista;
    }

    public void setNomeLista(String nomeLista) {
        this.nomeLista = nomeLista;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}



