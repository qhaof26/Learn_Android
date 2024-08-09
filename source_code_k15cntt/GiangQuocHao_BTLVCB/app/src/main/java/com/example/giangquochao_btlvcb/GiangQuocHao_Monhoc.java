package com.example.giangquochao_btlvcb;

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
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class GiangQuocHao_Monhoc extends AppCompatActivity {
    EditText monhoc;
    Button add, update, delete;
    ListView lv_monhoc;
    List<String> listSub = new ArrayList<>();
    ArrayAdapter arrayAdapter;
    // ArrayList <-> Adapter <-> ListView
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_giang_quoc_hao_monhoc);
        monhoc = findViewById(R.id.edt_monhoc);
        add = findViewById(R.id.btn_add);
        update = findViewById(R.id.btn_update);
        delete = findViewById(R.id.btn_delete);
        lv_monhoc = findViewById(R.id.lv_monhoc);
        // Create arraylist and set value for arraylist
        listSub.add("Toán rời rạc");
        listSub.add("Toán cao cấp");
        listSub.add("Kinh tế số");
        listSub.add("Vật lý");
        listSub.add("Mạng máy tính");
        // Create ArrayAdapter and Set value from arraylist to ArrayAdapter
        arrayAdapter = new ArrayAdapter<>(GiangQuocHao_Monhoc.this, android.R.layout.simple_list_item_1, listSub);
        // Set ArrayAdapter for ListView contacts
        lv_monhoc.setAdapter(arrayAdapter);
        // Code events on click one obj in ListView
        lv_monhoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Get item while clicked
                String item = listSub.get(i);
                index = i;
                monhoc.setText("Môn học: " + item);
            }
        });
        // Events add click
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = monhoc.getText().toString();
                if(temp.isEmpty()){
                    Toast.makeText(GiangQuocHao_Monhoc.this, "Vui lòng nhập sdt !", Toast.LENGTH_SHORT).show();
                } else {
                    listSub.add(temp);
                    arrayAdapter.notifyDataSetChanged();
                }
            }
        });
        // Events update click
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = monhoc.getText().toString();
                if(temp.isEmpty()){
                    Toast.makeText(GiangQuocHao_Monhoc.this, "Vui lòng nhập môn học!", Toast.LENGTH_SHORT).show();
                } else {
                    listSub.set(index, temp);
                    arrayAdapter.notifyDataSetChanged();
                }
            }
        });
        // Events delete click
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    listSub.remove(index);
                    monhoc.setText("");
                    arrayAdapter.notifyDataSetChanged();
                } catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }
}