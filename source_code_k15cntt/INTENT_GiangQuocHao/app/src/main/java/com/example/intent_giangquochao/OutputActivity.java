package com.example.intent_giangquochao;

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

public class OutputActivity extends AppCompatActivity {
    TextView tv_result;
    Button btn_return;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_output);
        btn_return = findViewById(R.id.btn_returnInput);
        tv_result = findViewById(R.id.tv_result);
        // Nhan intent duoc gui tu inputActivity
        Intent getIntent = getIntent();
        // Lay bundle ra khoi Intent
        Bundle myBundle = getIntent.getBundleExtra("myBundleSum");
        // Lay du lieu ra khoi bundle
        int a = myBundle.getInt("a");
        int b = myBundle.getInt("b");
        int sum = a + b;
        tv_result.setText(sum+" Giang Quốc Hào");
        btn_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OutputActivity.this, InputActivity.class);
                startActivity(intent);
            }
        });
    }
}