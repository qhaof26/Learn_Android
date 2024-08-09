package com.example.giangquochao_customlistview2;

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

import java.util.ArrayList;

public class CustomListViewPhone extends AppCompatActivity {
    ListView listView;
    ArrayList<Phone> arrPhone = new ArrayList<>();
    ArrayAdapter arrayAdapterPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_custom_list_view_phone);
        listView = findViewById(R.id.lv_customLV);
        arrPhone.add(new Phone("Samsung s8", R.drawable.img));
        arrPhone.add(new Phone("Iphone 4", R.drawable.img_1));
        arrPhone.add(new Phone("Xiaomi Redmi 18", R.drawable.img_2));
        arrPhone.add(new Phone("Nokia 360", R.drawable.img_3));
        arrayAdapterPhone = new ArrayAdapter<Phone>(CustomListViewPhone.this, 0, arrPhone){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                // Connect to file item_phone.xml
                LayoutInflater myInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                // object from item_phone to convertView
                convertView = myInflater.inflate(R.layout.item_phone, null);
                // Anh xa id of textView in file item_phone.xml
                TextView tv = convertView.findViewById(R.id.txtView);
                ImageView img = convertView.findViewById(R.id.imgView);
                // Get one item in arrayList
                Phone p1 = arrPhone.get(position);
                // Gán
                tv.setText(p1.getNamePhone());
                img.setImageResource(p1.getImagePhone());
                return convertView;
            }
        };
        listView.setAdapter(arrayAdapterPhone);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(CustomListViewPhone.this, "Remove: " + arrPhone.get(i).getNamePhone(), Toast.LENGTH_SHORT).show();
                arrPhone.remove(i);
                arrayAdapterPhone.notifyDataSetChanged();
                return true;
            }
        });
    }
}