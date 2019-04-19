package br.com.estudo.projetomoviedb.model;
import com.google.gson.annotations.SerializedName;

public class Filme {

    private final int id;
    @SerializedName("original_title")
    private final String nome;
    @SerializedName("poster_path")
    private final String capa;
    @SerializedName("release_date")
    private final String estreia;

    public Filme(int id, String nome, String capa, String estreia) {
        this.id = id;
        this.nome = nome;
        this.capa = capa;
        this.estreia = estreia;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCapa() {
        return capa;
    }

    public String getEstreia() {
        return estreia;
    }
}


