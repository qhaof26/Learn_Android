package com.example.giangquochao_572024;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GiangQuocHao_572024 extends AppCompatActivity {
    TextView tv1, tv2, tv3, tv4, tv5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_giang_quoc_hao572024);
        tv1 = findViewById(R.id.tv_name1);
        tv2 = findViewById(R.id.tv_cmnd);
        tv3 = findViewById(R.id.tv_bangcap);
        tv4 = findViewById(R.id.tv_sothich);
        tv5 = findViewById(R.id.tv_tt);
        // Nhan intent duoc gui tu inputActivity
        Intent getIntent = getIntent();
        // Lay bundle ra khoi Intent
        Bundle myBundle = getIntent.getBundleExtra("myBundleSum");
        // Lay du lieu ra khoi bundle
        String hoten = myBundle.getString("name");
        String cmnd = myBundle.getString("cmnd");
        String bangcap = myBundle.getString("bangcap");
        String sothich = myBundle.getString("sothich");
        String tt = myBundle.getString("tt");
        tv1.setText("Họ tên: " + hoten);
        tv2.setText("CMND: " + cmnd);
        tv3.setText("Bằng cấp: " + bangcap);
        tv4.setText("Sở thích: " + sothich);
        tv5.setText("Thông tin bổ sung: " + tt);
    }
}