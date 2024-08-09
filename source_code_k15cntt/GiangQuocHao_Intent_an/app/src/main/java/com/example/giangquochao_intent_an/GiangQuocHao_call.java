package com.example.giangquochao_intent_an;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
    import android.Manifest;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class GiangQuocHao_call extends AppCompatActivity {
    ImageButton call;
    Button btn_back1;
    EditText numbersphone;
    private static final int REQUEST_CALL_PHONE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_giang_quoc_hao_call);
        // Kiểm tra và yêu cầu quyền gọi điện khi cần
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    REQUEST_CALL_PHONE);
        }
        call = findViewById(R.id.imageButtonCall);
        btn_back1 = findViewById(R.id.btn_backcall);
        numbersphone = findViewById(R.id.edt_goi);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Kiểm tra lại quyền gọi điện
                if (ContextCompat.checkSelfPermission(GiangQuocHao_call.this, Manifest.permission.CALL_PHONE)
                        == PackageManager.PERMISSION_GRANTED) {
                    // Intent để thực hiện cuộc gọi
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + numbersphone.getText().toString()));

                    try {
                        startActivity(callIntent);
                    } catch (SecurityException e) {
                        e.printStackTrace();
                    }
                } else {
                    // Nếu quyền chưa được cấp, thông báo cho người dùng
                    Toast.makeText(GiangQuocHao_call.this, "Ứng dụng cần quyền để thực hiện cuộc gọi điện.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GiangQuocHao_call.this, GiangQuocHao_Activity.class);
                startActivity(intent);
            }
        });
    }
}