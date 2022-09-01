package com.exp.crud_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class myDatabaseHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "contacts_db";
    public static final String TABLE_NAME = "contacts_table";


    //Keys of our table in db
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_PHONE = "phone_number";


    public myDatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME
                + " TEXT, " + KEY_PHONE + " TEXT" + ")";
        Log.d("dDatabase", "Query being run is : " + create);
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addContact(contact contact) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName());
        values.put(KEY_PHONE, contact.getPhone());
        values.put(KEY_ID, contact.getId());

        sqLiteDatabase.insert(TABLE_NAME, null, values);
        Log.d("dSQlite", "data inserted");

        sqLiteDatabase.close();
    }


    public List<contact> retrieveContact() {

        List<contact> contactList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Generate the query to read from the database
        String select = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(select, null);

        //Loop through now
        if (cursor.moveToFirst()) {
            do {
                contact contact = new contact();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPhone(cursor.getString(2));
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        return contactList;
    }

    public int updateContact(contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName());
        values.put(KEY_PHONE, contact.getPhone());

        //Lets update now
        return db.update(TABLE_NAME, values, KEY_ID + "=?",
                new String[]{String.valueOf(contact.getId())});


    }

    public contact getContact(int i) {
        SQLiteDatabase db = this.getReadableDatabase();

        String select = "SELECT * FROM " + TABLE_NAME + " WHERE " + KEY_ID + " = " + i;


        Cursor cursor = db.rawQuery(select, null);
        contact contact = new contact();

        if (cursor.moveToFirst()) {
            do {

                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPhone(cursor.getString(2));

            } while (cursor.moveToNext());
        }
        return contact;
    }

    public void deleteContact(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String stringId = String.valueOf(id);

        db.delete(TABLE_NAME, KEY_ID + "=?", new String[]{stringId});
        Log.d("dleete", "Deleted");
    }
}
