package br.com.estudo.projetomoviedb.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseFilme {

    @SerializedName("results")
    private List<Filme> filmes;

    public List<Filme> getFilmes() {
        return filmes;
    }
}