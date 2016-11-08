package com.example.shanu.toolbar;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddTask extends AppCompatActivity {
    private EditText mTittleEditText;
    private EditText mDetailEditText;
    private Button mSaveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mTittleEditText = (EditText) findViewById(R.id.et_tittle);
        mDetailEditText = (EditText) findViewById(R.id.et_detail);
        mSaveButton = (Button) findViewById(R.id.btn_save);
        mSaveButton.setOnClickListener((new View.OnClickListener() {
            public void onClick(View arg0) {
                insertTask();
            }
        }
        ));
    }

    public void insertTask() {
        String detail = mDetailEditText.getText().toString().trim();
        String tittle = mTittleEditText.getText().toString().trim();

        if (!detail.equals("") && !tittle.equals("")) {
            DbHelper mDbHelper = new DbHelper(this);

            // Gets the database in write mode
            SQLiteDatabase db = mDbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(DatabaseContact.Schema.COLUMN_TITTLE, tittle);
            values.put(DatabaseContact.Schema.COLUMN_DETAIL, detail);
            // values.put(RegistrationContact.Schema.COLUMN_ST_EMAIL, emailString);
            long newId = db.insert(DatabaseContact.Schema.TABLE_NAME, null, values);

            if (newId == -1) {
                // If the  ID is -1, then there was an error with insertion.
                Toast.makeText(this, "Error with saving", Toast.LENGTH_SHORT).show();
            } else {
                mTittleEditText.setText("");
                mDetailEditText.setText("");
                Toast.makeText(this, "saved with row id: " + newId, Toast.LENGTH_SHORT).show();
                finish();
            }
        }
        else
            Toast.makeText(getApplicationContext(),"empty feild",Toast.LENGTH_SHORT).show();
    }
}