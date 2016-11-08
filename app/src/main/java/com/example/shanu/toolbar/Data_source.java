package com.example.shanu.toolbar;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by SHANU on 03-11-2016.
 */
public class Data_source {
    private static Data_source sDatasource;

    private ArrayList<TO_DO> mTo_do;

    public static Data_source get(Context context) {
        //if (sDatasource == null) {
            sDatasource = new Data_source(context);
        //}
        return sDatasource;
    }
    private Data_source(Context context)
    {
        mTo_do=new ArrayList<>();
        DbHelper mDbHelper = new DbHelper(context);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        Cursor result = db.rawQuery("select * from "+ DatabaseContact.Schema.TABLE_NAME, null );


        result.moveToFirst();

        while(result.isAfterLast() == false)
        {
            TO_DO to_do=new TO_DO();
            String tittle = result.getString(result.getColumnIndex("tittle"));
            to_do.setmTitle(tittle);
            String detail=result.getString(result.getColumnIndex("detail"));
             to_do.setmDetail(detail);
        //     Toast.makeText(context,tittle, Toast.LENGTH_SHORT).show();
         //   Toast.makeText(context,detail, Toast.LENGTH_SHORT).show();
            result.moveToNext();
            mTo_do.add(to_do);
        }
    }
    public List<TO_DO> getTo_do() {
        return mTo_do;
    }
    public TO_DO getTodo(UUID id) {
        for (TO_DO todo : mTo_do) {
            if (todo.getmId().equals(id)) {
                return todo;
            }
        }
        return null;


    }
}
