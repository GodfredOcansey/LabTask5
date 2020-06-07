package com.ocanseygodfred.labtask5;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseManager extends SQLiteOpenHelper {
    private static final  String DATABASE_NAME="database_name";
    private static final  String TABLE_NAME="Words";
    private static final  String ID="ID";
    private static final  String CORRECT="CORRECT_SPELLING";
    private static final  String WRONG="WRONG_SPELLING";

    DatabaseManager (Context context){

        super(context, DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreate = "create table " + TABLE_NAME + "( " + ID;
        sqlCreate += " integer primary key autoincrement, " + CORRECT;
        sqlCreate += " text, " + WRONG + " text )" ;

        db.execSQL( sqlCreate );


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    public void insert(  ) {
        SQLiteDatabase db = this.getWritableDatabase( );
        String sqlInsert = "insert into " + TABLE_NAME;
        sqlInsert += " values( null, '" + "THE";
        sqlInsert += "', '" + "TEH" + "' ),";


        sqlInsert += " ( null, '" + "BOY";
        sqlInsert += "', '" + "BYO" + "' ), ";

        sqlInsert += "( null, '" + "LIVES";
        sqlInsert += "', '" + "LEVIS" + "' ), ";

        sqlInsert += "( null, '" + "AT";
        sqlInsert += "', '" + "QT" + "' ), ";

        sqlInsert += " ( null, '" + "POKUASE";
        sqlInsert += "', '" + "POKYASE" + "' )";


        db.execSQL( sqlInsert );
        db.close( );
    }


    public Cursor ViewData(){
        SQLiteDatabase db= this.getReadableDatabase();

        Cursor cursor= db.rawQuery("select * from "+ TABLE_NAME,null);
        return  cursor;
    }



}

