package com.example.hduar.xatvexo;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hduar.xatvexo.model.Seção;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by hduar on 13/11/2016.
 */
public class TelaLocalizacao extends AppCompatActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {


    private static final String TAG = "livroandroid";
    protected GoogleMap map;
    private SupportMapFragment mapFragment;
    private GoogleApiClient mGoogleApiClient;
    private Button action;

    protected void onCreate(Bundle icicle){
        super.onCreate(icicle);
        setContentView(R.layout.activity_teste);

        action = (Button) findViewById(R.id.action);

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        String [] permissoes = new String[]{
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,
        };
        PermissionUtils.validate(this, 0, permissoes);

        action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(TelaMapa.this, "Usuário não existe", Toast.LENGTH_SHORT).show();
                Location l = getLocation();
                if(l == null)
                {
                    Toast.makeText(TelaLocalizacao.this, "Usuário não existe", Toast.LENGTH_SHORT).show();
                }else {
                    Log.d(TAG, "lastLocation : " + l);

                    setMapLocation(l);

                    Seção.setLoc(l);

                    Intent i = new Intent(TelaLocalizacao.this, TelaLogin.class);
                    startActivity(i);
                }
            }
        });

    }

    public void onRequestPermissionsResult(int requestCode, String [] permissions, int[] grantResults){
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        for(int result: grantResults){
            if(result == PackageManager.PERMISSION_DENIED){
                alertAndFinish();
                return;
            }
        }
    }

    private void alertAndFinish(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.app_name).setMessage("Pra utilizar o aplicativo você precisa de permissões");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
        android.support.v7.app.AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void onMapReady(GoogleMap map){
        Log.d(TAG, "onMapReady: " + map);
        this.map = map;

        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }

    protected void onStart(){
        super.onStart();
        mGoogleApiClient.connect();
    }

    protected void onStop(){
        mGoogleApiClient.disconnect();
        super.onStop();
    }

    public void onConnected(Bundle bundle){
        Toast.makeText(TelaLocalizacao.this, "Conectado no Google Play Services!", Toast.LENGTH_SHORT).show();
    }

    public void onConnectionSuspended(int cause){
        Toast.makeText(TelaLocalizacao.this, "Conexão interrompida", Toast.LENGTH_SHORT).show();
    }

    public void onConnectionFailed(ConnectionResult connectionResult){
        Toast.makeText(TelaLocalizacao.this, "Erro ao conectar: " + connectionResult, Toast.LENGTH_SHORT).show();
    }

    private void setMapLocation(Location l){
        if(map != null && l != null){
            LatLng latLng = new LatLng(l.getLatitude(), l.getLongitude());
            CameraUpdate update = CameraUpdateFactory.newLatLngZoom(latLng, 15);
            map.animateCamera(update);

            Log.d(TAG, "setMapLocation: " + l);
            TextView text = (TextView) findViewById(R.id.text);
            text.setText(String.format("Lat/Lnt %f/%f, provider: %s", l.getLatitude(),l.getLongitude(), l.getProvider()));

            CircleOptions circle = new CircleOptions().center(latLng);
            circle.fillColor(Color.RED);
            circle.radius(25);
            map.clear();
            map.addCircle(circle);
        }
    }

    public Location getLocation(){
        Location l = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        return l;
    }


}
