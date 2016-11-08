package com.example.shanu.toolbar;

import android.provider.BaseColumns;

/**
 * Created by SHANU on 31-10-2016.
 */
public class DatabaseContact {
    public static final class Schema implements BaseColumns {

        public final static String TABLE_NAME = "TO_DO";

        public final static String ID = BaseColumns._ID;


        public final static String COLUMN_TITTLE ="tittle";


        public final static String COLUMN_DETAIL="detail";


    }
}
