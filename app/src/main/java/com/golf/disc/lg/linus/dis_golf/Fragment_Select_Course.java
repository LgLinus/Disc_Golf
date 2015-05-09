package com.golf.disc.lg.linus.dis_golf;

import android.app.Fragment;
import android.app.ListFragment;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Fragment_Select_Course extends ListFragment {

    TextView course_choice;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        // First parameter, layout, second field

        /* Create our courses */
        ArrayList<Data_Select_Course> values = new ArrayList<Data_Select_Course>();
        values.add(new Data_Select_Course("Bulltofta","18"));
        values.add(new Data_Select_Course("Sibbarp", "9"));
        values.add(new Data_Select_Course("Lund","18"));
        values.add(new Data_Select_Course("Test","9"));
        values.add(new Data_Select_Course("Stockholm","18"));

        // Create an adapter and inflate the layout
        Select_Course_Adapter adapter = new Select_Course_Adapter(getActivity(), values);
        setListAdapter(adapter);
        View v =inflater.inflate(R.layout.activity_fragment__select__course,container, false);

        course_choice = (TextView)v.findViewById(R.id.tv_course_name_choice);

        return v;

    }

    @Override
    /**
     * Method that handles click on the listview items
     */
    public void onListItemClick(ListView l, View v, int position, long id) {
        Data_Select_Course item = (Data_Select_Course)getListView().getItemAtPosition(position);
        course_choice.setText(item.course_name);
    }

    public String get_active_course_name(){
        return course_choice.getText().toString();
    }
}
