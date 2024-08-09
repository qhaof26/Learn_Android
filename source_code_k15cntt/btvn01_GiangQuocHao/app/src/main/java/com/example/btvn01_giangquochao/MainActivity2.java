package com.example.btvn01_giangquochao;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    // Khai bao bien giao dien chuong trinh
    EditText edt_ten;
    Button btn_ten;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        // Anh xa cac id vao cac bien giao dien
        edt_ten = findViewById(R.id.edt_name);
        btn_ten = findViewById(R.id.btn_ten);
        btn_ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edt_ten.getText().toString();
                //1. Hien thi bang Toast
                Toast.makeText(MainActivity2.this, "Tên vừa nhập: " + name, Toast.LENGTH_SHORT).show();

                //2. Hien thi bang Dialog
                //2.1 Khoi tao dialog
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity2.this);
                //2.2 Tao tieu de cho dialog
                dialog.setTitle("Thông tin sinh viên");
                //2.3 Hien thi noi dung cua dialog
                dialog.setMessage("Họ tên vừa nhập: " + name);
                //2.4 Tao nut dong
                dialog.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                dialog.create().show();
            }
        });
    }
}