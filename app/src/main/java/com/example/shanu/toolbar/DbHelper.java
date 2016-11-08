package com.example.shanu.toolbar;

/**
 * Created by SHANU on 31-10-2016.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class DbHelper  extends SQLiteOpenHelper {
    public static final String LOG_TAG = DbHelper.class.getSimpleName();

    /** Name of the database file */
    private static final String DATABASE_NAME = "mydata.db";

    private static final int DATABASE_VERSION = 1;


    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database ishe first time. created for t
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_TABLE =  "CREATE TABLE " + DatabaseContact.Schema.TABLE_NAME + " ("
                + DatabaseContact.Schema.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DatabaseContact.Schema.COLUMN_TITTLE + " TEXT NOT NULL, "
                +DatabaseContact.Schema.COLUMN_DETAIL + " TEXT  ) ";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL_DELETE_TABLE;
        SQL_DELETE_TABLE = "DROP TABLE IF EXISTS " + DatabaseContact.Schema.TABLE_NAME;
        db.execSQL(SQL_DELETE_TABLE);
        onCreate(db);


    }


}

