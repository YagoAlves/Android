package com.example.hduar.xatvexo.ListViews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hduar.xatvexo.R;
import com.example.hduar.xatvexo.model.Locais;
import com.example.hduar.xatvexo.model.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hduar on 06/11/2016.
 */
public class AdapterListViewLocais extends BaseAdapter
{
    private LayoutInflater mInflater;
    private List<Locais> locais;

    public AdapterListViewLocais(Context context, List<Locais> locais)
    {
        //Itens que preencheram o listview
        this.locais = locais;
        //responsavel por pegar o Layout do item.
        mInflater = LayoutInflater.from(context);
    }

    /**
     * Retorna a quantidade de itens
     *
     * @return
     */
    public int getCount()
    {
        return locais.size();
    }

    /**
     * Retorna o item de acordo com a posicao dele na tela.
     *
     * @param position
     * @return
     */
    public Locais getItem(int position)
    {
        return locais.get(position);
    }

    /**
     * Sem implementação
     *
     * @param position
     * @return
     */
    public long getItemId(int position)
    {
        return position;
    }

    public View getView(int position, View view, ViewGroup parent)
    {
        //Pega o item de acordo com a posção.
        Locais item = locais.get(position);
        //infla o layout para podermos preencher os dados
        view = mInflater.inflate(R.layout.item_listview, null);

        //atravez do layout pego pelo LayoutInflater, pegamos cada id relacionado
        //ao item e definimos as informações.
        ((TextView) view.findViewById(R.id.text)).setText(item.getNome());
        ((ImageView) view.findViewById(R.id.imagemview)).setImageResource(R.drawable.user);

        return view;
    }
}
