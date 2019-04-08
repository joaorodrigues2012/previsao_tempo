package com.example.temperatura;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private LocationListener locationListener;
    private LocationManager locationManager;
    private static final int REQUEST_CODE_GPS = 1001;
    private TextView lblLocalizacao;


    private double latitudeAtual;
    private double longitudeAtual;
    private ArrayList<Localizacao> localizacoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        localizacoes = new ArrayList<>();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

                /*   Uri gmmIntentUri =
                        Uri.parse(String.format("geo:%f,%f?q=restaurantes",
                                latitudeAtual, longitudeAtual));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
*/

                //Intent intent = new Intent(MainActivity.this, LIstLocalizacaoActivity.class);
                //startActivityForResult(intent, 1);
                Intent intent = new Intent(MainActivity.this, LIstLocalizacaoActivity.class);
                intent.putExtra("localizacoes", localizacoes);
                startActivity(intent);

            }
        });

        lblLocalizacao = findViewById(R.id.lblLocalizacao);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                double lat = location.getLatitude();
                double lon = location.getLongitude();
                Localizacao localizacao = new Localizacao(lat,lon);
                localizacao.setLatitude(latitudeAtual);
                localizacao.setLongitude(longitudeAtual);
                localizacoes.add(localizacao);
                latitudeAtual = lat;
                longitudeAtual = lon;
                if(localizacoes.size() > 50){
                    Log.e("Size",">50");
                    localizacoes.remove(0);
                }
                lblLocalizacao.setText(String.format("Lat: %f, Long: %f", lat, lon));
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };

    }

    @Override
    protected void onStart() {
        super.onStart();

        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000,
                    200, locationListener);
        } else {
            ActivityCompat.requestPermissions(this, new String[]
                    {Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE_GPS);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull
            String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CODE_GPS) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.checkSelfPermission(this,
                        Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 200, locationListener);
                }
            } else {
                Toast.makeText(this, getString(R.string.msg_erro_temperatura), Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        locationManager.removeUpdates(locationListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
