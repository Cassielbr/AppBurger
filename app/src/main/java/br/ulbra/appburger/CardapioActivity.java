package br.ulbra.appburger;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CardapioActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CardapioAdapter adapter;
    private List<Produto> produtos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardapio);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        produtos = new ArrayList<>();
        inicializarProdutos();

        adapter = new CardapioAdapter(produtos, this);
        recyclerView.setAdapter(adapter);
    }

    private void inicializarProdutos() {
        produtos.add(new Produto("Hambúrguer Clássico", "Hambúrguer suculento com queijo e alface.", R.drawable.hamburguer_classico, 10.0));
        produtos.add(new Produto("Cheeseburger", "Hambúrguer com uma camada extra de queijo.", R.drawable.cheeseburger, 12.0));
        produtos.add(new Produto("Bacon Burger", "Hambúrguer com fatias crocantes de bacon.", R.drawable.bacon_burger, 15.0));
        produtos.add(new Produto("Veggie Burger", "Hambúrguer à base de plantas, saboroso e saudável.", R.drawable.veggie_burger, 11.0));
        produtos.add(new Produto("Refrigerante Cola", "Refrigerante sabor cola, refrescante.", R.drawable.refrigerante_cola, 5.0));
        produtos.add(new Produto("Refrigerante Limonada", "Refrigerante sabor limão, perfeito para o verão.", R.drawable.refrigerante_limonada, 4.5));
        produtos.add(new Produto("Refrigerante Laranja", "Refrigerante sabor laranja, doce e cítrico.", R.drawable.refrigerante_laranja, 4.0));
        produtos.add(new Produto("Refrigerante Guaraná", "Refrigerante sabor guaraná, refrescante e energético.", R.drawable.refrigerante_guarana, 4.5));
    }
}
