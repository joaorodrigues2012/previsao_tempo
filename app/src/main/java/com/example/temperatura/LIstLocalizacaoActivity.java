package com.example.temperatura;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class LIstLocalizacaoActivity extends AppCompatActivity {

    //private ListView localizacaoListView;
    private RecyclerView localizaoRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_localizacao);

        Intent origemIntent = getIntent();
        //String nomeFila = origemIntent.getStringExtra("localizacoes");
        //final List<String> chamados = busca(nomeFila);
        final ArrayList<Localizacao> localizacoes = (ArrayList<Localizacao>) origemIntent.getSerializableExtra("localizacoes");
        localizaoRecyclerView = findViewById(R.id.localizacaoRecyclerView);
        localizaoRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, chamados);
        //ArrayAdapter<Localizacao> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, localizacoes);
        //LocalizacaoArrayAdapter arrayAdapter = new LocalizacaoArrayAdapter(this,localizacoes);
        RecyclerViewAdapter  arrayAdapter = new RecyclerViewAdapter (localizacoes);
        localizaoRecyclerView.setAdapter(arrayAdapter);

//        localizaoRecyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                //String chamado = chamados.get(position);
//                Localizacao localizacao = localizacoes.get(position);
//                String latAux = String.valueOf(localizacao.getLatitude()).replace(',','.');
//                String lonAux = String.valueOf(localizacao.getLongitude()).replace(',','.');
//                Uri gmmIntentUri = Uri.parse(String.format("geo:%f,%f,?q=%s,%s", localizacao.getLongitude(), localizacao.getLatitude(),latAux,lonAux));
//                //  Intent intent = new Intent(ListaChamadosActivity.this,DetalheChamadosActivity.class);
//                Intent Intent = new Intent(android.content.Intent.ACTION_VIEW, gmmIntentUri);
//              //  intent.putExtra("chamado_escolhido",chamado);
//                Intent.setPackage("com.google.android.apps.maps");
//              //  startActivity(intent);
//                startActivity(Intent);
//
//            }
//        });
    }

//    public List<String> busca(String nomeFila) {
//        List<String> baseDeDados = geraListaChamados();
//        if (nomeFila == null || nomeFila.isEmpty())
//            return baseDeDados;
//        List<String> resultadoParcial = new ArrayList<>();
//        for (String chamado : baseDeDados) {
//            if (chamado.toLowerCase().contains(nomeFila.toLowerCase())) {
//                resultadoParcial.add(chamado);
//            }
//        }
//        return resultadoParcial;
//    }
//
//    public List<String> geraListaChamados() {
//        ArrayList<String> lista = new ArrayList<>();
//        lista.add("Longitude: 1.34543.");
//        return lista;
//    }

}
