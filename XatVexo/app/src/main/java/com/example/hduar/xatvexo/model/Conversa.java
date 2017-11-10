package com.example.hduar.xatvexo.model;

import android.location.Location;

import java.util.ArrayList;

/**
 * Created by hduar on 06/11/2016.
 */
public class Conversa {

    public int id;
    public ArrayList<Usuario> participantes;
    public ArrayList<Mensagem> mensagens;
    public Usuario administrador;
    public String titulo;
    public Location location;
    private int imagemRid;

    public Conversa(int id, Usuario administrador, String titulo, Location location) {
        this.id = id;
        this.administrador = administrador;
        this.titulo = titulo;
        this.location = location;
        this.imagemRid = 0;
        this.participantes = new ArrayList<Usuario>();
        this.mensagens = new ArrayList<Mensagem>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Usuario> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(ArrayList<Usuario> participantes) {
        this.participantes = participantes;
    }

    public ArrayList<Mensagem> getMensagens() {
        return mensagens;
    }

    public void setMensagens(ArrayList<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }

    public Usuario getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Usuario administrador) {
        this.administrador = administrador;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getImagemRid() {
        return imagemRid;
    }

    public void setImagemRid(int imagemRid) {
        this.imagemRid = imagemRid;
    }
}
