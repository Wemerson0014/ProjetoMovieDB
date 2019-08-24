package br.com.estudo.projetomoviedb.ui.principal;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.List;

import br.com.estudo.projetomoviedb.R;
import br.com.estudo.projetomoviedb.ui.detalhes.DetalhesFilmesActivity;
import br.com.estudo.projetomoviedb.model.Filme;
import br.com.estudo.projetomoviedb.model.ResponseFilme;
import br.com.estudo.projetomoviedb.network.ApiService;
import br.com.estudo.projetomoviedb.network.RetrofitConfiguracao;
import br.com.estudo.projetomoviedb.ui.OnClickListenerFilme;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static br.com.estudo.projetomoviedb.ui.detalhes.DetalhesFilmesActivity.EXTRA_ID_FIME;

public class MainActivity extends AppCompatActivity {

    public static final int CONTEUDO_PRINCIPAL = 1;
    private ViewFlipper viewFlipperPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewFlipperPrincipal = findViewById(R.id.viewFlipperPrincipal);

        configuraToolbar();
        buscaFilmes();
    }

    private void configuraToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.text_toolbar_principal);
        setSupportActionBar(toolbar);
    }

    public void configuraRecyclerView(final List<Filme> filmes) {

        final RecyclerView recyclerView = findViewById(R.id.recyclerFilmes);

        FilmesAdapter filmesAdapter = new FilmesAdapter(filmes, new OnClickListenerFilme() {
            @Override
            public void filmeCliclado(int id) {
                Intent intent = new Intent(getApplicationContext(), DetalhesFilmesActivity.class);
                intent.putExtra(EXTRA_ID_FIME, id);
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
                    List<Filme> filmes = response.body().getFilmes();
                    configuraRecyclerView(filmes);
                    viewFlipperPrincipal.setDisplayedChild(CONTEUDO_PRINCIPAL);
                }
            }

            @Override
            public void onFailure(Call<ResponseFilme> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}