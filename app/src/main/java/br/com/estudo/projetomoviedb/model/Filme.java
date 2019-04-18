package br.com.estudo.projetomoviedb.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Filme implements Parcelable {

    @SerializedName("poster_path")
    private final String capa;
    @SerializedName("overview")
    private final String sinopse;
    @SerializedName("release_date")
    private final String estreia;
    private final int id;
    @SerializedName("original_title")
    private final String nome;
    @SerializedName("backdrop_path")
    private final String poster;

    public Filme(String capa, String sinopse, String estreia, int id, String nome, String poster) {
        this.capa = capa;
        this.sinopse = sinopse;
        this.estreia = estreia;
        this.id = id;
        this.nome = nome;
        this.poster = poster;
    }

    Filme(Parcel in) {
        capa = in.readString();
        sinopse = in.readString();
        estreia = in.readString();
        id = in.readInt();
        nome = in.readString();
        poster = in.readString();
    }

    public static final Creator<Filme> CREATOR = new Creator<Filme>() {
        @Override
        public Filme createFromParcel(Parcel in) {
            return new Filme(in);
        }

        @Override
        public Filme[] newArray(int size) {
            return new Filme[size];
        }
    };

    public String getCapa() {
        return capa;
    }

    public String getSinopse() {
        return sinopse;
    }

    public String getEstreia() {
        return estreia;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return  nome;
    }

    public String getPoster() {
        return poster;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(capa);
        dest.writeString(sinopse);
        dest.writeString(estreia);
        dest.writeInt(id);
        dest.writeString(nome);
        dest.writeString(poster);
    }
}


