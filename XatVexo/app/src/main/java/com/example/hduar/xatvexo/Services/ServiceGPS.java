package com.example.hduar.xatvexo.Services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class ServiceGPS extends Service {

    private static final String TAG = "Services";
    private boolean running;
    private int count = 0;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate(){
        Log.d(TAG, "Service Start GPS");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Log.d(TAG,"Find Events");

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
                    Log.d(TAG, "Monitorando a localização");
                    count++;
                }
                if (count == 15){
                    //Context context = ServiceGPS.this;
                    //Intent intent = new Intent(context, TelaConversas.class);
                    //NotificationUtil.create(context, 1, intent, R.mipmap.ic_launcher, "HelloService", "Fim do serviço.");
                    Log.d(TAG, "Localização atualizada");
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



    /*@Override
    public void onDestroy(){
        super.onDestroy();

        for(Worker w : threads){
            w.ativo = false;
        }
    }*/

    /*class Worker extends Thread{
        public int count;
        public int startId;
        public boolean ativo = true ;

        public Worker(int startId){
            this.startId = startId;
        }

        public void run(){
            while(ativo){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                TelaMapa t =  new TelaMapa();
                Seção.getUsuario().setLocation(t.getLocation());
            }
            stopSelf(startId);
        }
    }*/
}

