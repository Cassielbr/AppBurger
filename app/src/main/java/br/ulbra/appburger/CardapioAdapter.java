package br.ulbra.appburger;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardapioAdapter extends RecyclerView.Adapter<CardapioAdapter.ViewHolder> {
    private List<Produto> produtos;
    private Context context;

    public CardapioAdapter(List<Produto> produtos, Context context) {
        this.produtos = produtos;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardapio, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Produto produto = produtos.get(position);
        holder.textNome.setText(produto.getNome());
        holder.textDescricao.setText(produto.getDescricao());
        holder.imageProduto.setImageResource(produto.getImagemId());

        // Redireciona para a tela de detalhes do produto ao clicar
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ProdutoDetailActivity.class);
            intent.putExtra("produto", produto.getNome());
            intent.putExtra("descricao", produto.getDescricao());
            intent.putExtra("preco", produto.getPreco());
            intent.putExtra("imagemId", produto.getImagemId()); // Passando a imagem
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textNome;
        public TextView textDescricao;
        public ImageView imageProduto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textNome = itemView.findViewById(R.id.textNome);
            textDescricao = itemView.findViewById(R.id.textDescricao);
            imageProduto = itemView.findViewById(R.id.imageProduto);
        }
    }
}
