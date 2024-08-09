package com.example.giangquochao_btvn190724;

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

public class GiangQuocHao_CSKTX extends AppCompatActivity {
    ListView ktx;
    ArrayList<String> listKTX = new ArrayList<>();
    ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_giang_quoc_hao_csktx);
        ktx = findViewById(R.id.lv_ktx);
        listKTX.add("Lĩnh Nam");
        listKTX.add("Minh Khai");
        listKTX.add("Nam Định");
        listKTX.add("Mỹ Xá");
        arrayAdapter = new ArrayAdapter<>(GiangQuocHao_CSKTX.this, android.R.layout.simple_list_item_1, listKTX);
        ktx.setAdapter(arrayAdapter);
        ktx.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(GiangQuocHao_CSKTX.this, "KTX: " + listKTX.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }
}