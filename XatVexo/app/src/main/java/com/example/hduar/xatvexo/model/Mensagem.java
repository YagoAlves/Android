package com.example.hduar.xatvexo.model;

/**
 * Created by hduar on 06/11/2016.
 */
public class Mensagem {

    private int id;
    private Usuario remetente;
    private String texto;

    public Mensagem(int id, Usuario remetente, String texto) {
        this.id = id;
        this.remetente = remetente;
        this.texto = texto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getRemetente() {
        return remetente;
    }

    public void setRemetente(Usuario remetente) {
        this.remetente = remetente;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
