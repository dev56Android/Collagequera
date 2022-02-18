package com.uniinfo.collagequera.controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.uniinfo.collagequera.bean.User;
import com.uniinfo.collagequera.db.DBHelper;

public class UserController
{
    DBHelper db;
    SQLiteDatabase sdb;
    Context con;
    User u;

    public UserController() {
    }

    public UserController(Context con) {
        this.con = con;

    }
    public boolean insertUser(User u)
    {
        String name=u.getName();
        String username=u.getUsername();
        String email=u.getEmail();
        String password=u.getPassword();
        String mobile=u.getMobile();
        int type=u.getType();
        return  false;
    }

}
