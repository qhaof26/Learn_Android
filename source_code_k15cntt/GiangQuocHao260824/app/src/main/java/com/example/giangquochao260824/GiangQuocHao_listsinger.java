package com.example.giangquochao260824;

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
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class GiangQuocHao_listsinger extends AppCompatActivity {
    EditText edt_sing, edt_song;
    Button add;
    ListView lv_song;
    ArrayList<Music> listMusic = new ArrayList<>();
    ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_giang_quoc_hao_listsinger);
        edt_song = findViewById(R.id.song);
        edt_sing = findViewById(R.id.sing);
        add = findViewById(R.id.btn_add);
        lv_song = findViewById(R.id.lv_song);
        listMusic.add(new Music("Giang Hao", "Chu voi con"));
        listMusic.add(new Music("Trung Anh", "Tim lai da"));
        listMusic.add(new Music("Anh Hao", "Het Thuong can nho"));
        listMusic.add(new Music("NHung Quan", "Lac Troi"));
        listMusic.add(new Music("La Phong", "Thon phe tinh khong"));
        arrayAdapter = new ArrayAdapter<>(GiangQuocHao_listsinger.this, android.R.layout.simple_list_item_1, listMusic);
        lv_song.setAdapter(arrayAdapter);
        lv_song.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listMusic.add(new Music(edt_sing.getText().toString(), edt_song.getText().toString()));
                arrayAdapter.notifyDataSetChanged();
                Toast.makeText(GiangQuocHao_listsinger.this,"Thêm thành công bài hát" + edt_song.getText().toString(), Toast.LENGTH_SHORT ).show();
            }
        });
    }
}