package com.example.btvn01_giangquochao;
import android.content.DialogInterface;
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
public class GiangquochaoActivity extends AppCompatActivity{
    EditText edt_fullname, edt_cmnd, edt_addNew;
    RadioGroup radioGroup;
    RadioButton rd1, rd2, rd3;
    CheckBox checkBox1, checkBox2, checkBox3;
    Button btn_send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.giangquochao);
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
                    StringBuilder sothich = new StringBuilder();
                    if(checkBox1.isChecked()){
                        sothich.append(checkBox1.getText().toString()).append(" - ");
                    } else if(checkBox2.isChecked()){
                        sothich.append(checkBox2.getText().toString()).append(" - ");
                    } else if(checkBox3.isChecked()){
                        sothich.append(checkBox3.getText().toString()).append(" - ");
                    }
                    String bangcap = null;
                    RadioGroup radioGroup = findViewById(R.id.radioGroup);

                    int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();

                    if (selectedRadioButtonId != -1) {
                        RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                        bangcap = selectedRadioButton.getText().toString();
                    }

                    if(fullname.equals("") || cmnd.equals("") || bangcap.equals("")){
                        Toast.makeText(GiangquochaoActivity.this, "Vui lòng nhập đủ thông tin !", Toast.LENGTH_SHORT).show();
                    } else {
                        AlertDialog.Builder dialog = new AlertDialog.Builder(GiangquochaoActivity.this);
                        //2.2 Tao tieu de cho dialog
                        dialog.setTitle("THÔNG TIN CÁ NHÂN");
                        //2.3 Hien thi noi dung cua dialog
                        dialog.setMessage("Họ tên: " + fullname + "\nCMND: " + cmnd + "\nBằng cấp: " + bangcap
                                + "\nSở thích: " + sothich
                                + "\n---Thông tin bổ sung---" + "\n" + tt + "\n-------------------");
                        //2.4 Tao nut dong
                        dialog.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                        dialog.create().show();
                    }
                }
            });
        }catch (Exception ex){
            ex.getLocalizedMessage();
        }
    }
}
