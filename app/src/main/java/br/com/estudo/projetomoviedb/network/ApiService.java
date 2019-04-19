package br.com.estudo.projetomoviedb.network;
import br.com.estudo.projetomoviedb.model.ResponseFilme;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("movie/upcoming?api_key=32ac19108cbd4e2a9c931a3f403b1b14")
    Call<ResponseFilme> getTodosFilmes();
}