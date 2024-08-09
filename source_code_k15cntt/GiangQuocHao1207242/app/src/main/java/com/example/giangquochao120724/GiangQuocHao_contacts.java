package com.example.giangquochao120724;

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
import android.Manifest;
import java.util.ArrayList;
import java.util.List;

public class GiangQuocHao_contacts extends AppCompatActivity {
    EditText numbers;
    Button add, call, back;
    ListView contacts;
    List<String> listSDT = new ArrayList<>();
    ArrayAdapter arrayAdapter;
    private static final int REQUEST_CALL_PHONE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_giang_quoc_hao_contacts);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    REQUEST_CALL_PHONE);
        }
        numbers = findViewById(R.id.edt_sdt);
        add = findViewById(R.id.btn_add);
        call = findViewById(R.id.btn_call);
        back = findViewById(R.id.btn_back);
        contacts = findViewById(R.id.lv_sdt);
        listSDT.add("0934834348");
        listSDT.add("0934834587");
        listSDT.add("0934834348");
        listSDT.add("0931749348");
        listSDT.add("0905664348");
        arrayAdapter = new ArrayAdapter<>(GiangQuocHao_contacts.this, android.R.layout.simple_list_item_1, listSDT);
        contacts.setAdapter(arrayAdapter);
        contacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = listSDT.get(i);
                numbers.setText(item);
            }
        });
        // Events add click
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = numbers.getText().toString();
                if(num.isEmpty()){
                    Toast.makeText(GiangQuocHao_contacts.this, "Vui lòng nhập sdt !", Toast.LENGTH_SHORT).show();
                } else {
                    listSDT.add(num);
                    arrayAdapter.notifyDataSetChanged();
                }
            }
        });
        // call
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(GiangQuocHao_contacts.this, Manifest.permission.CALL_PHONE)
                        == PackageManager.PERMISSION_GRANTED) {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + numbers.getText().toString()));

                    try {
                        startActivity(callIntent);
                    } catch (SecurityException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(GiangQuocHao_contacts.this, "Ứng dụng cần quyền để thực hiện cuộc gọi điện.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        // tiep
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GiangQuocHao_contacts.this, GiangQuocHao_menu.class);
                startActivity(intent);
            }
        });
    }
}