package br.com.estudo.projetomoviedb.network;

import br.com.estudo.projetomoviedb.model.DetalheFilme;
import br.com.estudo.projetomoviedb.model.FilmeSimilar;
import br.com.estudo.projetomoviedb.model.ResponseFilme;
import br.com.estudo.projetomoviedb.model.ResponseFilmeSimilar;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("movie/upcoming")
    Call<ResponseFilme> getTodosFilmes();

    @GET("movie/{movie_id}")
    Call<DetalheFilme> getDetalheFilmePorId(@Path("movie_id") int idFilme);

    @GET("movie/{movie_id}/similar")
    Call<ResponseFilmeSimilar> getFilmeSimilares(@Path("movie_id") int idFilmeSimilar);
}