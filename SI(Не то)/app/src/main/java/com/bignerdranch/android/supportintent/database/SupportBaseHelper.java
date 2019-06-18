package com.bignerdranch.android.supportintent.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.bignerdranch.android.supportintent.database.SupportDbSchema.SupportTable;

public class SupportBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "supportBase.db";

    public SupportBaseHelper(Context context){
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table " + SupportTable.NAME + "(" +
            "_id integer primary key autoincrement,"+
            SupportTable.Cols.UUID + ", " +
            SupportTable.Cols.AUTHOR + ", " +
            SupportTable.Cols.RESPONSIBLE + ", " +
            SupportTable.Cols.THEME + ", " +
            SupportTable.Cols.CATEGORY + ", " +
            SupportTable.Cols.SOLVED  +
            ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}

