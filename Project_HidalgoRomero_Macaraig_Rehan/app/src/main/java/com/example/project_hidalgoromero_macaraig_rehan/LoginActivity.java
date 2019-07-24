package com.example.project_hidalgoromero_macaraig_rehan;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project_hidalgoromero_macaraig_rehan.model.Login;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtUsername;
    EditText edtPassword;

    CheckBox chkKeep;

    Button btnLogin;

    DBAdapter dbAdapter;

    ArrayList<Login> accountList;

    String username;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.referWidgets();
        this.loadInitialData();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        this.resetWidgets();
    }

    private void referWidgets() {
        edtUsername = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);

        chkKeep = findViewById(R.id.chk_keep);

        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);

        dbAdapter = new DBAdapter(this);

        accountList = new ArrayList<>();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                this.doLogin();
                break;
        }
    }

    private void doLogin() {
        username = edtUsername.getText().toString();
        password = edtPassword.getText().toString();

        for (int i = 0; i < accountList.size(); i++) {
            if (username.equalsIgnoreCase(accountList.get(i).getUsername()) &&
                    password.equals(accountList.get(i).getPassword())) {
                Toast.makeText(getApplicationContext(),
                        "Valid Login", Toast.LENGTH_LONG).show();
                if (chkKeep.isChecked()) {
                    //Keep Me Logged In
                    chkKeep.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            SharedPreferences preferences = getSharedPreferences("PREFERENCES_NAME", 0);
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putBoolean("isChecked", isChecked);
                            editor.commit();
                        }
                    });

                    SharedPreferences preferences1 = getSharedPreferences(" PREFERENCES_NAME", 0);
                    boolean isChecked = preferences1.getBoolean("isChecked", false);

                    if (isChecked) {
                        dbAdapter.open();
                        // call insert method
                        dbAdapter.insertContact(username, password);
                        //close db
                        dbAdapter.close();
                        // clear edit text fields
                        edtUsername.setText("");
                        edtPassword.setText("");
                        Toast.makeText(this,"Done",Toast.LENGTH_LONG).show();
                    }
                    this.startMainActivity();
                }
            } else if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, " Please fill all fields", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(),
                        "Invalid Login \n Try Again!", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void loadInitialData() {
        Login account1 = new Login("admin", "admin");
        Login account2 = new Login("user", "12345");

        accountList.add(account1);
        accountList.add(account2);
    }

    private void startMainActivity(){
        Intent mainIntent = new Intent(this, MainActivity.class);
        mainIntent.putExtra("EXTRA_USERNAME", username);
        startActivity(mainIntent);
    }


    private void resetWidgets() {
        edtUsername.setText("");
        edtPassword.setText("");
        chkKeep.setChecked(false);
    }
}
