package br.com.estudo.projetomoviedb.principal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.List;

import br.com.estudo.projetomoviedb.R;
import br.com.estudo.projetomoviedb.detalhes.DetalhesFilmesActivity;
import br.com.estudo.projetomoviedb.model.Filme;
import br.com.estudo.projetomoviedb.model.ResponseFilme;
import br.com.estudo.projetomoviedb.network.ApiService;
import br.com.estudo.projetomoviedb.network.RetrofitConfiguracao;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static br.com.estudo.projetomoviedb.detalhes.DetalhesFilmesActivity.EXTRA_ID_FIME;

public class MainActivity extends AppCompatActivity {

    public static final int PRGRESSBAR_PRINCIPAL = 0;
    public static final int CONTEUDO_PRINCIPAL = 1;
    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewFlipper = findViewById(R.id.viewFlipperPrincipal);
        viewFlipper.setDisplayedChild(PRGRESSBAR_PRINCIPAL);
        buscaFilmes();

    }

    public void configuraRecyclerView(List<Filme> filmes) {

        final RecyclerView recyclerView = findViewById(R.id.recyclerFilmes);

        FilmesAdapter filmesAdapter = new FilmesAdapter(filmes, new OnClickListener() {
            @Override
            public void filmeCliclado(Filme filme) {
                Intent intent = new Intent(getApplicationContext(), DetalhesFilmesActivity.class);
                intent.putExtra(EXTRA_ID_FIME, filme.getId());
                startActivity(intent);
            }
        });

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 3);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(filmesAdapter);

    }

    public void buscaFilmes() {

        ApiService apiService = new RetrofitConfiguracao().apiservice();
        Call<ResponseFilme> call = apiService.getTodosFilmes();

        call.enqueue(new Callback<ResponseFilme>() {
            @Override
            public void onResponse(Call<ResponseFilme> call, Response<ResponseFilme> response) {
                if (response.isSuccessful() && response.body() != null) {
                    viewFlipper.setDisplayedChild(CONTEUDO_PRINCIPAL);
                    List<Filme> filmes = response.body().getFilmes();
                    configuraRecyclerView(filmes);
                }
            }

            @Override
            public void onFailure(Call<ResponseFilme> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}