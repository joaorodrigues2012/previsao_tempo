package com.example.temperatura;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

public class LocalizacaoDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "localizacao.db";
    private static final int DB_VERSION = 1;

    public LocalizacaoDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(LocalizacaoContract.createTableLocalizacao());
        db.execSQL(LocalizacaoContract.insertLocalizacao());
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        db.execSQL(LocalizacaoContract.LocalizaContract.DROP_TABLE);
        onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }


}
