package com.example.temperatura;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class LocalizacaoViewHolder extends RecyclerView.ViewHolder {

    public TextView latitudeTextView;
    public TextView longitudeTextView;

    public LocalizacaoViewHolder (View v){
        super(v);
        latitudeTextView =
                v.findViewById(R.id.latitudeTextView);
        longitudeTextView =
                v.findViewById(R.id.longitudeTextView);
    }
}
