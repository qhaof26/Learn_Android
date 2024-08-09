package com.example.a26_giangquochao_ltdnt_21103101456;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class MainActivity extends AppCompatActivity {
    Toolbar menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        menu = findViewById(R.id.menu_toolbar);
        setSupportActionBar(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int option = item.getItemId();
        if(option == R.id.op1 || option == R.id.op3){
            Toast.makeText(MainActivity.this, "Chuc nang chua duoc cap nhat !", Toast.LENGTH_SHORT).show();
        } else if(option == R.id.op2){
            Intent intent = new Intent(MainActivity.this, ListViewCRUD.class);
            startActivity(intent);
        } else if(option == R.id.op4){
            System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }
}