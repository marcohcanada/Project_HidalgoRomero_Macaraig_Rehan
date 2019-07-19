package com.example.listviewcustomexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Province> provinceList = new ArrayList<Province>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        createList();

        MyAdapter adapter = new MyAdapter(this, R.layout.activity_main, provinceList);
        // ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);



    }

    public void createList(){

        Province p1 = new Province("Alberta","Edmonton", R.drawable.alberta);
        provinceList.add(p1);
        Province p2 = new Province("British Columbia","Victoria", R.drawable.british_columbia);
        provinceList.add(p2);
        Province p3 = new Province("Manitoba","Winnipeg", R.drawable.manitoba);
        provinceList.add(p3);
        Province p4 = new Province("New Brunswick","Fredericton", R.drawable.new_brunswick);
        provinceList.add(p4);
        Province p5 = new Province("Newfoundland and Labrador","St. John's", R.drawable.newfoundland_and_labrador);
        provinceList.add(p5);
        Province p6 = new Province("Nova Scotia","Halifax", R.drawable.nova_scotia);
        provinceList.add(p6);
        Province p7 = new Province("Ontario","Toronto", R.drawable.ontario);
        provinceList.add(p7);
        Province p8 = new Province("Quebec","Quebec City", R.drawable.quebec);
        provinceList.add(p8);
        Province p9 = new Province("Saskatchewan","Regina", R.drawable.saskatchewan);
        provinceList.add(p9);
        Province p10 = new Province("Prince Edward ","Charlottetown", R.drawable.prince_edward_island);
        provinceList.add(p10);

    }

}

