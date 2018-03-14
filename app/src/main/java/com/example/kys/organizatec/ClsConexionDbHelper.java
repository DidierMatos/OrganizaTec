package com.example.kys.organizatec;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Didier on 14/03/2018.
 */

public class ClsConexionDbHelper extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "DB_PROYECTO.db";
    private static final int DATABASE_VERSION = 1;

    public ClsConexionDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

}