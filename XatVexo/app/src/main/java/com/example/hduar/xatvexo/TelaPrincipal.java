package com.example.hduar.xatvexo;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.hduar.xatvexo.Services.ServiceGPS;
import com.example.hduar.xatvexo.Services.ServiceLocais;
import com.example.hduar.xatvexo.model.Seção;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class TelaPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final LocationManager manager = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE );
        if(!manager.isProviderEnabled( LocationManager.GPS_PROVIDER )) {
            Toast.makeText(this, "GPS está desativado", Toast.LENGTH_LONG).show();
            sendBroadcast(new Intent("Online"));
        }

        startService(new Intent(this, ServiceGPS.class));
        startService(new Intent(this, ServiceLocais.class));

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Conversas"));
        tabLayout.addTab(tabLayout.newTab().setText("Locais"));
        tabLayout.addTab(tabLayout.newTab().setText("Favoritos"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter (getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    public void startService(View view){
        Intent it = new Intent("SERVICO_TEST");
        startService(it);
    }

    public void stopService(View view){
        Intent it = new Intent("SERVICO_TEST");
        stopService(it);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handler dos cliques em cada menu
        switch (item.getItemId()) {
            case R.id.mapa:
                Intent i = new Intent(TelaPrincipal.this, TelaMapa.class);
                startActivity(i);
                return true;
            case R.id.ver_perfil:
                Intent intent = new Intent(TelaPrincipal.this, TelaPerfil.class);
                startActivity(intent);
                return true;
            case R.id.cadastrar_local:
                Intent intent2 = new Intent(TelaPrincipal.this, CadastrarLocal.class);
                startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
