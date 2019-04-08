package com.example.temperatura;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class LocalizacaoRecyclerViewAdapter extends RecyclerView.Adapter<LocalizacaoViewHolder>{


        private List<Localizacao> localizacaos;

    public LocalizacaoRecyclerViewAdapter (List <Localizacao> localizacaos){
            this.localizacaos = localizacaos;
        }

        @Override
        public int getItemCount() {
            return localizacaos.size();
        }

        @NonNull
        @Override
        public LocalizacaoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View raiz =
                    LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
            return new LocalizacaoViewHolder(raiz);
        }

        @Override
        public void onBindViewHolder(@NonNull LocalizacaoViewHolder localizacaoViewHolder, int i) {
            Localizacao localiza = localizacaos.get(i);
                localizacaoViewHolder.latitudeTextView.setText("Latitude: " + localiza.getLatitude());
                localizacaoViewHolder.longitudeTextView.setText("Longitude: " + localiza.getLongitude()+"\n");
        }

}
