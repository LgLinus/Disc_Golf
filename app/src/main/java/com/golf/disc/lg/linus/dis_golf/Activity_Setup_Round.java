package com.golf.disc.lg.linus.dis_golf;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;


public class Activity_Setup_Round extends Activity {

    private FragmentManager fm;
    private Fragment_Select_Course fragment_select_course;
    private Fragment_Select_Player fragment_select_player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_round);

        fm = this.getFragmentManager();
        fragment_select_course = (Fragment_Select_Course)fm.findFragmentById(R.id.fragment_select_course);
        fragment_select_player = (Fragment_Select_Player)fm.findFragmentById(R.id.fragment_select_player);
        View next_back = findViewById(R.id.layout_back_next);

        Button btn_back = (Button)next_back.findViewById(R.id.btn_back);
        Button btn_next = (Button)next_back.findViewById(R.id.btn_next);

        btn_back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
               onBackPressed();
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                start_round();
            }
        });
    }

    /**
     * Start the round
     */
public void start_round(){
    Intent i = new Intent(getApplicationContext(),Activity_Round_Started.class);
    i.putExtra(Constants.COURSE_NAME,fragment_select_course.get_active_course_name());
    // Retrieve player list
    ArrayList<String> players;
    players = fragment_select_player.get_active_players_list();

    send_players(i,players);

    startActivity(i);
}

    private void send_players(Intent i, ArrayList<String> players){
        for(int j = 0; j < players.size();j++){
            i.putExtra(Constants.PLAYER_NAME+String.valueOf(j),players.get(j));
            Log.d("namn",players.get(j));
        }
        Log.d("out","out");
    }
}
