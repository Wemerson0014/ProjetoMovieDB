package br.com.estudo.projetomoviedb.ui.principal;

import br.com.estudo.projetomoviedb.R;
import br.com.estudo.projetomoviedb.model.Filme;
import br.com.estudo.projetomoviedb.ui.OnClickListenerFilme;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.bumptech.glide.Glide;

public class FilmesAdapter extends RecyclerView.Adapter<FilmesAdapter.MeuViewHolder> {

    private List<Filme> filmes;
    private OnClickListenerFilme onClickListenerFilme;

    FilmesAdapter(List<Filme> filmes, OnClickListenerFilme onClickListenerFilme) {
        this.filmes = filmes;
        this.onClickListenerFilme = onClickListenerFilme;
    }

    @NonNull
    @Override
    public MeuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View itemFilme = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_filmes, parent, false);
        return new MeuViewHolder(itemFilme);
    }

    @Override
    public void onBindViewHolder(@NonNull MeuViewHolder meuViewHolder, int position) {

        Filme filme = this.filmes.get(position);
        meuViewHolder.configuraView(filme, onClickListenerFilme);
    }

    @Override
    public int getItemCount() {
        return filmes.size();
    }

    class MeuViewHolder extends RecyclerView.ViewHolder {

        TextView nome;
        TextView estreia;
        ImageView capa;

        MeuViewHolder(@NonNull View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.textNome);
            estreia = itemView.findViewById(R.id.textEstreia);
            capa = itemView.findViewById(R.id.imageCapa);
        }

        private void configuraView(final Filme filme, final OnClickListenerFilme onClickListenerFilme) {
            nome.setText(filme.getNome());
            estreia.setText(getDataFormatada(filme.getEstreia()));
            Glide.with(itemView.getContext())
                    .load("https://image.tmdb.org/t/p/w342" + filme.getCapa())
                    .into(capa);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListenerFilme.filmeCliclado(filme.getId());
                }
            });
        }
    }

    private String getDataFormatada(String dataEstreia) {
        String dataFormatada;
        try {
            Date date = new SimpleDateFormat("y-MM-dd", Locale.getDefault()).parse(dataEstreia);
            dataFormatada = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(date);
        } catch (ParseException e) {
            dataFormatada = dataEstreia;
        }
        return dataFormatada;
    }
}