package com.example.mikhail.game2;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Path;
import android.provider.BaseColumns;
import android.util.Log;

/**
 * Created by 79832 on 11/25/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper implements BaseColumns {
    public static final String DATABASE_NAME = "mydatabase.db";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_TABLE = "game";

    public static final String LEVEL_COLUMN = "level";
    public static final String CHAPTER_COLUMN = "chapter";
    public static final String TRY_COUNT_COLUMN = "try_count";
    public static final String STATUS_COLUMN = "status";

    private static final String DATABASE_CREATE_SCRIPT = "create table "
                        + DATABASE_TABLE + " (" + BaseColumns._ID
                        + " integer primary key autoincrement, " + CHAPTER_COLUMN
                        + " integer, " + LEVEL_COLUMN + " integer, "
                        + STATUS_COLUMN + " integer, "
                        + TRY_COUNT_COLUMN + " integer);";

    private static Context mContext;

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }
    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                          int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
        mContext = context;
    }
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_SCRIPT);
        Log.e("Warning information", "Table has been created. DatabaseCreateScript='"+DATABASE_CREATE_SCRIPT+"';");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static void saveStateToDatabase() {

        SQLiteDatabase mStateDatabase;
        SQLiteDatabase sdb;

        DatabaseHelper mDatabaseHelper;

        mDatabaseHelper = new DatabaseHelper(MainActivity.getContext());
        for (int i=0; i<DataBase.section1.length; i++) {
            ContentValues newValues = new ContentValues();
            newValues.put(DatabaseHelper.CHAPTER_COLUMN, 1);
            newValues.put(DatabaseHelper.LEVEL_COLUMN, i);
            newValues.put(DatabaseHelper.STATUS_COLUMN, DataBase.section1[i].status);
            newValues.put(DatabaseHelper.TRY_COUNT_COLUMN, DataBase.section1[i].tryCount);

            sdb = mDatabaseHelper.getWritableDatabase();
            sdb.insert(DatabaseHelper.DATABASE_TABLE, null, newValues);

            Log.e("Lololo", "Section 1. i="+i);

        }
        for (int i=0; i<DataBase.section2.length; i++) {
            ContentValues newValues = new ContentValues();
            newValues.put(DatabaseHelper.CHAPTER_COLUMN, 2);
            newValues.put(DatabaseHelper.LEVEL_COLUMN, i);
            newValues.put(DatabaseHelper.STATUS_COLUMN, DataBase.section2[i].status);
            newValues.put(DatabaseHelper.TRY_COUNT_COLUMN, DataBase.section2[i].tryCount);

            sdb = mDatabaseHelper.getWritableDatabase();
            sdb.insert(DatabaseHelper.DATABASE_TABLE, null, newValues);
        }

        String dbpath = mContext.getDatabasePath(DATABASE_NAME).getPath();
        Log.e("Inform", "databasePath='"+dbpath+"'");
    }

    public static void loadStateFromDatabase() {

        SQLiteDatabase sdb;

        DatabaseHelper mDatabaseHelper;

        mDatabaseHelper = new DatabaseHelper(MainActivity.getContext());

        sdb = mDatabaseHelper.getReadableDatabase();
        


        String dbpath = mContext.getDatabasePath(DATABASE_NAME).getPath();
        Log.e("Inform", "databasePath='"+dbpath+"'");
    }

}
