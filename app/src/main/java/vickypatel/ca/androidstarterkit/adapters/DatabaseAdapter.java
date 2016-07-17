package vickypatel.ca.androidstarterkit.adapters;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by VickyPatel on 2016-07-07.
 */
public class DatabaseAdapter {

    public DatabaseHelper helper;
    Context context;

    public DatabaseAdapter(Context context) {
        this.context = context;
        this.helper = new DatabaseHelper(context);
    }

    public static class DatabaseHelper extends SQLiteOpenHelper{

        public static String DATABASE_NAME = "app_database.db";
        public static int DATABASE_VERSION = 1;

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
