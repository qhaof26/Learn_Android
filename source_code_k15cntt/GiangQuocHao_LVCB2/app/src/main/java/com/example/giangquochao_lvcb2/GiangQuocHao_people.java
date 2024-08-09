package com.example.giangquochao_lvcb2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class GiangQuocHao_people extends AppCompatActivity {
    ListView lv_people;
    EditText edt_ten, edt_id;
    Button btn_them, btn_sua, btn_xoa;
    RadioGroup radioGroup;
    RadioButton rd1, rd2;
    ArrayList<People> listPeople = new ArrayList<>();
    ArrayAdapter arrayAdapter1;
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_giang_quoc_hao_people);
        lv_people = findViewById(R.id.lv_staff);
        edt_ten = findViewById(R.id.editTextText);
        edt_id = findViewById(R.id.editTextText2);
        btn_them = findViewById(R.id.button);
        btn_sua = findViewById(R.id.button2);
        btn_xoa = findViewById(R.id.button3);
        radioGroup = findViewById(R.id.radioGroup);
        rd1 = findViewById(R.id.radioButton1);
        rd2 = findViewById(R.id.radioButton3);
        listPeople.add(new People("01", "Giang Hao", "Nam"));
        listPeople.add(new People("02", "Lam Anh", "Nữ"));
        listPeople.add(new People("03", "Tran Anh", "Nam"));
        listPeople.add(new People("04", "Quang Tu", "Nam"));
        listPeople.add(new People("05", "Kim Huyen", "Nữ"));
        arrayAdapter1 = new ArrayAdapter<>(GiangQuocHao_people.this, android.R.layout.simple_list_item_1, listPeople);
        lv_people.setAdapter(arrayAdapter1);
        lv_people.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                People p = listPeople.get(i);
                index = i;
                edt_id.setText(p.getId());
                edt_ten.setText(p.getFullName());
            }
        });
        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = edt_ten.getText().toString();
                String id = edt_id.getText().toString();
                String sex = null;
                RadioGroup radioGroup = findViewById(R.id.radioGroup);
                int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                if (selectedRadioButtonId != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                    sex = selectedRadioButton.getText().toString();
                }
                listPeople.add(new People(id, ten, sex));
                arrayAdapter1.notifyDataSetChanged();
            }
        });
        btn_sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = edt_ten.getText().toString();
                String id = edt_id.getText().toString();
                String sex = null;
                RadioGroup radioGroup = findViewById(R.id.radioGroup);
                int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                if (selectedRadioButtonId != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                    sex = selectedRadioButton.getText().toString();
                }
                listPeople.set(index, new People(id, ten, sex));
                arrayAdapter1.notifyDataSetChanged();
            }
        });
        btn_xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listPeople.remove(index);
                edt_ten.setText("");
                edt_id.setText("");
                arrayAdapter1.notifyDataSetChanged();
            }
        });
    }
}