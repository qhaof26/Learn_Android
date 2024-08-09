package com.example.giangquochao120724;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class GiangQuocHao_DSSP extends AppCompatActivity {
    ListView dssp;
    List<String> listSP = new ArrayList<>();
    ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_giang_quoc_hao_dssp);
        dssp = findViewById(R.id.lv_sp);
        listSP.add("Vertu");
        listSP.add("Iphone 15");
        listSP.add("Nokia 925");
        listSP.add("Samsung s24");
        listSP.add("Vivo");
        arrayAdapter = new ArrayAdapter<>(GiangQuocHao_DSSP.this, android.R.layout.simple_list_item_1, listSP);
        dssp.setAdapter(arrayAdapter);
        dssp.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                String temp = listSP.get(i);
                Toast.makeText(GiangQuocHao_DSSP.this, "Bạn đã chọn sản phẩm: " + temp, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(GiangQuocHao_DSSP.this, GiangQuocHao_DetailProduct.class);
                Bundle myBundle = new Bundle();
                myBundle.putString("name", temp);
                intent.putExtra("myBundle", myBundle);
                startActivity(intent);
                return true;
            }
        });
    }
}