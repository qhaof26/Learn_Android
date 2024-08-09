package com.example.giangquochao_btvnmenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class menu_bill extends AppCompatActivity {
    EditText hoten, cs1, cs2, thanhtien;
    Button btn_tinh, btn_tinhlai, btn_thoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu_bill);
        hoten = findViewById(R.id.edt_hoten);
        cs1 = findViewById(R.id.edt_csprev);
        cs2 = findViewById(R.id.edt_csafter);
        thanhtien = findViewById(R.id.edt_total);
        btn_tinh = findViewById(R.id.btn_cal);
        btn_thoat = findViewById(R.id.btn_exit);
        btn_tinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int prev = Integer.parseInt(cs1.getText().toString());
                int after = Integer.parseInt(cs2.getText().toString());
                float total = (float) ((after - prev) * (2500 + (2500*0.1)));
                thanhtien.setText(total +"");
            }
        });
        btn_thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menu_bill.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}