package com.example.a26_giangquochao_ltdnt_21103101456;

import android.content.Intent;
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

public class ListViewCRUD extends AppCompatActivity {
    EditText nameSing, nameSong;
    Button btn_them, btn_update, btn_delete;
    ListView listView;
    ArrayList<sing> listSing = new ArrayList<>();
    ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view_crud);
        nameSing = findViewById(R.id.edt_nameSing);
        nameSong = findViewById(R.id.edt_nameSong);
        btn_them = findViewById(R.id.btn_add);
        btn_update = findViewById(R.id.btn_update);
        btn_delete = findViewById(R.id.btn_delete);
        listView = findViewById(R.id.lv_singsong);
        listSing.add(new sing("ten bai hat 1", "ten ca si 1"));
        listSing.add(new sing("ten bai hat 2", "ten ca si 2"));
        listSing.add(new sing("ten bai hat 3", "ten ca si 3"));
        listSing.add(new sing("ten bai hat 4", "ten ca si 4"));
        listSing.add(new sing("ten bai hat 5", "ten ca si 5"));
        arrayAdapter = new ArrayAdapter<>(ListViewCRUD.this, android.R.layout.simple_list_item_1, listSing);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                nameSing.setText(listSing.get(i).getNameSing());
                nameSong.setText(listSing.get(i).getNameSong());
            }
        });
        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sing = nameSing.getText().toString();
                String song = nameSong.getText().toString();
                if(sing.isEmpty() || song.isEmpty()){
                    Toast.makeText(ListViewCRUD.this,"Vui long nhap du thong tin !", Toast.LENGTH_SHORT).show();
                } else{
                    listSing.add(new sing(song, sing));
                    arrayAdapter.notifyDataSetChanged();
                    Toast.makeText(ListViewCRUD.this,"Them thanh cong bai hat " + song, Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sing = nameSing.getText().toString();
                String song = nameSong.getText().toString();
                Intent intent = new Intent(ListViewCRUD.this, callSinger.class);
                Bundle bundle = new Bundle();
                bundle.putString("nameSing", sing);
                bundle.putString("nameSong", song);
                intent.putExtra("myBundle", bundle);
                startActivity(intent);
            }
        });
    }
}