package com.example.temperatura;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class LIstLocalizacaoActivity extends AppCompatActivity {

    private ListView localizacaoListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_localizacao);
        localizacaoListView = findViewById(R.id.localizacaoListView);
        Intent origemIntent = getIntent();
        String nomeFila = origemIntent.getStringExtra("nome_fila");
        final List<String> chamados = busca(nomeFila);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, chamados);
        localizacaoListView.setAdapter(adapter);

        localizacaoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String chamado = chamados.get(position);
              //  Intent intent = new Intent(ListaChamadosActivity.this,DetalheChamadosActivity.class);
              //  intent.putExtra("chamado_escolhido",chamado);
              //  startActivity(intent);
            }
        });
    }

    public List<String> busca(String nomeFila) {
        List<String> baseDeDados = geraListaChamados();
        if (nomeFila == null || nomeFila.isEmpty())
            return baseDeDados;
        List<String> resultadoParcial = new ArrayList<>();
        for (String chamado : baseDeDados) {
            if (chamado.toLowerCase().contains(nomeFila.toLowerCase())) {
                resultadoParcial.add(chamado);
            }
        }
        return resultadoParcial;
    }

    public List<String> geraListaChamados() {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Longitude: 1.34543.");
        return lista;
    }
}
