package br.com.estudo.projetomoviedb.detalhes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import br.com.estudo.projetomoviedb.R;
import br.com.estudo.projetomoviedb.model.DetalheFilme;
import br.com.estudo.projetomoviedb.network.RetrofitConfiguracao;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalhesFilmesActivity extends AppCompatActivity {

    public static final String EXTRA_ID_FIME = "extra_id_filme";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_filme);

        int idFilme = getIntent().getIntExtra(EXTRA_ID_FIME, -1);
        buscaDetalheFilmePorId(idFilme);
    }

    public void configuraLayout(DetalheFilme detalheFilme) {

        ImageView poster;
        TextView nome;
        TextView sinopse;

        poster = findViewById(R.id.imagePoster);
        nome = findViewById(R.id.textNome);
        sinopse = findViewById(R.id.textSinopse);

        Glide.with(this)
                .load("https://image.tmdb.org/t/p/w300" + detalheFilme.getCapa())
                .placeholder(R.drawable.ic_cinema)
                .into(poster);
        nome.setText(detalheFilme.getNomeFilme());
        sinopse.setText(detalheFilme.getSinopse());
    }

    public void buscaDetalheFilmePorId(int idFilme) {

        Call<DetalheFilme> call = new RetrofitConfiguracao().apiservice().getDetalheFilmePorId(idFilme);
        call.enqueue(new Callback<DetalheFilme>() {
            @Override
            public void onResponse(Call<DetalheFilme> call, Response<DetalheFilme> response) {
                if (response.isSuccessful() && response.body() != null) {
                    DetalheFilme detalheFilme = response.body();
                    configuraLayout(detalheFilme);
                }
            }

            @Override
            public void onFailure(Call<DetalheFilme> call, Throwable t) {
                Toast.makeText(DetalhesFilmesActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}