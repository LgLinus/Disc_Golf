package com.golf.disc.lg.linus.dis_golf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Linus on 2015-05-05.
 */
public class Select_Course_Adapter extends ArrayAdapter<Data_Select_Course> {

    ArrayList<Data_Select_Course> data_list = new ArrayList<Data_Select_Course>();

    public Select_Course_Adapter(Context context, List<Data_Select_Course> items) {
        super(context, R.layout.select_course_item_list, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         if(convertView==null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.select_course_item_list, parent,false);


        }
        Data_Select_Course item = getItem(position);
        TextView tv_name = (TextView)convertView.findViewById(R.id.tv_course_name);
        TextView tv_holes = (TextView)convertView.findViewById(R.id.tv_course_holes);

        tv_name.setText(item.course_name);
        tv_holes.setText(item.course_holes);
        return convertView;
        }

}
