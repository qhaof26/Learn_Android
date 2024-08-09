package com.example.giangquochao_customlistview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<Phone> {
    Activity context;
    int idlayout;
    ArrayList<Phone> mylist;

    public MyArrayAdapter(Activity context, int idlayout, ArrayList<Phone> mylist) {
        super(context, idlayout, mylist);
        this.context = context;
        this.idlayout = idlayout;
        this.mylist = mylist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater myInflactor = context.getLayoutInflater();
        convertView = myInflactor.inflate(idlayout,null);
        Phone myphone = mylist.get(position);
        ImageView imgphone = convertView.findViewById(R.id.imgPhone);
        imgphone.setImageResource(myphone.getIdImagePhone());
        TextView txtnamephone = convertView.findViewById(R.id.txtNamePhone);
        txtnamephone.setText(myphone.getNamePhone());
        return convertView;
    }
}
