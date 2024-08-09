package com.example.giangquochao_btvn190724;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText tv_tendn, tv_matkhau;
    Button btn_dangnhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        tv_tendn = findViewById(R.id.edt_username);
        tv_matkhau = findViewById(R.id.edt_pass);
        btn_dangnhap = findViewById(R.id.btn_login);
        btn_dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = tv_tendn.getText().toString();
                String password = tv_matkhau.getText().toString();
                if(username.isEmpty() || password.isEmpty()){
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đủ thông tin !", Toast.LENGTH_SHORT).show();
                } else if(!username.equals("cnttk15")){
                    Toast.makeText(MainActivity.this, "Tài khoản sai !", Toast.LENGTH_SHORT).show();
                } else if(!password.equals("123456")){
                    Toast.makeText(MainActivity.this, "Mật khẩu sai !", Toast.LENGTH_SHORT).show();
                } else if(username.equals("cnttk15") && password.equals("123456")){
                    Intent intent = new Intent(MainActivity.this, GiangQuocHao_DKKTX.class);
                    startActivity(intent);
                }
            }
        });
    }
}