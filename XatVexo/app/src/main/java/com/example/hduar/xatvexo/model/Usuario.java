package com.example.hduar.xatvexo.model;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by hduar on 05/11/2016.
 */
public class Usuario implements Parcelable {

    private int id;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private Location location;

    private int imagemRid;
    //não precisa ter uma array list de usuarios
    private ArrayList<Usuario> amigos = new ArrayList<>();
    private ArrayList<Conversa> conversas =  new ArrayList<>();


    public Usuario(int id, String telefone, String senha, String email, String nome) {
        this.id = id;
        this.telefone = telefone;
        this.senha = senha;
        this.email = email;
        this.nome = nome;
        this.imagemRid = 0;
        this.amigos = new ArrayList<>();
        this.location = null;
        this.conversas = new ArrayList<>();
    }

    protected Usuario(Parcel in) {
        id = in.readInt();
        nome = in.readString();
        email = in.readString();
        senha = in.readString();
        telefone = in.readString();
    }

    public static final Creator<Usuario> CREATOR = new Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };

    public ArrayList<Usuario> getAmigos() {
        return amigos;
    }

    public void setAmigos(ArrayList<Usuario> amigos) {
        this.amigos = amigos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getImagemRid() {
        return imagemRid;
    }

    public void setImagemRid(int imagemRid) {
        this.imagemRid = imagemRid;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public ArrayList<Conversa> getConversas() {
        return conversas;
    }

    public void setConversas(ArrayList<Conversa> conversas) {
        this.conversas = conversas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;

        Usuario usuario = (Usuario) o;

        if (id != usuario.id) return false;
        if (!nome.equals(usuario.nome)) return false;
        if (!email.equals(usuario.email)) return false;
        if (!senha.equals(usuario.senha)) return false;
        return telefone.equals(usuario.telefone);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + nome.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + senha.hashCode();
        result = 31 * result + telefone.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return this.hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nome);
        dest.writeString(email);
        dest.writeString(senha);
        dest.writeString(telefone);
    }
}

