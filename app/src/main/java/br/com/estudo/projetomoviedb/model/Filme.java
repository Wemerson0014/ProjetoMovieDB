package br.com.estudo.projetomoviedb.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Filme implements Parcelable {

    @SerializedName("original_title")
    private final String nome;
    @SerializedName("release_date")
    private final String estreia;
    @SerializedName("poster_path")
    private final String capa;
    private final Boolean video;
    @SerializedName("overview")
    private final String sinopse;
    @SerializedName("imdb_id")
    private final String imdb;

    private Filme(Parcel in) {
        nome = in.readString();
        estreia = in.readString();
        capa = in.readString();
        byte tmpVideo = in.readByte();
        video = tmpVideo == 0 ? null : tmpVideo == 1;
        sinopse = in.readString();
        imdb = in.readString();
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

    public String getNome() {
        return nome;
    }

    public String getEstreia() {
        return estreia;
    }

    public String getCapa() {
        return capa;
    }

    public Boolean getVideo() { return  video; }

    public String getSinopse() { return  sinopse; }

    public String getImdb() { return  imdb; }

    public Filme(String nome, String estreia, String capa, Boolean video, String sinopse, String imdb) {
        this.nome = nome;
        this.estreia = estreia;
        this.capa = capa;
        this.video = video;
        this.sinopse = sinopse;
        this.imdb = imdb;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(estreia);
        dest.writeString(capa);
        dest.writeValue(video);
        dest.writeString(sinopse);
        dest.writeString(imdb);
    }
}