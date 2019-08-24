package br.com.estudo.projetomoviedb.network;

import br.com.estudo.projetomoviedb.BuildConfig;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfiguracao {

    private OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(getNovaUrl())
            .addInterceptor(getLogging())
            .build();

    private Interceptor getLogging() {
        return new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    private Interceptor getNovaUrl() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                HttpUrl novaUrl = chain.request().url().newBuilder()
                        .addQueryParameter("api_key", BuildConfig.API_KEY)
                        .addQueryParameter("language", BuildConfig.LANGUAGE)
                        .build();
                return chain.proceed(chain.request().newBuilder().url(novaUrl).build());
            }
        };
    }

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build();

    public ApiService apiservice() {
        return retrofit.create(ApiService.class);
    }
}