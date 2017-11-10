package com.example.hduar.xatvexo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hduar.xatvexo.acess.RestUsuario;
import com.example.hduar.xatvexo.model.Seção;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hduar on 06/11/2016.
 */
public class TelaPerfil extends AppCompatActivity {

    private ImageView imageView;

    private TextView nome;
    private TextView email;
    private TextView telefone;
    private static int RESULT_LOAD_IMAGE = 1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_perfil);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imageView = (ImageView) findViewById(R.id.imageView1);
        nome = (TextView) findViewById(R.id.nome);
        email = (TextView) findViewById(R.id.email);
        telefone = (TextView) findViewById(R.id.telefone);

        /*RestUsuario ra = new RestUsuario();
        String resul = ra.get("http://192.168.129.125:8080/ExemploServer/webresources/generic/Usuario/get");

        try {

        JSONObject obj = new JSONObject(resul);
            nome.setText(obj.getString("nome_completo"));
            telefone.setText(obj.getString("idade"));

        } catch (JSONException e) {
            e.printStackTrace();
        }*/

        nome.setText(Seção.getUsuario().getNome());
        email.setText(Seção.getUsuario().getEmail());
        telefone.setText("88-999999");

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TelaPerfil.this, TelaFoto.class);
                startActivity(i);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handler dos cliques em cada menu
        switch (item.getItemId()) {
            case R.id.mapa:
                Intent i = new Intent(TelaPerfil.this, TelaMapa.class);
                startActivity(i);
                return true;
            case R.id.ver_perfil:
                Intent intent = new Intent(TelaPerfil.this, TelaPerfil.class);
                startActivity(intent);
                return true;
            case R.id.cadastrar_local:
                Intent intent2 = new Intent(TelaPerfil.this, CadastrarLocal.class);
                startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
