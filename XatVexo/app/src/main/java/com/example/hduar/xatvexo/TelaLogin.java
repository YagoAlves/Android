package com.example.hduar.xatvexo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hduar.xatvexo.acess.RestLocais;
import com.example.hduar.xatvexo.acess.RestUsuario;
import com.example.hduar.xatvexo.model.Conversa;
import com.example.hduar.xatvexo.model.Locais;
import com.example.hduar.xatvexo.model.Seção;
import com.example.hduar.xatvexo.model.Usuario;
import com.example.hduar.xatvexo.model.Usuario2;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TelaLogin extends Activity {

    private EditText editTextUsuario;
    private EditText editTextSenha;
    private Button buttonLogin;
    //private Button buttonLoginF;
    private TextView cadastrarTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        //ArrayList<Usuario> usuarios = getIntent().getParcelableArrayListExtra("usuarios");
        //final ArrayList<Usuario> users = usuarios;

        editTextUsuario = (EditText) findViewById(R.id.usuarioTextView);
        editTextSenha = (EditText) findViewById(R.id.senhaTextView);
        buttonLogin = (Button) findViewById(R.id.loginButton);
       // buttonLoginF = (Button) findViewById(R.id.faceButton);
        cadastrarTextView = (TextView) findViewById(R.id.cadastrarTextView);

        cadastrarTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrar();
            }
        });
        
        buttonLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                login();
            }
        });



    }

    /*public void startService(View view){
        Log.d("Service", "Service Iniciou");
        Intent it = new Intent();
        startService(it);
    }

    public void stopService(View view){
        Log.d("Service", "Service Parou");
        Intent it = new Intent();
        stopService(it);
    }*/

    private void cadastrar() {
        Intent i = new Intent(TelaLogin.this, TelaCadastrar.class);
        startActivity(i);
    }

    /*private ArrayList<Usuario> criarAmigos(){
        ArrayList<Usuario> amigos = new ArrayList<>();
        Usuario item1 = new Usuario(amigos.size(), "(88)99680-9637", "123", "h.duarte222@gmail.com", "Yagu");
        item1.setImagemRid(R.drawable.user);
        amigos.add(item1);
        Usuario item2 = new Usuario(amigos.size(), "(88)99680-9637", "123", "h.duarte222@gmail.com", "Pedro");
        item2.setImagemRid(R.drawable.user);
        amigos.add(item2);
        Usuario item3 = new Usuario(amigos.size(), "(88)99680-9637", "123", "h.duarte222@gmail.com", "Maria");
        item3.setImagemRid(R.drawable.user);
        amigos.add(item3);
        Usuario item4 = new Usuario(amigos.size(), "(88)99680-9637", "123", "h.duarte222@gmail.com", "João");
        item4.setImagemRid(R.drawable.user);
        amigos.add(item4);
        Usuario item5 = new Usuario(amigos.size(), "(88)99680-9637", "123", "h.duarte222@gmail.com", "Carla");
        item5.setImagemRid(R.drawable.user);
        amigos.add(item5);
        Usuario item6 = new Usuario(amigos.size(), "(88)99680-9637", "123", "h.duarte222@gmail.com", "Danielly");
        item6.setImagemRid(R.drawable.user);
        amigos.add(item6);
        Usuario item7 = new Usuario(amigos.size(), "(88)99680-9637", "123", "h.duarte222@gmail.com", "Julia");
        item7.setImagemRid(R.drawable.user);
        amigos.add(item7);

        return amigos;
    }*/

    /*public ArrayList<Conversa> criarConversas(){
        ArrayList<Conversa> conversas = new ArrayList<>();
        ArrayList<Usuario> usuarios = Seção.getUsuario().getAmigos();

        Conversa item1 = new Conversa(1, Seção.getUsuario(), "Conversa 1", null);
        ArrayList<Usuario> participantes = new ArrayList<>();
        participantes.add(usuarios.get(0));
        item1.setParticipantes(participantes);
        item1.setImagemRid(usuarios.get(0).getImagemRid());
        conversas.add(item1);

        Conversa item2 = new Conversa(2, Seção.getUsuario(), "Grupo 1", null);
        item2.setParticipantes(usuarios);
        item2.setImagemRid(usuarios.get(0).getImagemRid());
        conversas.add(item2);

        Conversa item3 = new Conversa(3, Seção.getUsuario(), "Conversa 2", null);
        ArrayList<Usuario> participantes2 = new ArrayList<>();
        participantes.add(usuarios.get(1));
        item3.setParticipantes(participantes2);
        item3.setImagemRid(usuarios.get(1).getImagemRid());
        conversas.add(item3);

        return conversas;

    }*/

    private void logado(String usuario){

        try {

            JSONObject object = new JSONObject(usuario);
            Usuario2 u = new Usuario2();
            u.setNome(object.getString("nome"));
            u.setTelefone(object.getInt("telefone"));
            u.setEmail(object.getString("email"));
            u.setId(object.getInt("id"));

            Seção.setUsuario(u);
            RestLocais rl = new RestLocais();

            //List<Locais> fav = rl.getFavoritos("http://192.168.1.107:8080/WSTrabAndroid/webresources/generic/Locais/favoritos",u);
            //List<Locais> loc = rl.getLocais("http://192.168.1.107:8080/WSTrabAndroid/webresources/generic/Locais/get");

            Intent i = new Intent(TelaLogin.this, TelaPrincipal.class);
            startActivity(i);

            /*ArrayList<Usuario>amigos = criarAmigos();
            u.setAmigos(amigos);
            Seção.setUsuario(u);
            ArrayList<Conversa>conversas = criarConversas();
            u.setConversas(conversas);
            Seção.setUsuario(u);*/

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void login() {
        String usuario = editTextUsuario.getText().toString();
        String senha = editTextSenha.getText().toString();

        /*if (logado(usuarios, usuario, senha)){
            Intent i = new Intent(TelaLogin.this, TelaPrincipal.class);
            TelaLogin/ext(TelaLogin.this, "Usuário não existe", Toast.LENGTH_SHORT).show();
        }*/

        RestUsuario ar = new RestUsuario();
        String resul = ar.login(usuario,senha,"http://10.0.53.55:8080/TrabalhoFinal/webresources/generic/Usuario/autentica");
        Log.i("POST Login", resul);

        if(resul == null) {
            Toast.makeText(TelaLogin.this, "Usuario não existe", Toast.LENGTH_SHORT).show();
        }else {
            logado(resul);
        }

    }
}