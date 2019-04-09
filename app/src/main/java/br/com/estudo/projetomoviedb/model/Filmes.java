package br.com.estudo.projetomoviedb.model;

public class Filmes {

    private final String nome;
    private final String duracao;
    private final String capa;

    public String getNome() {
        return nome;
    }

    public String getDuracao() {
        return duracao;
    }

    public String getCapa() {
        return capa;
    }

    public Filmes(String nome, String duracao, String capa) {
        this.nome = nome;
        this.duracao = duracao;
        this.capa = capa;
    }
}