package com.example.user.sqliteproject2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.user.sqliteproject2.Model.ContactModel;

import java.util.ArrayList;

/**
 * Created by User on 6/18/2017.
 */

public class ContactDatabaseSource {

    private ContactModel contactModel;
    private ContactHelper contactHelper;
    private SQLiteDatabase sqLiteDatabase;


    public ContactDatabaseSource(Context context) {
        contactHelper = new ContactHelper(context);
    }

    public void open() {
        sqLiteDatabase = contactHelper.getWritableDatabase();
    }

    public void close() {
        sqLiteDatabase.close();
    }

    public boolean addContact(ContactModel contactModel) {
        this.open();
        ContentValues values = new ContentValues();
        values.put(ContactHelper.COL_CONTACT_NAME, contactModel.getContactName());
        values.put(ContactHelper.COL_CONTACT_PHONE, contactModel.getContactPhone());

        long rowId = sqLiteDatabase.insert(contactHelper.TABLE_NAME, null, values);

        this.close();

        if (rowId > 0) {
            return true;
        } else {
            return false;
        }

    }


    public ArrayList<ContactModel>getAllContacts() {
        ArrayList<ContactModel>contactModels = new ArrayList<>();
        this.open();
        Cursor cursor = sqLiteDatabase.query(contactHelper.TABLE_NAME, null, null, null, null, null, null, null);
        cursor.moveToFirst();

        if (cursor != null && cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                int contactId = cursor.getInt(cursor.getColumnIndex(ContactHelper.COL_CONTACT_ID));
                String contactName = cursor.getString(cursor.getColumnIndex(ContactHelper.COL_CONTACT_NAME));
                String contactPhone = cursor.getString(cursor.getColumnIndex(ContactHelper.COL_CONTACT_PHONE));

                contactModel = new ContactModel(contactId, contactName, contactPhone);

                cursor.moveToNext();
            }



        }

        cursor.close();
        this.close();

        return contactModels;


    }

}


