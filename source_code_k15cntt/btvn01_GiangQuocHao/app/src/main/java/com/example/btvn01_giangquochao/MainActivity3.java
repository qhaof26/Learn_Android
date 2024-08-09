package com.example.btvn01_giangquochao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {
    EditText edt_fullname, edt_username, edt_password, edt_phoneemail;
    Button btn_log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        edt_fullname = findViewById(R.id.edt_fullname);
        edt_username = findViewById(R.id.edt_username);
        edt_password = findViewById(R.id.edt_password);
        edt_phoneemail = findViewById(R.id.edt_phoneemail);
        btn_log = findViewById(R.id.btn_log);
        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullname = edt_fullname.getText().toString();
                String username = edt_username.getText().toString();
                String password = edt_password.getText().toString();
                String email = edt_phoneemail.getText().toString();
                if(fullname.equals("")){
                    Toast.makeText(MainActivity3.this, "Vui lòng nhập họ tên !", Toast.LENGTH_SHORT).show();
                } else if(username.equals("")){
                    Toast.makeText(MainActivity3.this, "Vui lòng nhập username !", Toast.LENGTH_SHORT).show();
                } else if(password.equals("")){
                    Toast.makeText(MainActivity3.this, "Vui lòng nhập mật khẩu !", Toast.LENGTH_SHORT).show();
                } else if(email.equals("")){
                    Toast.makeText(MainActivity3.this, "Vui lòng nhập SDT hoặc email !", Toast.LENGTH_SHORT).show();
                } else{
                    Intent intent = new Intent(MainActivity3.this, GiangQuocHao_572024.class);
                    Bundle myBundle = new Bundle();
                    myBundle.putString("name", fullname);
                    myBundle.putString("username", username);
                    myBundle.putString("password", password);
                    myBundle.putString("email", email);
                    intent.putExtra("myBundleSum", myBundle);
                    startActivity(intent);
                }
            }
        });
    }
}