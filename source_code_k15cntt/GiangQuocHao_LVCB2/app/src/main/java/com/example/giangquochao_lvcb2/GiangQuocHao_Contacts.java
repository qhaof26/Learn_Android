package com.example.giangquochao_lvcb2;

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

import java.util.ArrayList;

public class GiangQuocHao_Contacts extends AppCompatActivity {
    ListView lv_sdt;
    EditText edt_ten, edt_sdt1;
    Button btn_them, btn_sua, btn_xoa;
    ArrayList<Phone> listPhone = new ArrayList<>();
    ArrayAdapter arrayAdapter;
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_giang_quoc_hao_contacts);
        lv_sdt = findViewById(R.id.lv_contacts);
        edt_ten = findViewById(R.id.edt_fullName);
        edt_sdt1 = findViewById(R.id.edt_phone);
        btn_them = findViewById(R.id.btn_add);
        btn_sua = findViewById(R.id.btn_update);
        btn_xoa = findViewById(R.id.btn_delete);
        listPhone.add(new Phone("La Phong", "0934834838"));
        listPhone.add(new Phone("Quang Anh", "0934834454"));
        listPhone.add(new Phone("Thach Hao", "0371034838"));
        listPhone.add(new Phone("Tieu Viem", "0934839999"));
        listPhone.add(new Phone("Vuong Lam", "0934838888"));
        arrayAdapter = new ArrayAdapter<>(GiangQuocHao_Contacts.this, android.R.layout.simple_list_item_1, listPhone);
        lv_sdt.setAdapter(arrayAdapter);
        lv_sdt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Phone item = listPhone.get(i);
                index = i;
                edt_ten.setText(item.getFullName());
                edt_sdt1.setText(item.getNumbersPhone());
            }
        });
        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edt_ten.getText().toString();
                String sdt = edt_sdt1.getText().toString();
                if(name.isEmpty() || sdt.isEmpty()){
                    Toast.makeText(GiangQuocHao_Contacts.this, "Vui lòng nhập đủ thông tin !", Toast.LENGTH_SHORT).show();
                } else {
                    listPhone.add(new Phone(name, sdt));
                    arrayAdapter.notifyDataSetChanged();
                }
            }
        });
        btn_sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edt_ten.getText().toString();
                String sdt = edt_sdt1.getText().toString();
                if(name.isEmpty() || sdt.isEmpty()){
                    Toast.makeText(GiangQuocHao_Contacts.this, "Vui lòng nhập đủ thông tin !", Toast.LENGTH_SHORT).show();
                } else {
                    listPhone.set(index, new Phone(name, sdt));
                    arrayAdapter.notifyDataSetChanged();
                }
            }
        });
        btn_xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    listPhone.remove(index);
                    edt_ten.setText("");
                    edt_sdt1.setText("");
                    arrayAdapter.notifyDataSetChanged();
                } catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });

    }
}