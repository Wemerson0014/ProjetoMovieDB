package br.com.estudo.projetomoviedb.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetalheFilme {

    private final int id;
    @SerializedName("title")
    private final String nomeFilme;
    @SerializedName("overview")
    private final String sinopse;
    @SerializedName("genres")
    private final List<Genero> generos;
    @SerializedName("runtime")
    private final int tempoFilme;
    @SerializedName("vote_average")
    private final float avaliacao;
    @SerializedName("backdrop_path")
    private final String poster;
    @SerializedName("poster_path")
    private final String capa;
    @SerializedName("homepage")
    private final String paginaDoFilme;

    public DetalheFilme(int id, String nomeFilme, String sinopse, List<Genero> generos, int tempoFilme, float avaliacao, String poster, String capa, String paginaDoFilme) {
        this.id = id;
        this.nomeFilme = nomeFilme;
        this.sinopse = sinopse;
        this.generos = generos;
        this.tempoFilme = tempoFilme;
        this.avaliacao = avaliacao;
        this.poster = poster;
        this.capa = capa;
        this.paginaDoFilme = paginaDoFilme;
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

    public List<Genero> getGeneros() {
        return generos;
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

    public String getPaginaDoFilme() {
        return paginaDoFilme;
    }
}