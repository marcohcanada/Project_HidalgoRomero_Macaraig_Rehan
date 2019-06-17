package com.jk.mvc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.jk.mvc.controller.UserController;
import com.jk.mvc.model.User;

public class MainActivity extends AppCompatActivity {

    UserController userController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userController = new UserController();

        this.fetchUserInfo();
    }

    private void fetchUserInfo() {
        Intent thisIntent = this.getIntent();
        String email = thisIntent.getStringExtra("EXTRA_EMAIL");
        User currentUser = UserController.fetchUserByEmail(email);
        Log.d("MainActivity", currentUser.toString());
        Log.d("MainActivity", "First name: " + currentUser.getFirstName());
        Toast.makeText(getApplicationContext(), email, Toast.LENGTH_LONG).show();
    }
}
