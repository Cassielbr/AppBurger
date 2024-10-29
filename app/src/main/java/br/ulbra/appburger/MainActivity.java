package br.ulbra.appburger;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText edEmail, edSenha;
    private Button btEntrar, btCriarConta;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(this);
        edEmail = findViewById(R.id.edemail);
        edSenha = findViewById(R.id.edsenha);
        btEntrar = findViewById(R.id.btentar);
        btCriarConta = findViewById(R.id.btcriar_conta);

        btEntrar.setOnClickListener(v -> login());
        btCriarConta.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Cadastro.class);
            startActivity(intent);
        });
    }

    private void login() {
        String email = edEmail.getText().toString().trim();
        String senha = edSenha.getText().toString().trim();

        // Verifica se os campos estão preenchidos
        if (email.isEmpty() || senha.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Verifica o usuário no banco de dados
        try {
            if (dbHelper.verificarUsuario(email, senha)) {
                Toast.makeText(this, "Login bem-sucedido!", Toast.LENGTH_SHORT).show();
                // Redireciona para a CardapioActivity
                Intent intent = new Intent(MainActivity.this, CardapioActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Email ou senha incorretos!", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Erro ao realizar login: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
