package br.ulbra.appburger;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ProdutoDetailActivity extends AppCompatActivity {

    private TextView textNomeProduto, textDescricaoProduto, textPrecoProduto, textPrecoTotal;
    private Button btnComprar, btnVoltar;
    private ImageView imageProdutoDetail;
    private double precoProduto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto_detail);

        textNomeProduto = findViewById(R.id.textNomeProduto);
        textDescricaoProduto = findViewById(R.id.textDescricaoProduto);
        textPrecoProduto = findViewById(R.id.textPrecoProduto);
        textPrecoTotal = findViewById(R.id.textPrecoTotal);
        btnComprar = findViewById(R.id.btnComprar);
        btnVoltar = findViewById(R.id.btnVoltar);
        imageProdutoDetail = findViewById(R.id.imageProdutoDetail);
        ImageButton btnWhatsApp = findViewById(R.id.btnWhatsApp);

        // Obtendo dados do produto
        String nomeProduto = getIntent().getStringExtra("produto");
        String descricaoProduto = getIntent().getStringExtra("descricao");
        precoProduto = getIntent().getDoubleExtra("preco", 0.0);
        int imagemId = getIntent().getIntExtra("imagemId", 0);

        // Configurando as views
        textNomeProduto.setText(nomeProduto);
        textDescricaoProduto.setText(descricaoProduto);
        textPrecoProduto.setText(String.format("Preço: R$ %.2f", precoProduto));
        imageProdutoDetail.setImageResource(imagemId);

        // Configurando o botão Voltar
        btnVoltar.setOnClickListener(v -> finish());

        // Configurando o botão Comprar
        btnComprar.setOnClickListener(v -> {
            double precoTotal = precoProduto;
            textPrecoTotal.setText(String.format("Total: R$ %.2f", precoTotal));
            Toast.makeText(this, "Produto comprado!", Toast.LENGTH_SHORT).show();
        });

        // Configurando o botão do WhatsApp
        btnWhatsApp.setOnClickListener(v -> {
            String mensagem = "Olá, quero saber mais sobre " + nomeProduto;
            Intent whatsappIntent = new Intent(Intent.ACTION_VIEW);
            whatsappIntent.setData(Uri.parse("https://api.whatsapp.com/send?phone=YOUR_PHONE_NUMBER&text=" + Uri.encode(mensagem)));
            startActivity(whatsappIntent);
        });
    }
}
