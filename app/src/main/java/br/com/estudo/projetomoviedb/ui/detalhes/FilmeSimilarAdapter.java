package br.com.estudo.projetomoviedb.ui.detalhes;

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
import br.com.estudo.projetomoviedb.ui.OnClickListenerFilmeSimilar;

public class FilmeSimilarAdapter extends RecyclerView.Adapter<FilmeSimilarAdapter.MeuViewHolder> {

    private List<FilmeSimilar> filmeSimilar;
    private OnClickListenerFilmeSimilar onClickListenerFilmeSimilar;

    FilmeSimilarAdapter(List<FilmeSimilar> filmeSimilar, OnClickListenerFilmeSimilar onClickListenerFilmeSimilar) {
        this.filmeSimilar = filmeSimilar;
        this.onClickListenerFilmeSimilar = onClickListenerFilmeSimilar;
    }

    @NonNull
    @Override
    public MeuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemFilmeSimilar = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_filmes_similares, parent, false);
        return new MeuViewHolder(itemFilmeSimilar);
    }

    @Override
    public void onBindViewHolder(@NonNull MeuViewHolder meuViewHolder, int position) {
        FilmeSimilar filmesimilar = this.filmeSimilar.get(position);
        meuViewHolder.configuraFilmeSimilarView(filmesimilar, onClickListenerFilmeSimilar);

    }

    @Override
    public int getItemCount() {
        return filmeSimilar.size();
    }

    class MeuViewHolder extends RecyclerView.ViewHolder {
        ImageView capaSimilar;
        TextView nomeFilmeSimilar;

        MeuViewHolder(@NonNull View itemView) {
            super(itemView);

            capaSimilar = itemView.findViewById(R.id.imageFilmeSimilar);
            nomeFilmeSimilar = itemView.findViewById(R.id.textNomeFilmeSimilar);
        }

        private void configuraFilmeSimilarView(final FilmeSimilar filmeSimilar, final OnClickListenerFilmeSimilar onClickListenerFilmeSimilar) {
            Glide.with(itemView.getContext())
                    .load("https://image.tmdb.org/t/p/w342" + filmeSimilar.getCapaFilmeSimilar())
                    .into(capaSimilar);
            nomeFilmeSimilar.setText(filmeSimilar.getNomeFilmeSimilar());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListenerFilmeSimilar.filmeSimilarCliclado(filmeSimilar);
                }
            });
        }
    }
}