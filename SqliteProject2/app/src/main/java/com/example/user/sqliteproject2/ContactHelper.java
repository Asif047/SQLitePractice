package com.example.user.sqliteproject2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.user.sqliteproject2.Model.ContactModel;

/**
 * Created by User on 6/18/2017.
 */

public class ContactHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME="contact_db";
    public static final int DATABASE_VERSION=1;

    public static final String TABLE_NAME="table_contact";
    public static final String COL_CONTACT_ID="contact_id";
    public static final String COL_CONTACT_NAME="contact_name";
    public static final String COL_CONTACT_PHONE="contact_phone";


    public static final String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+" ( "+COL_CONTACT_ID+" INTEGER PRIMARY KEY,"+
            " "+COL_CONTACT_NAME +" TEXT, "+COL_CONTACT_PHONE+" TEXT);";


    public ContactHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE "+TABLE_NAME+" IF EXISTS");
        onCreate(db);

    }
}
