package com.example.giangquochao_btvn972024;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class GiangQuocHao_JSON extends AppCompatActivity {
    TextView tv_username, tv_password;
    Button back1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_giang_quoc_hao_json);
        tv_username = findViewById(R.id.tv_username);
        tv_password = findViewById(R.id.tv_password);
        back1 = findViewById(R.id.btn_back1);
        Intent getIntent = getIntent();
        Bundle myBundle = getIntent.getBundleExtra("myBundleJSON");
        String username = myBundle.getString("username");
        String password = myBundle.getString("password");
        tv_username.setText("Tên đăng nhập: " + username);
        tv_password.setText("Mật khẩu: " + password);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GiangQuocHao_JSON.this, GiangQuocHao_menu.class);
                startActivity(intent);
            }
        });
    }
}