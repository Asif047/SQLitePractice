package com.example.user.sqliteproject2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.StandaloneActionMode;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.sqliteproject2.Model.ContactModel;

public class MainActivity extends AppCompatActivity {

    private EditText nameET;
    private EditText phoneET;
    private ContactDatabaseSource contactDatabaseSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameET= (EditText) findViewById(R.id.NameEditText);
        phoneET= (EditText) findViewById(R.id.phoneEditText);

        contactDatabaseSource=new ContactDatabaseSource(this);
    }

    public void saveInfo(View view) {

        String name=nameET.getText().toString();
        String phone=phoneET.getText().toString();

        ContactModel contactModel=new ContactModel(name,phone);

        boolean status=contactDatabaseSource.addContact(contactModel);

        if(status)
        {
            Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_LONG).show();
        }

        else
        {
            Toast.makeText(MainActivity.this, "Insertion failed", Toast.LENGTH_LONG).show();
        }

    }

    public void showInfo(View view) {

        Intent intent=new Intent(MainActivity.this,ContactListActivity.class);
        startActivity(intent);
    }
}
