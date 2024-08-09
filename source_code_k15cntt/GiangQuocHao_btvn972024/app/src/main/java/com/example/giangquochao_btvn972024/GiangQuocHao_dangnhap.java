package com.example.giangquochao_btvn972024;

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

public class GiangQuocHao_dangnhap extends AppCompatActivity {
    EditText user, pass;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_giang_quoc_hao_dangnhap);
        user = findViewById(R.id.edt_username);
        pass = findViewById(R.id.edt_password);
        login = findViewById(R.id.btn_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = user.getText().toString();
                String password = pass.getText().toString();
                if(username.equals("cnttk15") && password.equals("123456")){
                    Intent myinIntent = new Intent(GiangQuocHao_dangnhap.this, GiangQuocHao_menu.class);
                    Bundle myBundle = new Bundle();
                    myBundle.putString("username", username);
                    myBundle.putString("password", password);
                    myinIntent.putExtra("myBundle", myBundle);
                    startActivity(myinIntent);
                } else if(!username.equalsIgnoreCase("cnttk15")){
                    Toast.makeText(GiangQuocHao_dangnhap.this, "Tài khoản không tồn tại !" , Toast.LENGTH_SHORT).show();
                } else if(!password.equalsIgnoreCase("123456")){
                    Toast.makeText(GiangQuocHao_dangnhap.this, "Sai mật khẩu !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}