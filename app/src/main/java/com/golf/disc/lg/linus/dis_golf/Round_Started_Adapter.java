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
public class Round_Started_Adapter extends ArrayAdapter<Data_Round_Started> {

    ArrayList<Data_Round_Started> data_list = new ArrayList<Data_Round_Started>();
    ArrayList<View> view_list = new ArrayList<View>();

    public Round_Started_Adapter(Context context, List<Data_Round_Started> items) {
        super(context, R.layout.select_course_item_list, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         if(convertView==null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.player_playing_item_list, parent,false);
            view_list.add(convertView);

        }
        Data_Round_Started item = getItem(position);
        TextView tv_name = (TextView)convertView.findViewById(R.id.tv_player_name);
        TextView tv_player_score = (TextView)convertView.findViewById(R.id.tv_player_total_score);

        tv_name.setText(item.player_name);
        tv_player_score.setText(String.valueOf(item.score));
        return convertView;
        }

}
