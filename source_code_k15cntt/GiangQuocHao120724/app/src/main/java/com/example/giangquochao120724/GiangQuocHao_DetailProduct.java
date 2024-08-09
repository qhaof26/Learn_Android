package com.example.giangquochao120724;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class GiangQuocHao_DetailProduct extends AppCompatActivity {
    EditText masp, tensp, dongia;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_giang_quoc_hao_detail_product);
        masp = findViewById(R.id.edt_masp);
        tensp = findViewById(R.id.edt_tensp);
        dongia = findViewById(R.id.edt_dongia);
        back = findViewById(R.id.btn_back);
        Intent getIntent = getIntent();
        Bundle myBundle = getIntent.getBundleExtra("myBundle");
        String tenmay = myBundle.getString("name");
        if(tenmay.equals("Vertu")){
            masp.setText("sp01");
            tensp.setText(tenmay);
            dongia.setText("100000");
        } else if(tenmay.equals("Iphone 15")){
            masp.setText("sp02");
            tensp.setText(tenmay);
            dongia.setText("2000000");
        } else if(tenmay.equals("Nokia 925")){
            masp.setText("sp03");
            tensp.setText(tenmay);
            dongia.setText("2000000");
        } else if(tenmay.equals("Samsung s24")){
            masp.setText("sp04");
            tensp.setText(tenmay);
            dongia.setText("2000000");
        } else if(tenmay.equals("Vivo")){
            masp.setText("sp05");
            tensp.setText(tenmay);
            dongia.setText("2000000");
        }
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GiangQuocHao_DetailProduct.this, GiangQuocHao_DSSP.class);
                startActivity(intent);
            }
        });
    }
}