package br.com.estudo.projetomoviedb.principal;
import br.com.estudo.projetomoviedb.R;
import br.com.estudo.projetomoviedb.model.Filme;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import com.bumptech.glide.Glide;

public class FilmesAdapter extends RecyclerView.Adapter<FilmesAdapter.MeuViewHolder> {

    private List<Filme> filmes;
    private OnClickListener onClickListener;

    FilmesAdapter(List<Filme> filmes , OnClickListener onClickListener) {
        this.filmes = filmes;
        this.onClickListener = onClickListener;
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
        meuViewHolder.configuraView(filme, onClickListener);
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

        private void configuraView(final Filme filme , final OnClickListener onClickListener){
            nome.setText(filme.getNome());
            estreia.setText(filme.getEstreia());
            Glide.with(itemView.getContext())
                    .load("https://image.tmdb.org/t/p/w342" + filme.getCapa())
                    .into(capa);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.filmeCliclado(filme);
                }
            });
        }
    }
}