package com.example.giangquochao_customlistview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String namephone[] = {"Điện thoại Iphone 12", "Điện thoại SamSung S20", "Điện thoại Nokia 6","Điện thoại Bphone 2020","Điện thoại Oppo 5","Điện thoại VSmart joy2"};
    int imagephone[] = {R.drawable.icon_phone, R.drawable.icon_phone, R.drawable.icon_phone, R.drawable.icon_phone, R.drawable.icon_phone, R.drawable.icon_phone};
    ArrayList<Phone> mylist; // Khai báo mảng chính
    MyArrayAdapter myadapter; //Khai báo Adapter
    ListView lv; //Khai báo Listview
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv_phone);
        mylist = new ArrayList<>();
        for (int i = 0; i < namephone.length; i++) {
            mylist.add(new Phone(imagephone[i], namephone[i]));
        }
        myadapter = new MyArrayAdapter(this, R.layout.layout_listview, mylist);
        lv.setAdapter(myadapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent myintent = new Intent(MainActivity.this, SubActivity.class);
                myintent.putExtra("name", namephone[i]);
                startActivity(myintent);
            }
        });

    }
}