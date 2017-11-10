package com.example.hduar.xatvexo.Services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by yago_alves on 16/11/16.
 */
public class ServiceLocais extends Service {


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private static final String TAG = "ServicesLocais";
    private boolean running;
    private int count = 0;

    @Override
    public void onCreate(){
        Log.d(TAG, "Service Start Locais");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Log.d(TAG,"");

        running = true;

        new ClassThread().start();
        return super.onStartCommand(intent, flags, startId);
    }

    class ClassThread extends Thread {
        @Override
        public void run() {
            try {
                while (running && count < 15){
                    Thread.sleep(1000);
                    //TelaMapa t =  new TelaMapa();
                    //Seção.getUsuario().setLocation(t.getLocation());
                    Log.d(TAG, "Comparando localização");
                    count++;
                }
                if (count == 10){
                    //Context context = ServiceGPS.this;
                    //Intent intent = new Intent(context, TelaConversas.class);
                    //NotificationUtil.create(context, 1, intent, R.mipmap.ic_launcher, "HelloService", "Fim do serviço.");
                    Log.d(TAG, "Não está proximo a nenhum local cadastrado");
                }
            }catch (InterruptedException e){
                Log.d(TAG, "Interrupted: " + e.toString());
            }finally {
                stopSelf();

            }
            super.run();
        }
    }

    @Override
    public void onDestroy() {
        running = false;
        // Log.d(TAG, "Service destroyed");
    }
}
