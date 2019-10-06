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
import br.com.estudo.projetomoviedb.ui.OnClickListenerFilme;

public class FilmeSimilarAdapter extends RecyclerView.Adapter<FilmeSimilarAdapter.MeuViewHolder> {

    private List<FilmeSimilar> filmeSimilar;
    private OnClickListenerFilme onClickListenerFilme;

    FilmeSimilarAdapter(List<FilmeSimilar> filmeSimilar, OnClickListenerFilme onClickListenerFilme) {
        this.filmeSimilar = filmeSimilar;
        this.onClickListenerFilme = onClickListenerFilme;
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
        meuViewHolder.configuraFilmeSimilarView(filmesimilar, onClickListenerFilme);
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

        private void configuraFilmeSimilarView(final FilmeSimilar filmeSimilar, final OnClickListenerFilme onClickListenerFilme) {
            Glide.with(itemView.getContext())
                    .load("https://image.tmdb.org/t/p/w342" + filmeSimilar.getCapaFilmeSimilar())
                    .into(capaSimilar);
            nomeFilmeSimilar.setText(filmeSimilar.getNomeFilmeSimilar());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListenerFilme.filmeCliclado(filmeSimilar.getIdFilmeSimilar());
                }
            });
        }
    }
}