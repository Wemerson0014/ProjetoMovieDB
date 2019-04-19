package br.com.estudo.projetomoviedb.model;
import com.google.gson.annotations.SerializedName;

class Genero {
    private final int id;
    @SerializedName("name")
    private final String nome;

    public Genero(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
