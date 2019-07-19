package com.example.databaseexample1;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    DBAdapter dbAdapter;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        this.referWidgets();
    }

    private void referWidgets() {
        dbAdapter = new DBAdapter(this);

        listView = findViewById(R.id.listView);
    }

    public void getAllRecords(View view) {
        List<String> data = new ArrayList<>();
        dbAdapter.open();
        Cursor result = dbAdapter.getAllContacts();
        Log.d("info", result.toString());
        Toast.makeText(this, "info " + result.getCount(), Toast.LENGTH_SHORT).show();
        while (result.moveToNext()) {
            int id = result.getInt(0);
            String name = result.getString(1);
            String email = result.getString(2);
            Toast.makeText(this,"info "+ id + "" + name + "" + email, Toast.LENGTH_SHORT).show();
            data.add("" + id + "" + name + "" + email);
            Log.d("", id + "" + name + "" + email);
        }
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, data);
        listView.setAdapter(adapter);
        dbAdapter.close();
    }
}
