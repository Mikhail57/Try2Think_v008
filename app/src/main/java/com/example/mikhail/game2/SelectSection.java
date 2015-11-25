package com.example.mikhail.game2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SelectSection extends AppCompatActivity {



    private TextView view_levels;
    private TextView view_coins;
    private Button section_1;
    private Button section_2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_ch1);
        view_levels = (TextView)findViewById(R.id.levels);
        view_coins = (TextView)findViewById(R.id.coins);
        section_1 = (Button)findViewById(R.id.section1);
        section_2 = (Button)findViewById(R.id.section2);
        if (Section1.i>0) {
            Section1.i = Section1.mbd.getInt(Section1.T2T_mbd_lvl, 0);}
        section_1.setText("Секция 1"+" | Пройдено "+Integer.toString(MainActivity.levels_ch1));
        section_2.setText("Новый год"+" | Пройдено "+Integer.toString(MainActivity.levels_ch2));
        view_coins.setText(Integer.toString(MainActivity.coins));
        view_levels.setText(Integer.toString(MainActivity.levels_ch1 + MainActivity.levels_ch2 + MainActivity.levels_ch3));
    }
    @Override
    protected void onResume() {
        super.onResume();
        if (Section1.i>0) {
            Section1.i = Section1.mbd.getInt(Section1.T2T_mbd_lvl, 0);}
        section_1.setText("Секция 1"+" | Пройдено "+Integer.toString(MainActivity.levels_ch1));
        section_2.setText("Новый год" + " | Пройдено " + Integer.toString(MainActivity.levels_ch2));
        view_coins.setText(Integer.toString(MainActivity.coins));
        view_levels.setText(Integer.toString(MainActivity.levels_ch1 + MainActivity.levels_ch2 + MainActivity.levels_ch3));
    }
    @Override
    protected void onPause() {
        super.onPause();
        section_1.setText("Секция 1"+" | Пройдено "+Integer.toString(MainActivity.levels_ch1));
        section_2.setText("Новый год" + " | Пройдено " + Integer.toString(MainActivity.levels_ch2));
        view_coins.setText(Integer.toString(MainActivity.coins));
        view_levels.setText(Integer.toString(MainActivity.levels_ch1 + MainActivity.levels_ch2 + MainActivity.levels_ch3));
    }

    public void onClick(View v){
        switch (v.getId()) {
            case R.id.b_menu:
                Intent goMenu = new Intent(SelectSection.this, MainActivity.class);
                startActivity(goMenu);
                break;
            case R.id.section1:
                Intent goSec1 = new Intent(SelectSection.this, Section1_select.class);
                startActivity(goSec1);
                break;
            case R.id.section2:
                Intent goSec2 = new Intent(SelectSection.this, Section2.class);
                startActivity(goSec2);
                break;
        }
    }

}
