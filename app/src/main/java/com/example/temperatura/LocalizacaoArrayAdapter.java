package com.example.temperatura;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class LocalizacaoArrayAdapter extends ArrayAdapter<Localizacao> {

    public LocalizacaoArrayAdapter(Context context, List<Localizacao> localizacoes) {
        super(context, -1, localizacoes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Localizacao localizacao = getItem(position);
        ViewHolder vh = null;
        if(convertView == null){
            Context context = getContext();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_item, parent, false);
            vh = new ViewHolder();
            vh.latitude = convertView.findViewById(R.id.latitudeTextView);
            vh.longitude = convertView.findViewById(R.id.longitudeTextView);
            convertView.setTag(vh);
        }
//        TextView latitude = convertView.findViewById(R.id.latitudeTextView);
//        TextView longitude = convertView.findViewById(R.id.longitudeTextView);

       // latitude.setText("Latitude: " + localizacao.getLatitude());
       // longitude.setText("Longitude: " + localizacao.getLongitude());
        vh = (ViewHolder) convertView.getTag();
        Localizacao localizacao = getItem(position);
        vh.longitude.setText("Latitude"+ localizacao.getLongitude());
        vh.latitude.setText("Longitude: " + localizacao.getLatitude());
        return convertView;
    }

    private class ViewHolder{
        public TextView latitude;
        public TextView longitude;
    }
}
