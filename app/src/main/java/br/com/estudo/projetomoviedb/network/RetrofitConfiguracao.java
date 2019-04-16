package br.com.estudo.projetomoviedb.network;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfiguracao {

    private HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

    private OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(logging.setLevel(HttpLoggingInterceptor.Level.BODY))
            .build();

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build();

    public ApiService apiservice() {
        return retrofit.create(ApiService.class);
    }
}