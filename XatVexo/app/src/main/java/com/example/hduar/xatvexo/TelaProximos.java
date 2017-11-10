package com.example.hduar.xatvexo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hduar.xatvexo.ListViews.AdapterListViewLocais;
import com.example.hduar.xatvexo.acess.RestLocais;
import com.example.hduar.xatvexo.model.Locais;
import com.example.hduar.xatvexo.model.Seção;
import com.example.hduar.xatvexo.model.Usuario;
import com.example.hduar.xatvexo.model.Usuario2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hduar on 05/11/2016.
 */
public class TelaProximos extends Fragment implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {


    private Locais selecionado;
    private ListView listView;
    private AdapterListViewLocais adapterListViewLocais;
    //RestLocais rl = new RestLocais();
    List<Locais> fav = new ArrayList<>();
    //private ArrayList<Usuario> amigos = new ArrayList<Usuario>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.activity_tela_amigos, container, false);
        setHasOptionsMenu(false);
        RestLocais rl = new RestLocais();
        //fav = rl.getFavoritos("http://192.168.1.107:8080/WSTrabAndroid/webresources/generic/Locais/favoritos",Seção.getUsuario());
        fav = rl.getLocais("http://10.0.53.55:8080/TrabalhoFinal/webresources/generic/Locais/get");

        //rl.inserirFavorito("http://192.168.129.125:8080/TrabalhoFinal" +
        //        "/webresources/generic/Usuario/Favoritos",Seção.getUsuario(),fav.get(1));

        /*if(fav.isEmpty()) {
            return view;
        }

        for(Locais l: fav){
            if(estaProximo(l)){
                proximos.add(l);
            }
        }*/

        //Pega a referencia do ListView
        listView = (ListView) view.findViewById(R.id.list);
        //Define o Listener quando alguem clicar no item.
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);
        createListView();

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_proximos, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.favoritar:
                RestLocais rl = new RestLocais();
                List<Locais> fav = rl.getFavoritos("http://10.0.53.55:8080/TrabalhoFinal/webresources/generic/Locais/favoritos",Seção.getUsuario());
                for(Locais l:fav){
                    if(l.getNome().equals(selecionado.getNome())){
                        Toast.makeText(getActivity(), "Este local já é um favorito!", Toast.LENGTH_LONG).show();
                        setHasOptionsMenu(false);
                        return false;
                    }
                }
                rl.inserirFavorito("http://10.0.53.55:8080/TrabalhoFinal/webresources/generic/Usuario/Favoritos", Seção.getUsuario(), selecionado);
                Toast.makeText(getActivity(), "Você favoritou esse local!", Toast.LENGTH_LONG).show();
                setHasOptionsMenu(false);
                return true;
            default:
                setHasOptionsMenu(false);
                return super.onOptionsItemSelected(item);
        }
    }

    private void createListView() {

        //Cria o adapter
        adapterListViewLocais = new AdapterListViewLocais(getContext(), fav);

        //Define o Adapter
        listView.setAdapter(adapterListViewLocais);
        //Cor quando a lista é selecionada para ralagem.
        listView.setCacheColorHint(Color.TRANSPARENT);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Pega o item que foi selecionado.
        Locais item = adapterListViewLocais.getItem(position);
        //Demostração

        setHasOptionsMenu(false);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Locais item = adapterListViewLocais.getItem(position);
        selecionado = item;
        setHasOptionsMenu(true);

        return true;
    }

    /*public boolean estaProximo(Locais l){
        if(l.getLatitude() > -4.97931432723970 && l.getLongitude() < -4.97931432724089){
            if(l.getLongitude() > -39.0563011169334 && l.getLongitude() < -39.0563011169534)
                return true;
        }return false;
    }*/
}

