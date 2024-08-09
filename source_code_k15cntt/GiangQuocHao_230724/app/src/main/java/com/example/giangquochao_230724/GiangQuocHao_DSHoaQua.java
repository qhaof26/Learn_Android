package com.example.giangquochao_230724;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class GiangQuocHao_DSHoaQua extends AppCompatActivity {
    ListView listView;
    ArrayList<HoaQUa> arrHQ = new ArrayList<>();
    ArrayAdapter arrayAdapterHQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_giang_quoc_hao_dshoa_qua);
        listView = findViewById(R.id.lv_hq);
        arrHQ.add(new HoaQUa(R.drawable.img, "Quả chuối", 1000));
        arrHQ.add(new HoaQUa(R.drawable.img_1, "Quả táo", 2000));
        arrHQ.add(new HoaQUa(R.drawable.img_2, "Quả cheri", 3000));
        arrayAdapterHQ = new ArrayAdapter<HoaQUa>(GiangQuocHao_DSHoaQua.this, 0, arrHQ){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                // Connect to file item_phone.xml
                LayoutInflater myInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                // object from item_phone to convertView
                convertView = myInflater.inflate(R.layout.item_hoaqua, null);
                // Anh xa id of textView in file item_phone.xml
                TextView tvTen = convertView.findViewById(R.id.tv_namehq);
                TextView tvGia = convertView.findViewById(R.id.tv_price);
                ImageView img = convertView.findViewById(R.id.imageView);
                // Get one item in arrayList
                HoaQUa p1 = arrHQ.get(position);
                // Gán
                tvTen.setText(p1.getNameHq());
                tvGia.setText(p1.getPrice()+"");
                img.setImageResource(p1.getIdImage());
                return convertView;
            }
        };
        listView.setAdapter(arrayAdapterHQ);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(GiangQuocHao_DSHoaQua.this, "Remove: " + arrHQ.get(i).getNameHq(), Toast.LENGTH_SHORT).show();
                arrHQ.remove(i);
                arrayAdapterHQ.notifyDataSetChanged();
                return true;
            }
        });
    }
}