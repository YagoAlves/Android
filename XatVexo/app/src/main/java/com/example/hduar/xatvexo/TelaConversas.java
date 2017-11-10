package com.example.hduar.xatvexo;

import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hduar.xatvexo.ListViews.AdapterListViewConversa;
import com.example.hduar.xatvexo.model.Conversa;
import com.example.hduar.xatvexo.model.Mensagem;
import com.example.hduar.xatvexo.model.Seção;
import com.example.hduar.xatvexo.model.Usuario;

import java.util.ArrayList;

/**
 * Created by hduar on 05/11/2016.
 */
public class TelaConversas extends Fragment implements AdapterView.OnItemClickListener {

    private ListView listView;
    private AdapterListViewConversa adapterListViewConversa;
    private ArrayList<Conversa> conversas = new ArrayList<Conversa>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.activity_tela_conversas, container, false);


        //pegar conversas e setar no array de conversas

        if(conversas.isEmpty()) {
            return view;
        }

        //Pega a referencia do ListView
        listView = (ListView) view.findViewById(R.id.list);
        //Define o Listener quando alguem clicar no item.
        listView.setOnItemClickListener(this);
        createListView();

        return view;
    }

    private void createListView() {

        //Cria o adapter
        adapterListViewConversa = new AdapterListViewConversa(getContext(),conversas);

        //Define o Adapter
        listView.setAdapter(adapterListViewConversa);
        //Cor quando a lista é selecionada para ralagem.
        listView.setCacheColorHint(Color.TRANSPARENT);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Pega o item que foi selecionado.
        Conversa item = adapterListViewConversa.getItem(position);
        Intent i = new Intent(getActivity(), TelaChat.class);
        i.putExtra("id", item.getId());
        startActivity(i);
        //Demostração
        Toast.makeText(getActivity(), "Você Clicou em: " + item.getTitulo(), Toast.LENGTH_LONG).show();
    }


}
