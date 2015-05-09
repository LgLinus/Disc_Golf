package com.golf.disc.lg.linus.dis_golf;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Main_menu extends Activity {

    private Button btn_Start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        init();
        setListeners();
    }

    private void init(){
        btn_Start = (Button)findViewById(R.id.btn_main_round_start);
    }

    private void setListeners(){

        /* Set listener on the button, which goes to seup round activity*/
        btn_Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Activity_Setup_Round.class);
                startActivity(i);
            }
        });
    }

}
