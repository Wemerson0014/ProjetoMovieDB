package br.com.estudo.projetomoviedb.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetalheFilme {

    private final int id;
    @SerializedName("original_title")
    private final String nomeFilme;
    @SerializedName("overview")
    private final String sinopse;
    @SerializedName("genre")
    private final List<Genero> genero;
    @SerializedName("runtime")
    private final int tempoFilme;
    @SerializedName("vote_average")
    private final float avaliacao;
    @SerializedName("backdrop_path")
    private final String poster;
    @SerializedName("poster_path")
    private final String capa;

    public DetalheFilme(int id, String nomeFilme, String sinopse, List<Genero> genero, int tempoFilme, float avaliacao, String poster, String capa) {
        this.id = id;
        this.nomeFilme = nomeFilme;
        this.sinopse = sinopse;
        this.genero = genero;
        this.tempoFilme = tempoFilme;
        this.avaliacao = avaliacao;
        this.poster = poster;
        this.capa = capa;
    }

    public int getId() {
        return id;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public String getSinopse() {
        return sinopse;
    }

    public List<Genero> getGenero() {
        return genero;
    }

    public int getTempoFilme() {
        return tempoFilme;
    }

    public float getAvaliacao() {
        return avaliacao;
    }

    public String getPoster() {
        return poster;
    }

    public String getCapa() {
        return capa;
    }
}