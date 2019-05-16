package br.com.estudo.projetomoviedb.principal;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import br.com.estudo.projetomoviedb.R;
import br.com.estudo.projetomoviedb.model.FilmeSimilar;

public class FilmeSimilarAdapter extends RecyclerView.Adapter<FilmeSimilarAdapter.MyViewHolder> {

    private List<FilmeSimilar> filmeSimilar;

    public FilmeSimilarAdapter(List<FilmeSimilar> filmeSimilar) {
        this.filmeSimilar = filmeSimilar;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemFilmeSimilar = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_filmes_similares, parent, false);
        return new MyViewHolder(itemFilmeSimilar);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        FilmeSimilar filmesimilar = this.filmeSimilar.get(position);
        myViewHolder.configuraFilmeSimilarView(filmesimilar);

    }

    @Override
    public int getItemCount() {
        return filmeSimilar.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView capaSimilar;
        TextView nomeFilmeSimilar;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);

            capaSimilar = itemView.findViewById(R.id.imageFilmeSimilar);
            nomeFilmeSimilar = itemView.findViewById(R.id.textNomeFilmeSimilar);
        }

        private void configuraFilmeSimilarView(final FilmeSimilar filmeSimilar) {
            Glide.with(itemView.getContext())
                    .load("https://image.tmdb.org/t/p/w342" + filmeSimilar.getCapaFilmeSimilar())
                    .into(capaSimilar);
            nomeFilmeSimilar.setText(filmeSimilar.getNomeFilmeSimilar());
        }
    }
}