package com.example.giangquochao_btvn972024;

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

public class GiangQuocHao_message extends AppCompatActivity {
    EditText message;
    ImageButton sendMessage;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_giang_quoc_hao_message);
        message = findViewById(R.id.edt_messs);
        sendMessage = findViewById(R.id.btn_send);
        back = findViewById(R.id.btn_back);
        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myiIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+message.getText().toString()));
                startActivity(myiIntent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GiangQuocHao_message.this, GiangQuocHao_menu.class);
                startActivity(intent);
            }
        });
    }
}