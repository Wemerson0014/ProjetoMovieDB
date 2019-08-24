package br.com.estudo.projetomoviedb.model;

import com.google.gson.annotations.SerializedName;

public class FilmeSimilar {

    @SerializedName("id")
    private final int idFilmeSimilar;
    @SerializedName("poster_path")
    private final String capaFilmeSimilar;
    @SerializedName("title")
    private final String nomeFilmeSimilar;

    public FilmeSimilar(int idFilmeSimilar, String capaFilmeSimilar, String nomeFilmeSimilar) {
        this.idFilmeSimilar = idFilmeSimilar;
        this.capaFilmeSimilar = capaFilmeSimilar;
        this.nomeFilmeSimilar = nomeFilmeSimilar;
    }

    public int getIdFilmeSimilar() {
        return idFilmeSimilar;
    }

    public String getCapaFilmeSimilar() {
        return capaFilmeSimilar;
    }

    public String getNomeFilmeSimilar() {
        return nomeFilmeSimilar;
    }
}
