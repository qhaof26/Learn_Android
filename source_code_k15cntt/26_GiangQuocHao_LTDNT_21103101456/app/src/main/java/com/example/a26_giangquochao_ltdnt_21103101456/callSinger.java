package com.example.a26_giangquochao_ltdnt_21103101456;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class callSinger extends AppCompatActivity {
    TextView sing, song;
    Button btn_goi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_call_singer);
        sing = findViewById(R.id.tv_sing);
        song = findViewById(R.id.tv_song);
        btn_goi = findViewById(R.id.btn_call);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("myBundle");
        sing.setText(bundle.getString("nameSing"));
        song.setText(bundle.getString("nameSong"));

        btn_goi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sdt = "113";
                ActivityCompat.requestPermissions(callSinger.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                Intent intent1 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + sdt));
                startActivity(intent1);
            }
        });
    }

}