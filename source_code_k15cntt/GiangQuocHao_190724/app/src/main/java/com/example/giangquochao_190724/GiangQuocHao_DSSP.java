package com.example.giangquochao_190724;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class GiangQuocHao_DSSP extends AppCompatActivity {
    Button btn_chitiet, btn_thoat;
    ListView lv_sp;
    ArrayList<SanPham> listSp = new ArrayList<>();
    ArrayAdapter arrayAdapter;
    static String id, name;
    static float price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_giang_quoc_hao_dssp);
        btn_chitiet = findViewById(R.id.btn_details);
        btn_thoat = findViewById(R.id.btn_exit);
        lv_sp = findViewById(R.id.lv_product);
        listSp.add(new SanPham("01","Tivi samsung", 1000));
        listSp.add(new SanPham("02","Laptop Dell", 2000));
        listSp.add(new SanPham("03","Samsung s24", 3000));
        listSp.add(new SanPham("04","Iphone 16", 5000));
        listSp.add(new SanPham("05","Card GTX", 2000));
        arrayAdapter = new ArrayAdapter<>(GiangQuocHao_DSSP.this, android.R.layout.simple_list_item_1, listSp);
        lv_sp.setAdapter(arrayAdapter);
        lv_sp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SanPham sp = listSp.get(i);
                Toast.makeText(GiangQuocHao_DSSP.this, sp.toString(), Toast.LENGTH_SHORT).show();
                id = sp.getMasp();
                name = sp.getTensp();
                price = sp.getDonGia();
            }
        });
        btn_chitiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GiangQuocHao_DSSP.this, GiangQuocHao_CTSP.class);
                Bundle bundle = new Bundle();
                if(id.isEmpty() || name.isEmpty()){
                    Toast.makeText(GiangQuocHao_DSSP.this, "VUi lòng chọn sản phẩm !", Toast.LENGTH_SHORT).show();
                } else{
                    bundle.putString("id", id);
                    bundle.putString("name", name);
                    bundle.putFloat("price", price);
                    intent.putExtra("myBundle", bundle);
                    startActivity(intent);
                }
            }
        });
    }
}