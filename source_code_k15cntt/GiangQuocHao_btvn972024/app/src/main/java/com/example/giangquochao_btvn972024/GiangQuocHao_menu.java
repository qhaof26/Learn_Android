package com.example.giangquochao_btvn972024;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class GiangQuocHao_menu extends AppCompatActivity {
    Toolbar toolbar;
    public static String userName;
    public static String passWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_giang_quoc_hao_menu);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        Bundle myBundle = intent.getBundleExtra("myBundle");
        String username = myBundle.getString("username");
        String password = myBundle.getString("password");
        userName = username;
        passWord = password;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.menu_sendmessage){
            Intent intent1 = new Intent(GiangQuocHao_menu.this, GiangQuocHao_message.class);
            startActivity(intent1);
        } else if(id == R.id.menu_json){
            Bundle bundle1 = new Bundle();
            bundle1.putString("username", userName);
            bundle1.putString("password", passWord);
            Intent intent2 = new Intent(GiangQuocHao_menu.this, GiangQuocHao_JSON.class);
            intent2.putExtra("myBundleJSON", bundle1);
            startActivity(intent2);
        } else if(id == R.id.menu_exit){
            Intent intent3 = new Intent(GiangQuocHao_menu.this, GiangQuocHao_dangnhap.class);
            startActivity(intent3);
        }
        return super.onOptionsItemSelected(item);
    }
}