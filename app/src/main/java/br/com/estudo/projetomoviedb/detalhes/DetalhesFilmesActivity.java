package br.com.estudo.projetomoviedb.detalhes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import br.com.estudo.projetomoviedb.R;
import br.com.estudo.projetomoviedb.model.Filme;

public class DetalhesFilmesActivity extends AppCompatActivity {

    public static final String EXTRA_FIME = "extra_filme";

    Filme filme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_filme);

        filme = getIntent().getParcelableExtra(EXTRA_FIME);
        CriaLayout();
    }

    public void CriaLayout(){

        ImageView poster;
        TextView nome;
        TextView sinopse;

        poster = findViewById(R.id.imagePoster);
        nome = findViewById(R.id.textNome);
        sinopse = findViewById(R.id.textSinopse);

        Glide.with(this)
                .load("https://image.tmdb.org/t/p/w300" + filme.getPoster())
                .placeholder(R.drawable.ic_cinema)
                .into(poster);
        nome.setText(filme.getNome());
        sinopse.setText(filme.getSinopse());
    }
}
