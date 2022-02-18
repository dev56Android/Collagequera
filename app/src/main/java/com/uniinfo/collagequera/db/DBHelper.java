package com.uniinfo.collagequera.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String dbname = "collegequera";
    public static final String tblName = "user";
    public static final int version =1;
    Context con;

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
        con = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        String userQuery ="create table "+tblName+"user(id int primary key autoincrement,name varchar(30),username varchar(30) unique not null" +
                ",email varchar(30) unique,password varchar(30) not null,mobileno int unique,type int)";
        sqLiteDatabase.execSQL(userQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {

    }
}
