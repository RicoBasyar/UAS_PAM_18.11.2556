package com.example.UASPAM;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DataHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Favorite_Match";
    private static final String TABLE_NAME = "favorite";

    private static final String KEY_TITLE = "title";
    private static final String KEY_HOME = "home";
    private static final String KEY_HOMESCORE = "homescore";
    private static final String KEY_AWAY = "away";
    private static final String KEY_AWAYSCORE = "awayscore";
    private static final String KEY_DATE = "date";
    private static final String KEY_IMG = "image";

    public DataHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Create table
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_TITLE + " TEXT,"
                + KEY_HOME + " TEXT,"
                + KEY_HOMESCORE + " TEXT,"
                + KEY_AWAY + " TEXT,"
                + KEY_AWAYSCORE + " TEXT,"
                + KEY_DATE + " TEXT,"
                + KEY_IMG + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

}
