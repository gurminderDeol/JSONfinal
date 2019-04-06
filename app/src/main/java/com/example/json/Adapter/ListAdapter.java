package com.example.json.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.json.Model.Student;
import com.example.json.R;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Student> studentArrayList;


    @Override
    public int getCount() {
        return studentArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return studentArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.customlist,parent, false);
        }

        TextView txtSid = convertView.findViewById(R.id.tvId);
        TextView txtSnm = convertView.findViewById(R.id.tvName);
        TextView txtgender = convertView.findViewById(R.id.tvGender);

        Student mEmployee = (Student) getItem(position);

        txtSid.setText(String.valueOf(mEmployee.getSid()));
        txtSnm.setText(mEmployee.getSname());
        txtgender.setText(mEmployee.getGender());




        return convertView;

    }
}
