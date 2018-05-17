package com.example.sengkhunlim.studentmanagement;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentInfoActivity extends BaseAdapter {

    private final Activity context;
    private final ArrayList<String> students;

    class ViewHolder {

        public TextView name;
        public TextView id;
        public TextView sex;

    }

    public StudentInfoActivity(Activity context, ArrayList<String> students) {
        this.context = context;
        this.students = students;
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Object getItem(int i) {
        return students.get( i );
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = convertView;

        // reuse views
        if (rowView == null) {

            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.activity_student_info_activitt, null);

            // configure view holder
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.name = rowView.findViewById(R.id.name);
            viewHolder.id = rowView.findViewById(R.id.id);
            viewHolder.sex = rowView.findViewById(R.id.sex);
            rowView.setTag(viewHolder);

        }

        // fill data
        ViewHolder holder = (ViewHolder) rowView.getTag();
        String[] s = students.get( position ).split(",");

        holder.id.setText(s[0]);
        holder.name.setText(s[1]);
        holder.sex.setText(s[2]);

        return rowView;
    }

}

