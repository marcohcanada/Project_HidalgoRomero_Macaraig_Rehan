package com.example.menuexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_always) {
            //Toast.makeText(this, "You clicked Always", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Main2Activity.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.action_ifRoom) {
            Toast.makeText(this, "You clicked In Room", Toast.LENGTH_SHORT).show();
            return true;
        }

        if (id == R.id.action_never) {
            Toast.makeText(this, "You clicked Never", Toast.LENGTH_SHORT).show();
            return true;
        }

        if (id == R.id.action_settings) {
            Toast.makeText(this, "You clicked Settings", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
