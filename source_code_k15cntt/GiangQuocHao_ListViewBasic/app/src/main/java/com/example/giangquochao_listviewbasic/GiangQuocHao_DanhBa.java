package com.example.giangquochao_listviewbasic;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class GiangQuocHao_DanhBa extends AppCompatActivity {
    TextView sdt;
    EditText numbers;
    Button add, update, delete;
    ListView contacts;
    List<String> listSDT = new ArrayList<>();
    ArrayAdapter arrayAdapter;
    // ArrayList <-> Adapter <-> ListView
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_giang_quoc_hao_danh_ba);
        sdt = findViewById(R.id.tv_sdt);
        contacts = findViewById(R.id.lv_sdt);
        numbers = findViewById(R.id.edt_sdt);
        add = findViewById(R.id.btn_add);
        update = findViewById(R.id.btn_update);
        delete = findViewById(R.id.btn_delete);
        // Create arraylist and set value for arraylist
        listSDT.add("0934834348");
        listSDT.add("0934834587");
        listSDT.add("0934834348");
        listSDT.add("0931749348");
        listSDT.add("0905664348");
        // Create ArrayAdapter and Set value from arraylist to ArrayAdapter
        arrayAdapter = new ArrayAdapter<>(GiangQuocHao_DanhBa.this, android.R.layout.simple_list_item_1, listSDT);
        // Set ArrayAdapter for ListView contacts
        contacts.setAdapter(arrayAdapter);
        // Code events on click one obj in ListView
        contacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Get item while clicked
                String item = listSDT.get(i);
                index = i;
                sdt.setText("SDT vừa chọn: " + item + " ở vị trí thứ " + index);
                numbers.setText(item);
            }
        });
        // Events add click
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = numbers.getText().toString();
                if(num.isEmpty()){
                    Toast.makeText(GiangQuocHao_DanhBa.this, "Vui lòng nhập sdt !", Toast.LENGTH_SHORT).show();
                } else {
                    listSDT.add(num);
                    arrayAdapter.notifyDataSetChanged();
                }
            }
        });
        // Events update click
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = numbers.getText().toString();
                if(num.equals("")){
                    Toast.makeText(GiangQuocHao_DanhBa.this, "Vui lòng nhập sdt !", Toast.LENGTH_SHORT).show();
                } else {
                    listSDT.set(index, num);
                    arrayAdapter.notifyDataSetChanged();
                }
            }
        });
        // Events delete click
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    listSDT.remove(index);
                    numbers.setText("");
                    sdt.setText("");
                    arrayAdapter.notifyDataSetChanged();
                } catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }
}