package com.example.giangquochao_190724;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GiangQuocHao_CTSP extends AppCompatActivity {
    EditText edt_ma, edt_ten, edt_gia;
    Button btn_quaylai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_giang_quoc_hao_ctsp);
        edt_ma = findViewById(R.id.edt_id);
        edt_ten = findViewById(R.id.edt_name);
        edt_gia = findViewById(R.id.edt_price);
        btn_quaylai = findViewById(R.id.btn_back);
        Intent getIntent = getIntent();
        Bundle myBundle = getIntent.getBundleExtra("myBundle");
        String hoten = myBundle.getString("name");
        String id = myBundle.getString("id");
        float gia = myBundle.getFloat("price");
        edt_ten.setText(hoten);
        edt_ma.setText(id);
        edt_gia.setText(gia+"");
    }
}