package com.example.hduar.xatvexo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hduar.xatvexo.acess.RestUsuario;
import com.example.hduar.xatvexo.model.Usuario;
import com.example.hduar.xatvexo.model.Usuario2;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TelaCadastrar extends Activity {

    private EditText editTextUsuario;
    private EditText editTextSenha;
    private EditText editTextEmail;
    private EditText editTextTelefone;
    private Button buttonCadastro;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastrar);

        editTextUsuario = (EditText) findViewById(R.id.usuarioTextView);
        editTextSenha = (EditText) findViewById(R.id.senhaEditText);
        editTextEmail = (EditText) findViewById(R.id.emailEditText);
        editTextTelefone = (EditText) findViewById(R.id.telefoneEditText);
        buttonCadastro = (Button) findViewById(R.id.cadastroButton);


        ArrayList<Usuario> usuarios = getIntent().getParcelableArrayListExtra("usuarios");
        final ArrayList<Usuario> users = usuarios;

        buttonCadastro.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                cadastrar(users);
            }
        });
    }

    private void cadastrar(ArrayList<Usuario> usuarios) {

        final String usuario = editTextUsuario.getText().toString();
        final String senha = editTextSenha.getText().toString();
        final String email = editTextEmail.getText().toString();
        final String telefone = editTextTelefone.getText().toString();

        if(usuario.isEmpty() || senha.isEmpty() || email.isEmpty()
                || telefone.isEmpty()) {
            Toast.makeText(TelaCadastrar.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
        }else {

            Usuario2 usuario1 = new Usuario2();
            usuario1.setNome(usuario);
            usuario1.setEmail(email);
            usuario1.setSenha(senha);
            usuario1.setTelefone(Integer.parseInt(telefone));

            RestUsuario ra = new RestUsuario();

            ra.cadastraUsuario("http://10.0.53.55:8080/TrabalhoFinal/webresources/generic/Usuario/inserir",usuario1);
            //usuarios.add(usuario1);

            Toast.makeText(TelaCadastrar.this, "Cadastro Realizado", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(TelaCadastrar.this, TelaLogin.class);
            i.putParcelableArrayListExtra("usuarios",usuarios);
            startActivity(i);
        }


    }
}
