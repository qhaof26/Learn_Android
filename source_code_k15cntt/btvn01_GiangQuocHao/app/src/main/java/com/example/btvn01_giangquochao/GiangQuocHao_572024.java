package com.example.btvn01_giangquochao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GiangQuocHao_572024 extends AppCompatActivity {
    TextView tv1, tv2, tv3, tv4;
    Button btn_exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_giang_quoc_hao572024);
        tv1 = findViewById(R.id.tv_begin);
        tv2 = findViewById(R.id.tv_username);
        tv3 = findViewById(R.id.tv_pass);
        tv4 = findViewById(R.id.tv_email);
        btn_exit = findViewById(R.id.btn_exit);
        // Nhan intent duoc gui tu inputActivity
        Intent getIntent = getIntent();
        // Lay bundle ra khoi Intent
        Bundle myBundle = getIntent.getBundleExtra("myBundleSum");
        // Lay du lieu ra khoi bundle
        String hoten = myBundle.getString("name");
        String username = myBundle.getString("username");
        String password = myBundle.getString("password");
        String email = myBundle.getString("email");
        tv1.setText("Chúc mừng bạn " + hoten + " đã đăng ký thành công !");
        tv2.setText("Tên đăng nhập của bạn: " + username);
        tv3.setText("Mật khẩu: " + password);
        tv4.setText("Email hoặc SDT đăng ký: " + email);
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GiangQuocHao_572024.this, MainActivity3.class);
                startActivity(intent);
            }
        });
    }
}