package com.example.intent_giangquochao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class InputActivity extends AppCompatActivity {
    EditText input1, input2;
    Button btnSum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_input);
        input1 = findViewById(R.id.edt_input1);
        input2 = findViewById(R.id.edt_input2);
        btnSum = findViewById(R.id.btn_result);
        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(input1.getText().toString());
                int b = Integer.parseInt(input2.getText().toString());
                Intent intent = new Intent(InputActivity.this, OutputActivity.class);
                Bundle myBundle = new Bundle();
                myBundle.putInt("a", a);
                myBundle.putInt("b", b);
                intent.putExtra("myBundleSum", myBundle);
                startActivity(intent);
            }
        });
    }
}