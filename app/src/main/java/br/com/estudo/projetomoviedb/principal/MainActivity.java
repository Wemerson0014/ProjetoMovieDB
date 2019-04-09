package br.com.estudo.projetomoviedb.principal;
import br.com.estudo.projetomoviedb.R;
import br.com.estudo.projetomoviedb.model.Filmes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Filmes> filmes = Arrays.asList(
            new Filmes ("Estrada sem lei", "2h 12m", "https://image.tmdb.org/t/p/w342/2RZSE3RgHuc6kTbbF5Pt0ODUcTM.jpg"),
            new Filmes("Cemiterio Maldito", "1h 40m", "https://image.tmdb.org/t/p/w342/3VPZYf1UEiXcwHqySBqQYT3dHmc.jpg"),
            new Filmes("Capitã Marvel", "2h 04m", "https://image.tmdb.org/t/p/w342/AtsgWhDnHTq68L0lLsUrCnM7TjG.jpg"),
            new Filmes("Nós", "2h 0m", "https://image.tmdb.org/t/p/w342/ux2dU1jQ2ACIMShzB3yP93Udpzc.jpg"),
            new Filmes("Bumblebee", "1h 54m", "https://image.tmdb.org/t/p/w342/fw02ONlDhrYjTSZV8XO6hhU3ds3.jpg"),
            new Filmes("A Mula", "1h 56m", "https://image.tmdb.org/t/p/w342/oeZh7yEz3PMnZLgBPhrafFHRbVz.jpg" ),
            new Filmes("Shazam", "2h 12m", "https://image.tmdb.org/t/p/w342/b8YcWHlkHdDJqTZazG7ksCyMBuF.jpg"),
            new Filmes("Vidro", "2h 09m", "https://image.tmdb.org/t/p/w342/jpz1x6YLFWqWfnGD8h3lQe1ZpDT.jpg"),
            new Filmes("Escape Room", "1h 39m", "https://image.tmdb.org/t/p/w342/15AlGTlaZa3W2zmIL4ehnCh8Xe0.jpg"));



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configuraRecyclerView();

    }

    public void configuraRecyclerView(){

        final RecyclerView recyclerView = findViewById(R.id.recyclerFilmes);

        FilmesAdapter filmesAdapter = new FilmesAdapter(filmes);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 3);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(filmesAdapter);

    }
}