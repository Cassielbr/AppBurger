package br.ulbra.appburger;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Cadastro extends AppCompatActivity {
    private EditText edNome, edEmail, edSenha, edTelefone;
    private Button btCadastrar, btCancelar;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);

        dbHelper = new DBHelper(this);
        edNome = findViewById(R.id.ednome);
        edEmail = findViewById(R.id.edemail);
        edSenha = findViewById(R.id.edsenha);
        edTelefone = findViewById(R.id.edtelefone);
        btCadastrar = findViewById(R.id.btcadastrar);
        btCancelar = findViewById(R.id.btcancelar_cadastro);

        btCadastrar.setOnClickListener(v -> cadastrar());
        btCancelar.setOnClickListener(v -> finish());
    }

    private void cadastrar() {
        String nome = edNome.getText().toString().trim();
        String email = edEmail.getText().toString().trim();
        String senha = edSenha.getText().toString().trim();
        String telefone = edTelefone.getText().toString().trim();

        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || telefone.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            return;
        }

        dbHelper.adicionarUsuario(nome, email, senha, telefone);
        Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Cadastro.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
