package com.exp.crud_sqlite;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDatabaseHelper myDatabaseHelper = new myDatabaseHelper(MainActivity.this);
        contact c = new contact("Dinesh10", "9089786655", 2);
        myDatabaseHelper.addContact(c);

        listView = findViewById(R.id.list);

        //List<contact> contactList = myDatabaseHelper.retrieveContact();

        //ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, contactList);

        //listView.setAdapter(arrayAdapter);

        contact key1 = myDatabaseHelper.getContact(1);
        Toast.makeText(this, "" + key1.getName(), Toast.LENGTH_SHORT).show();

        //delete
        //myDatabaseHelper.deleteContact(1);

        //delete database
        //MainActivity.this.deleteDatabase("contacts_db.db");

    }
}