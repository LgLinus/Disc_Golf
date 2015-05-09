package com.golf.disc.lg.linus.dis_golf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Linus on 2015-05-05.
 */
public class Select_Player_Adapter extends ArrayAdapter<String> {

    ArrayList<String> data_list = new ArrayList<String>();
    ArrayList<View> view_list = new ArrayList<View>();

    public Select_Player_Adapter(Context context, List<String> items) {
        super(context, R.layout.select_course_item_list, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

         if(convertView==null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.select_player_item_list, parent,false);
            view_list.add(convertView);
        }
        String item = getItem(position);
        TextView tv_name = (TextView)convertView.findViewById(R.id.tv_player_name);

        tv_name.setText(item);
        return convertView;
        }

}
