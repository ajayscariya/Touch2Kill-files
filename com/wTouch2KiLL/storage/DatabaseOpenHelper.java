package com.wTouch2KiLL.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.text.SimpleDateFormat;

public class DatabaseOpenHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Storage";
    private static final int DATABASE_VERSION = 2;
    private static final String DOWNLOADS_LIST_TABLE_CREATE = "create table downloadsList (id integer primary key autoincrement,name text,description text,id_d text,link_d text,file_path text,date integer,status text);";
    public static final String HISTORY_ROW_TITLE = "title";
    public static final String HISTORY_ROW_URL = "url";
    public static final String HISTORY_ROW_VISIT_TIME = "visitTime";
    private static final String HISTORY_TABLE_CREATE = "CREATE VIRTUAL TABLE history  USING fts3(visitTime DATETIME, title TEXT, url TEXT);";
    public static final String HISTORY_TABLE_NAME = "history";
    public static final SimpleDateFormat SQL_DATE_FORMAT;
    private static final String TAG = "StorageDatabase";

    static {
        SQL_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public DatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(HISTORY_TABLE_CREATE);
        db.execSQL(DOWNLOADS_LIST_TABLE_CREATE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(TAG, "Upgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS history");
        db.execSQL("DROP TABLE IF EXISTS create table downloadsList (id integer primary key autoincrement,name text,description text,id_d text,link_d text,file_path text,date integer,status text);");
        onCreate(db);
    }
}
