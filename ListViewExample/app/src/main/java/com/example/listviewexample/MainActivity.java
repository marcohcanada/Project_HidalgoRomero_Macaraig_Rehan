package com.example.listviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] cities = new String[] {"Toronto", "Mississauga", "Ottawa", "London", "Calgary",
            "New York", "Mexico City"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.referWidgets();
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, cities);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                String item = (String) parent.getItemAtPosition(position);
                Toast.makeText(parent.getContext(), "Selected: " + item,
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    private void referWidgets() {
        listView = findViewById(R.id.list);
    }
}
