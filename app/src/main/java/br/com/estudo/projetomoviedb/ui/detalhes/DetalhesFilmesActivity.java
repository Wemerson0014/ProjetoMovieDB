package br.com.estudo.projetomoviedb.ui.detalhes;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

import java.util.List;
import java.util.Objects;

import br.com.estudo.projetomoviedb.R;
import br.com.estudo.projetomoviedb.model.DetalheFilme;
import br.com.estudo.projetomoviedb.model.FilmeSimilar;
import br.com.estudo.projetomoviedb.model.Genero;
import br.com.estudo.projetomoviedb.model.ResponseFilmeSimilar;
import br.com.estudo.projetomoviedb.network.RetrofitConfiguracao;
import br.com.estudo.projetomoviedb.ui.OnClickListenerFilme;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalhesFilmesActivity extends AppCompatActivity {

    public static final String EXTRA_ID_FIME = "extra_id_filme";
    private String homepage;
    public static final int CONTEUDO_DETALHES = 1;
    private ViewFlipper viewFlipperDetalhes;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_filme);

        int idFilme = getIntent().getIntExtra(EXTRA_ID_FIME, -1);

        viewFlipperDetalhes = findViewById(R.id.viewFlipperDetalhes);

        configuraToolbar();
        buscaDetalheFilmePorId(idFilme);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_detalhe_filme, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.compartilhar) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(homepage));
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void configuraBotaoCompartilhar(String homepage) {
        if (homepage != null){
            toolbar.getMenu().findItem(R.id.compartilhar).setVisible(true);
        }
    }

    private void configuraToolbar() {
        toolbar = findViewById(R.id.toolbar_detalhes);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void configuraLayout(DetalheFilme detalheFilme) {

        final ImageView poster;
        TextView sinopse;
        ImageView capa;
        TextView avaliacao;
        TextView nome;
        TextView duracao;
        TextView genero;

        sinopse = findViewById(R.id.textSinopse);
        poster = findViewById(R.id.imagePoster);
        capa = findViewById(R.id.imageCapa);
        avaliacao = findViewById(R.id.textAvaliacao);
        nome = findViewById(R.id.textNome);
        duracao = findViewById(R.id.textDuracaoFilme);
        genero = findViewById(R.id.textGenero);


        sinopse.setText(detalheFilme.getSinopse());
        Glide.with(this)
                .load("https://image.tmdb.org/t/p/w300" + detalheFilme.getPoster())
                .placeholder(R.drawable.ic_cinema)
                .into(new CustomTarget<Drawable>() {
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        poster.setBackground(resource);
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {

                    }
                });

        Glide.with(this)
                .load("https://image.tmdb.org/t/p/w342" + detalheFilme.getCapa())
                .into(capa);
        avaliacao.setText((detalheFilme.getAvaliacao() + ("/10")));
        nome.setText(detalheFilme.getNomeFilme());
        duracao.setText((detalheFilme.getTempoFilme() + (" minutos")));
        genero.setText(generoFormatado(detalheFilme.getGeneros()));

    }

    private String generoFormatado(List<Genero> generos) {

        StringBuilder nomeGenero = new StringBuilder();
        for (int i = 0; i < generos.size(); i++) {
            nomeGenero.append(generos.get(i).getNome()).append(", ");
        }
        return nomeGenero.substring(0, nomeGenero.length() - 2);
    }

    private void buscaDetalheFilmePorId(final int idFilme) {

        Call<DetalheFilme> call = new RetrofitConfiguracao().apiservice().getDetalheFilmePorId(idFilme);
        call.enqueue(new Callback<DetalheFilme>() {
            @Override
            public void onResponse(Call<DetalheFilme> call, Response<DetalheFilme> response) {
                if (response.isSuccessful() && response.body() != null) {
                    DetalheFilme detalheFilme = response.body();
                    homepage = detalheFilme.getPaginaDoFilme();
                    configuraBotaoCompartilhar(homepage);
                    configuraLayout(detalheFilme);
                    buscaFilmeSimilar(idFilme);
                }
                viewFlipperDetalhes.setDisplayedChild(CONTEUDO_DETALHES);
            }

            @Override
            public void onFailure(Call<DetalheFilme> call, Throwable t) {
                Toast.makeText(DetalhesFilmesActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void configuraFilmeSimilares(final List<FilmeSimilar> filmeSimilar) {

        final RecyclerView recyclerView = findViewById(R.id.recyclerFilmeSimilar);
        final TextView filmesSimilares = findViewById(R.id.textFilmesSimilares);

        FilmeSimilarAdapter filmeSimilarAdapter = new FilmeSimilarAdapter(filmeSimilar, new OnClickListenerFilme() {
            @Override
            public void filmeCliclado(int id) {
                Intent intent = new Intent(getApplicationContext(), DetalhesFilmesActivity.class);
                intent.putExtra(EXTRA_ID_FIME, id);
                startActivity(intent);
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(filmeSimilarAdapter);

        filmesSimilares.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    private void buscaFilmeSimilar(int idFilmeSimilar) {

        Call<ResponseFilmeSimilar> call = new RetrofitConfiguracao().apiservice().getFilmeSimilares(idFilmeSimilar);
        call.enqueue(new Callback<ResponseFilmeSimilar>() {
            @Override
            public void onResponse(Call<ResponseFilmeSimilar> call, Response<ResponseFilmeSimilar> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ResponseFilmeSimilar responseFilmeSimilar = response.body();
                    if (!responseFilmeSimilar.getFilmesSimilar().isEmpty()) {
                        configuraFilmeSimilares(responseFilmeSimilar.getFilmesSimilar());
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseFilmeSimilar> call, Throwable t) {
                Toast.makeText(DetalhesFilmesActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}