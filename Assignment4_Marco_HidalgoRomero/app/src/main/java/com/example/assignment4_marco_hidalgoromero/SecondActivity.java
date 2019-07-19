package com.example.assignment4_marco_hidalgoromero;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.assignment4_marco_hidalgoromero.model.Province;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    List<Province> provinceList = new ArrayList<Province>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        createList();
        ProvinceAdapter adapter = new ProvinceAdapter(this, R.layout.listview_row, provinceList);
        listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(listOutput);

    }



        private AdapterView.OnItemClickListener listOutput = new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);


                Province province = (Province) listView.getItemAtPosition(position);
                Intent capitalIntent = new Intent();
                capitalIntent.putExtra("CAPITAL CITY", province.getCapital());
                setResult(Activity.RESULT_OK, capitalIntent);

                capitalIntent.putExtra("PROVINCE NAME", province.getName());
                setResult(Activity.RESULT_OK, capitalIntent);

                finish();

            }
        };


    public void createList() {

        Province province1 = new Province("Alberta","Edmonton", R.drawable.alberta);
        provinceList.add(province1);
        Province province2 = new Province("British Columbia","Victoria", R.drawable.british_columbia);
        provinceList.add(province2);
        Province province3 = new Province("Manitoba","Winnipeg", R.drawable.manitoba);
        provinceList.add(province3);
        Province province4 = new Province("New Brunswick","Fredericton", R.drawable.new_brunswick);
        provinceList.add(province4);
        Province province5 = new Province("Newfoundland and Labrador","St. John's", R.drawable.newfoundland_and_labrador);
        provinceList.add(province5);
        Province province6 = new Province("Nova Scotia","Halifax", R.drawable.nova_scotia);
        provinceList.add(province6);
        Province province7 = new Province("Ontario","Toronto", R.drawable.ontario);
        provinceList.add(province7);
        Province province8 = new Province("Quebec","Quebec City", R.drawable.quebec);
        provinceList.add(province8);
        Province province9 = new Province("Saskatchewan","Regina", R.drawable.saskatchewan);
        provinceList.add(province9);
        Province province10 = new Province("Prince Edward Island","Charlottetown", R.drawable.prince_edward_island);
        provinceList.add(province10);
    }
}
