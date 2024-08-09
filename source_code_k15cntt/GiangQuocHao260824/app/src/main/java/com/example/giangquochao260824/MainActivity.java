package com.example.giangquochao260824;

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

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
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
        if(id == R.id.menu_listmusic){
            Intent intent = new Intent(MainActivity.this, GiangQuocHao_listsinger.class);
            startActivity(intent);
        } else if(id == R.id.menu_album){
            Toast.makeText(MainActivity.this, "Chức năng chưa được cập nhật !", Toast.LENGTH_SHORT).show();
        } else if(id == R.id.menu_singer){
            Toast.makeText(MainActivity.this, "Chức năng chưa được cập nhật !", Toast.LENGTH_SHORT).show();
        } else if(id == R.id.menu_exit){
            System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }
}