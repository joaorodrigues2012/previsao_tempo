package com.example.temperatura;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class LocalizacaoDAO {

    private Context context;
    public LocalizacaoDAO (Context context){
        this.context = context;
    }

    public List<LocalizacaoDAO> busca (String chave){
        LocalizacaoDBHelper dbHelper = new LocalizacaoDBHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        List <LocalizacaoDAO> localizacao = new ArrayList<>();

        String sql = String.format(
                "SELECT * FROM %s WHERE %s.%s LIKE '%%%s%%'",
                LocalizacaoContract.LocalizaContract.TABLE_NAME,
                LocalizacaoContract.LocalizaContract.TABLE_NAME,
                LocalizacaoContract.LocalizaContract.COLUMN_NAME_ID,
                LocalizacaoContract.LocalizaContract.COLUMN_NAME_ID,
                chave
        );
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex(
                    String.format(
                            Locale.getDefault(),
                            "%s.%s",
                            LocalizacaoContract.LocalizaContract.TABLE_NAME,
                            LocalizacaoContract.LocalizaContract.COLUMN_NAME_ID)
            ));
            Double lat = cursor.getDouble(
                    cursor.getColumnIndex(
                            String.format(
                                    "%s.%s",
                                    LocalizacaoContract.LocalizaContract.TABLE_NAME,
                                    LocalizacaoContract.LocalizaContract.COLUMN_NAME_LAT
                            )
                    )
            );
            Double lon = cursor.getDouble(
                    cursor.getColumnIndex(
                            String.format(
                                    Locale.getDefault(),
                                    "%s.%s",
                                    LocalizacaoContract.LocalizaContract.TABLE_NAME,
                                    LocalizacaoContract.LocalizaContract.COLUMN_NAME_LON
                            )
                    )
            );


           // localizacao.add(new Localizacao(id, lat, lon));
        }
        cursor.close();
        dbHelper.close();
        db.close();
        return localizacao;
    }
}
