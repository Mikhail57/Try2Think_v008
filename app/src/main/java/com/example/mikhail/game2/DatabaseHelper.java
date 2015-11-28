package com.example.mikhail.game2;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by 79832 on 11/25/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper implements BaseColumns {
    public static final String DATABASE_NAME = "mydatabase.db";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_TABLE = "game";

    private static final String LEVEL_COLUMN = "level";
    private static final String CHAPTER_COLMUN = "chapter";
    private static final String TRY_COUNT_COLMUN = "try_count";
    private static final String STATUS_COLMUN = "status";

    private static final String DATABASE_CREATE_SCRIPT = "create table "
                        + DATABASE_TABLE + " (" + BaseColumns._ID
                        + " integer primary key autoincrement, " + CHAPTER_COLMUN
                        + " integer, " + LEVEL_COLUMN + " integer, "
                        + STATUS_COLMUN + " integer, "
                        + TRY_COUNT_COLMUN + " integer);";

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                          int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_SCRIPT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
