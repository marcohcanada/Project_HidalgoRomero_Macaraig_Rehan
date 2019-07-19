package com.example.dialogsexample;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    String[] itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        itemList = new String[4];
        itemList[0] = "item 1";
        itemList[1] = "item 2";
        itemList[2] = "item 3";
        itemList[3] = "item 4";

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showList(v);
            }
        });

    }

    public void showDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("My Dialog")
                .setMessage(" would like to continue")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        showToastMessage();
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void showList( View v){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("selectable list")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setItems(itemList, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this ,
                        " you selected "+itemList[which],
                        Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    private void showToastMessage(){
        Toast.makeText(this, " Ok Button is Clicked", Toast.LENGTH_LONG).show();
        textView.setText(" Ok is selected");
    }
}
