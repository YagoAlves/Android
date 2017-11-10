package com.example.hduar.xatvexo.ListViews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hduar.xatvexo.R;
import com.example.hduar.xatvexo.model.Conversa;
import com.example.hduar.xatvexo.model.Mensagem;

import java.util.ArrayList;

/**
 * Created by hduar on 16/11/2016.
 */
public class AdapterListViewConversa extends BaseAdapter {

    private LayoutInflater mInflater;
    private ArrayList<Conversa> conversas;

    public AdapterListViewConversa(Context context, ArrayList<Conversa> conversas)
    {
        //Itens que preencheram o listview
        this.conversas = conversas;
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
        return conversas.size();
    }

    /**
     * Retorna o item de acordo com a posicao dele na tela.
     *
     * @param position
     * @return
     */
    public Conversa getItem(int position)
    {
        return conversas.get(position);
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
        Conversa item = conversas.get(position);
        //infla o layout para podermos preencher os dados
        view = mInflater.inflate(R.layout.item_listview, null);

        //atravez do layout pego pelo LayoutInflater, pegamos cada id relacionado
        //ao item e definimos as informações.
        ArrayList<Mensagem> mensagens = item.getMensagens();
        ((TextView) view.findViewById(R.id.text)).setText(item.getTitulo() + "\n" + mensagens.get(mensagens.size() - 1).getTexto());
        ((ImageView) view.findViewById(R.id.imagemview)).setImageResource(item.getImagemRid());

        return view;
    }

}
