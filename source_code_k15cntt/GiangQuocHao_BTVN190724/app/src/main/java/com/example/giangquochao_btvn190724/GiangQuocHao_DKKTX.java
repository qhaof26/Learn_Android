package com.example.giangquochao_btvn190724;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GiangQuocHao_DKKTX extends AppCompatActivity {
    Button btn_chon, btn_thoat, btn_tiep;
    RadioGroup rdG;
    RadioButton rd1g, rd2g, rd4g, rd8g;
    CheckBox cb1, cb2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_giang_quoc_hao_dkktx);
        btn_chon = findViewById(R.id.btn_choose);
        btn_tiep = findViewById(R.id.btn_next);
        btn_thoat = findViewById(R.id.btn_exit);
        rdG = findViewById(R.id.radioGroup);
        rd1g = findViewById(R.id.rd1);
        rd2g = findViewById(R.id.rd2);
        rd4g = findViewById(R.id.rd4);
        rd8g = findViewById(R.id.rd8);
        cb1 = findViewById(R.id.checkBox1);
        cb2 = findViewById(R.id.checkBox2);
        // Choose
        btn_chon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Loai Phong ngu
                String optionRoomBed = "";
                int isSelectedRadioGroup = rdG.getCheckedRadioButtonId();
                if(isSelectedRadioGroup != -1){
                    RadioButton rd = findViewById(isSelectedRadioGroup);
                    optionRoomBed = rd.getText().toString();
                }
                // Dich vu
                String optionService = "";
                if(cb1.isChecked()){
                    optionService = optionService + cb1.getText().toString();
                }
                if(cb2.isChecked()){
                    optionService = optionService + " - " + cb2.getText().toString();
                }
                if(optionRoomBed.equals("") || optionService.equals("")){
                    Toast.makeText(GiangQuocHao_DKKTX.this, "Vui lòng chọn đủ thông tin !", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(GiangQuocHao_DKKTX.this,optionRoomBed + " | " + optionService, Toast.LENGTH_LONG).show();
                }
            }
        });
        // exit
        btn_thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GiangQuocHao_DKKTX.this, MainActivity.class);
                startActivity(intent);
            }
        });
        // Next
        btn_tiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GiangQuocHao_DKKTX.this, GiangQuocHao_CSKTX.class);
                startActivity(intent);
            }
        });
    }
}