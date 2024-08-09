package com.example.giangquochao_572024;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edt_fullname, edt_cmnd, edt_addNew;
    RadioGroup radioGroup;
    RadioButton rd1, rd2, rd3;
    CheckBox checkBox1, checkBox2, checkBox3;
    Button btn_send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edt_fullname = findViewById(R.id.edt_hoten);
        edt_cmnd = findViewById(R.id.edt_cmnd);
        edt_addNew = findViewById(R.id.edt_addNew);
        radioGroup = findViewById(R.id.radioGroup);
        rd1 = findViewById(R.id.radioButton1);
        rd2 = findViewById(R.id.radioButton2);
        rd3 = findViewById(R.id.radioButton3);
        checkBox1 = findViewById(R.id.checkBox4);
        checkBox2 = findViewById(R.id.checkBox5);
        checkBox3 = findViewById(R.id.checkBox6);
        btn_send = findViewById(R.id.btn_send);
        // code
        try{
            btn_send.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String fullname = edt_fullname.getText().toString();
                    String cmnd = edt_cmnd.getText().toString();
                    String tt = edt_addNew.getText().toString();
                    String sothich = "";
                    if(checkBox1.isChecked()){
                        sothich = sothich + checkBox1.getText().toString();
                    } else if(checkBox2.isChecked()){
                        sothich = sothich + checkBox2.getText().toString();;
                    } else if(checkBox3.isChecked()){
                        sothich = sothich + checkBox3.getText().toString();;
                    }
                    String bangcap = null;
                    RadioGroup radioGroup = findViewById(R.id.radioGroup);

                    int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();

                    if (selectedRadioButtonId != -1) {
                        RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                        bangcap = selectedRadioButton.getText().toString();
                    }

                    if(fullname.equals("")){
                        Toast.makeText(MainActivity.this, "Vui lòng nhập họ tên !", Toast.LENGTH_SHORT).show();
                    } else if(cmnd.equals("")){
                        Toast.makeText(MainActivity.this, "Vui lòng nhập cmnd !", Toast.LENGTH_SHORT).show();
                    } else if(bangcap.equals("")){
                        Toast.makeText(MainActivity.this, "Vui lòng chọn bằng cấp !", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(MainActivity.this, GiangQuocHao_572024.class);
                        Bundle myBundle = new Bundle();
                        myBundle.putString("name", fullname);
                        myBundle.putString("cmnd", cmnd);
                        myBundle.putString("bangcap", bangcap);
                        myBundle.putString("sothich", sothich);
                        myBundle.putString("tt", tt);
                        intent.putExtra("myBundleSum", myBundle);
                        startActivity(intent);
                    }
                }

            });
        }catch (Exception ex){
            ex.getLocalizedMessage();
        }
    }
}