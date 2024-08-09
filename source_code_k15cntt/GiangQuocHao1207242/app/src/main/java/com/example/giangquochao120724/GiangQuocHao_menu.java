package com.example.giangquochao120724;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GiangQuocHao_menu extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_giang_quoc_hao_menu);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // lay id cua cac item menu
        int id = item.getItemId();
        // chon item
        if(id == R.id.tb_bill){
            Toast.makeText(GiangQuocHao_menu.this, "Chức năng chưa được cập nhật !", Toast.LENGTH_SHORT).show();
        } else if(id == R.id.tb_lhkh){
            Intent intent = new Intent(GiangQuocHao_menu.this, GiangQuocHao_contacts.class);
            startActivity(intent);
        } else if(id == R.id.tb_cskh){
            Toast.makeText(GiangQuocHao_menu.this, "Chức năng chưa được cập nhật !", Toast.LENGTH_SHORT).show();
        } else if(id == R.id.tb_exit){
            System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }
}