package com.golf.disc.lg.linus.dis_golf;

import android.app.Fragment;
import android.app.ListFragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class Fragment_Select_Player extends ListFragment {


    TextView total_player_number;
    View main_view;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        // First parameter, layout, second field

        init();
        ArrayList<String> values = new ArrayList<String>();
        values.add("Linus");
        values.add("Fredrik");
        values.add("Sebbe");
        values.add("Kevin");
        values.add("David");
        values.add("Niklas");

        Select_Player_Adapter adapter = new Select_Player_Adapter(getActivity(), values);
        setListAdapter(adapter);
        main_view = inflater.inflate(R.layout.activity_fragment__select__player,container, false);
        total_player_number = (TextView)main_view.findViewById(R.id.tv_total_players_number);
        total_player_number.setText("1");
        return main_view;
    }

    public void init(){
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Select_Player_Adapter adapter = (Select_Player_Adapter)getListAdapter();
        CheckBox cb_item =(CheckBox) v.findViewById(R.id.cb_player_select);
        cb_item.toggle();
        int players = 0;

        for(int i = 0; i < adapter.getCount();i++){
                cb_item = (CheckBox)adapter.view_list.get(i).findViewById(R.id.cb_player_select);
                if(cb_item.isChecked()){
                    players++;}

            total_player_number.setText(String.valueOf(players));
        }
    }

    /**
     * Method returning the list of playing players
     * @return list of playing players
     */
    public ArrayList<String> get_active_players_list(){
        Select_Player_Adapter adapter = (Select_Player_Adapter)getListAdapter();
        ArrayList<String> players = new ArrayList<String>();
        CheckBox cb_item;

        for(int i = 0; i < adapter.getCount()-1;i++){
            cb_item = (CheckBox)adapter.view_list.get(i).findViewById(R.id.cb_player_select);
            if(cb_item.isChecked()){
                    players.add(((TextView)adapter.view_list.get(i).findViewById(R.id.tv_player_name))
                            .getText().toString());
                }
        }
        return players;
    }

}
