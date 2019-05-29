package br.com.estudo.projetomoviedb.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseFilmeSimilar {

    @SerializedName("results")
    private List<FilmeSimilar> filmesSimilar;

    public List<FilmeSimilar> getFilmesSimilar() {
        return filmesSimilar;
    }
}
