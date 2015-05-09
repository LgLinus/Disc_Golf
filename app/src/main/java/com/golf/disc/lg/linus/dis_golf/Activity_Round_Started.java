package com.golf.disc.lg.linus.dis_golf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class Activity_Round_Started extends Activity {

    private Button btn_next, btn_previous;
    private Intent i;
    private ArrayList<Data_Round_Started> players;
    private ListView lv;
    private int hole;
    String course_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round_started);

        i = getIntent();

        course_name = i.getStringExtra(Constants.COURSE_NAME);
        hole = i.getIntExtra(Constants.CURRENT_HOLE,1);
        Toast.makeText(getApplicationContext(),course_name,Toast.LENGTH_SHORT).show();
        TextView tv_title = (TextView)findViewById(R.id.tv_course_title);
        TextView tv_hole_number = (TextView)findViewById(R.id.tv_hole_number);

        tv_hole_number.setText("#"+hole);
        tv_title.setText(course_name);


        init();
        setListeners();
    }

    private void init(){
        lv = (ListView)findViewById(R.id.lv_round_started);
        btn_next = (Button)findViewById(R.id.btn_next);
        btn_previous = (Button)findViewById(R.id.btn_back);
        create_players();
    }

    private void create_players(){
        players = new ArrayList<Data_Round_Started>();
        boolean empty = false;

        Log.d("Activity round started","before while");
        int j=0;
        while(!empty){

            Log.d("Activity round started","inside while");
            String temp = i.getStringExtra(Constants.PLAYER_NAME+String.valueOf(j));
            if(temp==null)
                empty = true;
            else{
                int player_score = i.getIntExtra(Constants.PLAYER_SCORE+String.valueOf(j),0);
                Log.d("Activity round started","inside else");
                players.add(new Data_Round_Started(temp,player_score));
                Toast.makeText(getApplicationContext(),temp,Toast.LENGTH_SHORT).show();

                Log.d("Activity round started","inside else after toast");
            }
            j++;
        }
        Round_Started_Adapter adapter = new Round_Started_Adapter(this,players);
        lv.setAdapter(adapter);

    }

    private void setListeners(){

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                EditText et_score = (EditText) view.findViewById(R.id.et_player_score);
                et_score.requestFocus();
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                goNext();
            }
        });
    }

    public void goNext(){
        Intent next = new Intent(getApplicationContext(),Activity_Round_Started.class);

        for(int i = 0; i < players.size();i++){
            EditText et = (EditText)((Round_Started_Adapter)lv.getAdapter()).view_list.get(i).findViewById(R.id.et_player_score);
            TextView tv = (TextView)((Round_Started_Adapter)lv.getAdapter()).view_list.get(i).findViewById(R.id.tv_player_total_score);
            players.get(i).score=Integer.parseInt(tv.getText().toString())+Integer.parseInt(et.getText().toString());
            Log.d("player score",players.get(i).score+":"+et.getText().toString());
        }
        for(int i = 0; i < players.size();i++){
            next.putExtra(Constants.COURSE_NAME,course_name);
            next.putExtra(Constants.PLAYER_NAME+String.valueOf(i),players.get(i).player_name);
            next.putExtra(Constants.PLAYER_SCORE+String.valueOf(i),players.get(i).score);
            next.putExtra(Constants.CURRENT_HOLE,hole+1);
        }
        startActivity(next);
    }
}

