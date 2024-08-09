package com.example.giangquochao_bt180724;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GiangQuocHao_call_sms extends AppCompatActivity {
    TextView name, sdt;
    ImageButton call, sms;
    private static final int REQUEST_CALL_PHONE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_giang_quoc_hao_call_sms);
        name = findViewById(R.id.tv_name);
        sdt = findViewById(R.id.tv_sdt);
        call = findViewById(R.id.btn_call);
        sms = findViewById(R.id.btn_sms);
        Intent getIntent = getIntent();
        Bundle myBundle = getIntent.getBundleExtra("myBundle");
        String hoten = myBundle.getString("name");
        String phone = myBundle.getString("sdt");
        name.setText(hoten);
        sdt.setText(phone);
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    REQUEST_CALL_PHONE);
        }
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Kiểm tra lại quyền gọi điện
                if (ContextCompat.checkSelfPermission(GiangQuocHao_call_sms.this, Manifest.permission.CALL_PHONE)
                        == PackageManager.PERMISSION_GRANTED) {
                    // Intent để thực hiện cuộc gọi
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + phone));

                    try {
                        startActivity(callIntent);
                    } catch (SecurityException e) {
                        e.printStackTrace();
                    }
                } else {
                    // Nếu quyền chưa được cấp, thông báo cho người dùng
                    Toast.makeText(GiangQuocHao_call_sms.this, "Ứng dụng cần quyền để thực hiện cuộc gọi điện.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myiIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+phone));
                startActivity(myiIntent);
            }
        });
    }
}