package com.example.hduar.xatvexo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.hduar.xatvexo.ListViews.AdapterListViewMensagem;
import com.example.hduar.xatvexo.model.Conversa;
import com.example.hduar.xatvexo.model.Seção;

public class TelaChat extends AppCompatActivity {

    private ListView listView;
    private AdapterListViewMensagem adapterListViewMensagem;
    Conversa conversa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_chat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //int id_conversa = getIntent().getIntExtra("id", -1);
        //conversa  = achar_conversa(id_conversa);

        //listView = (ListView) findViewById(R.id.list);
        //createListView();
    }

    /*private Conversa achar_conversa(int id_conversa) {
        for(Conversa conversa : Seção.getUsuario().getConversas()){
            if(conversa.getId() == id_conversa)
                return conversa;
        }
        return null;
    }*/


    /*private void createListView() {

        //Cria o adapter
        adapterListViewMensagem = new AdapterListViewMensagem(this,conversa.getMensagens());

        //Define o Adapter
        listView.setAdapter(adapterListViewMensagem);
        //Cor quando a lista é selecionada para ralagem.
        listView.setCacheColorHint(Color.TRANSPARENT);
    }*/

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handler dos cliques em cada menu
        switch (item.getItemId()) {
            case R.id.mapa:
                Intent i = new Intent(TelaChat.this, TelaMapa.class);
                startActivity(i);
                return true;
            case R.id.ver_perfil:
                Intent intent = new Intent(TelaChat.this, TelaPerfil.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }



}
