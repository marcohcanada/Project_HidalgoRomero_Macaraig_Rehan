package com.example.databaseexample1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtName;
    EditText edtEmail;

    DBAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.referWidgets();
    }

    private void referWidgets() {
        edtName = findViewById(R.id.edt_name);
        edtEmail = findViewById(R.id.edt_email);

        dbAdapter = new DBAdapter(this);
    }

    public void addRecord(View view) {
        //get record info
        String name = edtName.getText().toString();
        String email = edtEmail.getText().toString();
        //open database
        if (name.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_LONG).show();
        } else {
            dbAdapter.open();
            //call insert method
            dbAdapter.insertContact(name, email);
            //close database
            dbAdapter.close();
            edtName.setText("");
            edtEmail.setText("");
            Toast.makeText(this, "Done", Toast.LENGTH_LONG).show();
        }
    }

    public void goToSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
