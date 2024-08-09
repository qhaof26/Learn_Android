package com.example.giangquochao_examtest;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class GiangQuocHao_danhba250724 extends AppCompatActivity {
    private static final int REQUEST_CALL_PHONE = 1;
    EditText edt_ten, edt_sdt;
    Button btn_them;
    ListView lv_sdt;
    ArrayList<Phone> listPhone = new ArrayList<>();
    ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_giang_quoc_hao_contacts);
        edt_sdt = findViewById(R.id.edt_phone);
        edt_ten = findViewById(R.id.edt_name);
        btn_them = findViewById(R.id.btn_add);
        lv_sdt = findViewById(R.id.lv_contact);
        listPhone.add(new Phone("Giang Hao", "09348343443"));
        listPhone.add(new Phone("Quang Anh", "093483878443"));
        listPhone.add(new Phone("Giang Trung", "0934867567"));
        listPhone.add(new Phone("Nam Hao", "093483467673"));
        listPhone.add(new Phone("Tran Hao", "09348374543"));
        arrayAdapter = new ArrayAdapter<>(GiangQuocHao_danhba250724.this, android.R.layout.simple_list_item_1, listPhone);
        lv_sdt.setAdapter(arrayAdapter);
        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Phone p1 = new Phone(edt_ten.getText().toString(), edt_sdt.getText().toString());
                listPhone.add(p1);
                Toast.makeText(GiangQuocHao_danhba250724.this, "Thêm thành công : " + p1.toString(), Toast.LENGTH_SHORT).show();
                arrayAdapter.notifyDataSetChanged();
            }
        });

        lv_sdt.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                ActivityCompat.requestPermissions(GiangQuocHao_danhba250724.this,new String[]{Manifest.permission.CALL_PHONE}, 1);
                String sdt = listPhone.get(i).getNumber();
                Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + sdt));
                startActivity(callIntent);
                return true;
            }
        });
    }
}