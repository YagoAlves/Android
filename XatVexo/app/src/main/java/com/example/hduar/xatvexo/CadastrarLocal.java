package com.example.hduar.xatvexo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hduar.xatvexo.acess.RestLocais;
import com.example.hduar.xatvexo.model.Locais;
import com.example.hduar.xatvexo.model.Seção;

/**
 * Created by yago_alves on 08/12/16.
 */
public class CadastrarLocal extends AppCompatActivity{

    private EditText editTextNome;
    private EditText editTextEndereco;
    private Button buttonCadastro;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_local);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editTextNome = (EditText) findViewById(R.id.nome);
        editTextEndereco = (EditText) findViewById(R.id.endereco);
        buttonCadastro = (Button) findViewById(R.id.cadastroButton);

        buttonCadastro.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Locais l = new Locais();
                l.setEndereco(editTextEndereco.getText().toString());
                l.setNome(editTextNome.getText().toString());
                l.setLongitude(Seção.getLoc().getLongitude());
                l.setLatitude(Seção.getLoc().getLatitude());

                RestLocais rl = new RestLocais();
                rl.inserirLocal("http://10.0.53.55:8080/TrabalhoFinal/webresources/generic/Locais/AdicionarLocal", l);
                Toast.makeText(CadastrarLocal.this, "Local cadastrado com sucesso", Toast.LENGTH_SHORT).show();
            }
        });



    }


}
