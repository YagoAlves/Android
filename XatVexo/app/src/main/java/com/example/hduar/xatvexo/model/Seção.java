package com.example.hduar.xatvexo.model;

import android.location.Location;

import java.util.List;

/**
 * Created by hduar on 05/11/2016.
 */
abstract public class Seção {

    static private Usuario2 usuario;

    static private Location loc;

    public static Usuario2 getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario2 usuario) {
        Seção.usuario = usuario;
    }

    public static Location getLoc() {
        return loc;
    }

    public static void setLoc(Location loc) {
        Seção.loc = loc;
    }
}
