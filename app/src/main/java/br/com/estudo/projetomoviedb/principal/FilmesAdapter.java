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

    FilmesAdapter(List<Filme> filmes){
        this.filmes = filmes;
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
        meuViewHolder.configuraView(filme);
    }

    @Override
    public int getItemCount() {
        return filmes.size();
    }

    class MeuViewHolder extends RecyclerView.ViewHolder {

        TextView nome;
        TextView duracao;
        ImageView capa;

        MeuViewHolder(@NonNull View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.textNome);
            duracao = itemView.findViewById(R.id.textDuracao);
            capa = itemView.findViewById(R.id.imagemCapa);
        }

        private void configuraView(final Filme filme){
            nome.setText(filme.getNome());
            duracao.setText(filme.getEstreia());
            Glide.with(itemView.getContext())
                    .load("https://image.tmdb.org/t/p/w342" + filme.getCapa())
                    .into(capa);
        }
    }
}