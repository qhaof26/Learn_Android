package com.example.giangquochao_intentan;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText phone;
    ImageButton call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        call = findViewById(R.id.btn_call);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Tạo Intent với hành động ACTION_CALL
                Intent intent = new Intent(Intent.ACTION_CALL);
                String phoneNumber = phone.getText().toString();
                // Thiết lập dữ liệu Uri cho số điện thoại
                intent.setData(Uri.parse("tel:" + phoneNumber));

                try {
                    // Thử khởi chạy Intent
                    startActivity(intent);
                } catch (SecurityException e) {
                    // Xử lý ngoại lệ nếu không có quyền gọi điện thoại
                    e.printStackTrace();
                }

            }
        });
    }
}