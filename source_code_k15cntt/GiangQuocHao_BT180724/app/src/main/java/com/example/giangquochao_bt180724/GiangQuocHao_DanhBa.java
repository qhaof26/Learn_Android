package com.example.giangquochao_bt180724;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class GiangQuocHao_DanhBa extends AppCompatActivity {
    ListView lv_contacts;
    ArrayList<People> listPeople = new ArrayList<>();
    ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_giang_quoc_hao_danh_ba);
        lv_contacts = findViewById(R.id.lv_danhba);
        listPeople.add(new People("La Phong", "0934834838"));
        listPeople.add(new People("Quang Anh", "0934834454"));
        listPeople.add(new People("Thach Hao", "0371034838"));
        listPeople.add(new People("Tieu Viem", "0934839999"));
        listPeople.add(new People("Vuong Lam", "0934838888"));
        arrayAdapter = new ArrayAdapter<>(GiangQuocHao_DanhBa.this, android.R.layout.simple_list_item_1, listPeople);
        lv_contacts.setAdapter(arrayAdapter);
        lv_contacts.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                People temp = listPeople.get(i);
                Toast.makeText(GiangQuocHao_DanhBa.this, temp.toString(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(GiangQuocHao_DanhBa.this, GiangQuocHao_call_sms.class);
                Bundle myBundle = new Bundle();
                myBundle.putString("name", temp.getName());
                myBundle.putString("sdt", temp.getSdt());
                intent.putExtra("myBundle", myBundle);
                startActivity(intent);
                return true;
            }
        });
    }
}