package com.example.giangquochao_intent_an;

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

public class GiangQuocHao_web extends AppCompatActivity {
    ImageButton access;
    EditText link;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_giang_quoc_hao_web);
        access = findViewById(R.id.btn_inweb);
        link = findViewById(R.id.edt_web);
        back = findViewById(R.id.btn_backweb);
        access.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myiIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+link.getText().toString()));
                startActivity(myiIntent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GiangQuocHao_web.this, GiangQuocHao_Activity.class);
                startActivity(intent);
            }
        });
    }
}