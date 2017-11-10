package com.example.hduar.xatvexo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.hduar.xatvexo.model.Usuario;

import java.util.ArrayList;

public class TelaSplash extends Activity {
    // Timer da splash screen
    private static int SPLASH_TIME_OUT = 3000;

    ArrayList<Usuario> usuarios = new ArrayList<>();

    Usuario adm = new Usuario(usuarios.size(), "(88)99680-9637", "123", "h.duarte222@gmail.com", "hugo");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_splash);

        usuarios.add(adm);

        new Handler().postDelayed(new Runnable() {
            /*
             * Exibindo splash com um timer.
             */
            @Override
            public void run() {
                // Esse método será executado sempre que o timer acabar
                // E inicia a activity principal
                Intent i = new Intent(TelaSplash.this, TelaLocalizacao.class);
                startActivity(i);

                // Fecha esta activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}