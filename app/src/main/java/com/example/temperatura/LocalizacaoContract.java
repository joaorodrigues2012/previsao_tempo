package com.example.temperatura;

import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LocalizacaoContract {

    private static List<Localizacao> localizacao;

    static{
        localizacao = new ArrayList<>();
        localizacao.add(new Localizacao (1, 23.4,29.7));
        localizacao.add(new Localizacao (2, 43.4,39.7));
        localizacao.add(new Localizacao (3, 53.4,49.7));
        localizacao.add(new Localizacao (4, 63.4,59.7));
        localizacao.add(new Localizacao (5, 73.4,69.7));
    }


    private LocalizacaoContract(){

    }
    public static class LocalizaContract implements BaseColumns {
        public static final String TABLE_NAME = "tb_localizacao";
        public static final String COLUMN_NAME_ID = "id_localizacao";
        public static final String COLUMN_NAME_LAT = "latitude";
        public static final String COLUMN_NAME_LON = "longitude";
        public static final String DROP_TABLE = String.format("DROP TABLE %s;", LocalizaContract.TABLE_NAME);
    }



    public static String createTableLocalizacao (){
        String template = "CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s TEXT, %s INTEGER)";
        return String.format(
                template,
                LocalizaContract.TABLE_NAME,
                LocalizaContract.COLUMN_NAME_ID,
                LocalizaContract.COLUMN_NAME_LAT,
                LocalizaContract.COLUMN_NAME_LON
        );
    }


    public static String insertLocalizacao(){
        String template = "INSERT INTO %s (%s, %s, %s) VALUES (%d, '%s', %d); ";
        StringBuilder sb = new StringBuilder("");
        for (Localizacao localizacao : localizacao){
            sb.append(
                    String.format(
                            Locale.getDefault(),
                            template,
                            LocalizaContract.TABLE_NAME,
                            LocalizaContract.COLUMN_NAME_ID,
                            LocalizaContract.COLUMN_NAME_LAT,
                            LocalizaContract.COLUMN_NAME_LON,
                            localizacao.getId(),
                            localizacao.getLatitude(),
                            localizacao.getLongitude()
                    )
            );
        }
        return sb.toString();
    }


}
