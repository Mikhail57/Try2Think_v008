package com.example.mikhail.game2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class Section2 extends AppCompatActivity {

    private TextView view_levels;
    private TextView view_coins;
    private ImageView imageView;

    public static int help = 0;
    public static int i=0;

    public static final String T2T_mbd = "mbd2";
    public static final String T2T_mbd_lvl = "lvl2";
    public static final String T2T_mbd_tryc = "tryc2";
    public static final String T2T_mbd_help = "help2";
    public static SharedPreferences mbd;

    /*
        public static String base[][] = new String[][]{
                {"подумай", "1"}, {"михаил", "1"},{"пирожок", "1"},{"4+5=9", "2"}
        };
        public static int baseDRAW[]=new int[]
                {R.drawable.lvl1 , R.drawable.lvl2 , R.drawable.lvl3, R.drawable.ch2_lvl1};
    */
    private Button b_back;
    private static EditText vvod;
    private Button b_next;

    private static int tryC=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_company);

        mbd = getSharedPreferences(T2T_mbd, Context.MODE_PRIVATE);

        imageView = (ImageView)findViewById(R.id.imageView);
        view_levels = (TextView)findViewById(R.id.levels);
        view_coins = (TextView)findViewById(R.id.coins);
        view_coins.setText(Integer.toString(MainActivity.coins));
        view_levels.setText(Integer.toString(MainActivity.levels_summ));

        b_back = (Button)findViewById(R.id.b_menu);
        vvod = (EditText)findViewById(R.id.vvod);
        b_next = (Button)findViewById(R.id.b_next);

        if (i==DataBase.section2.length) {
            Toast.makeText(this, "Вы прошли всю компанию", Toast.LENGTH_SHORT).show();
            Intent goMenu = new Intent(Section2.this, MainActivity.class);
            startActivity(goMenu);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = mbd.edit();
        editor.putInt(T2T_mbd_lvl, i);
        editor.putInt(T2T_mbd_tryc, tryC);
        editor.putInt(T2T_mbd_help, help);
        editor.apply();
        finish();
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return true;
        }
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mbd.contains(T2T_mbd_lvl) ||
                mbd.contains(T2T_mbd_tryc) ||
                mbd.contains(T2T_mbd_help)) {
            i = mbd.getInt(T2T_mbd_lvl, 0);
            tryC = mbd.getInt(T2T_mbd_tryc, 0);
            help = mbd.getInt(T2T_mbd_help, 0);
        }
        if (i==DataBase.section2.length) {
            Toast.makeText(this, "Вы прошли всю компанию", Toast.LENGTH_SHORT).show();
            Intent goMenu = new Intent(Section2.this, MainActivity.class);
            startActivity(goMenu);
        }
        if (i!=DataBase.section2.length) {imageView.setImageResource((DataBase.section2[i]).image);}
    }

    public void win(){
        if (((DataBase.section2[i]).chapter)==1){MainActivity.levels_ch1 +=1;}
        if (((DataBase.section2[i]).chapter)==2){MainActivity.levels_ch2 +=1;}
        if (((DataBase.section2[i]).chapter)==3){MainActivity.levels_ch3 +=1;}
        if (tryC==0){
            MainActivity.coins += 50;
            Toast.makeText(this, "Правильно! +50 монет!", Toast.LENGTH_SHORT).show();}
        if (tryC==1){
            MainActivity.coins += 25;
            Toast.makeText(this, "Правильно! +25 монет!", Toast.LENGTH_SHORT).show();}
        if (tryC>1){
            MainActivity.coins += 10;
            Toast.makeText(this, "Правильно! +10 монет!", Toast.LENGTH_SHORT).show();}

        tryC=0;
        help=0;
        //DataBase.templvl[i].status=1;
        MainActivity.saveSettings();
        MainActivity.loadSettings();
        i++;
        view_coins.setText(Integer.toString(MainActivity.coins));
        view_levels.setText(Integer.toString(MainActivity.levels_summ));
        if (i==DataBase.section2.length) {
            Toast.makeText(this, "Поздравляем! Вы прошли всю компанию!", Toast.LENGTH_SHORT).show();
            Intent goMenu = new Intent(Section2.this, MainActivity.class);
            startActivity(goMenu);
        } else{ imageView.setImageResource((DataBase.section2[i]).image);}
        vvod.setText("");
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.b_next:

                if (Arrays.asList((DataBase.section2[i]).answer).contains(vvod.getText().toString().replaceAll("й", "и").replaceAll("ё", "е").replaceAll(" ", "").toLowerCase())) {
                    win();
                }else if (vvod.getText().length() == 0) {
                    Toast.makeText(this, "Введи ответ!", Toast.LENGTH_SHORT).show();
                } else {
                    tryC+=1;
                    Toast.makeText(this, "Неправильно! Подумай еще!", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.b_menu:
                //Intent goMenu = new Intent(Section2.this, MainActivity.class);
                //startActivity(goMenu);
                super.onStop();
                onStop();
                finish();
                break;
            case R.id.b_help:
                if (help > 3){Toast.makeText(this, (DataBase.section2[i]).answer, Toast.LENGTH_SHORT).show();}
                else if (help == 3){
                    if (MainActivity.coins - 100 <0){Toast.makeText(this, "Недостаточно монет!", Toast.LENGTH_SHORT).show();
                    } else {MainActivity.coins -= 100; Toast.makeText(this, (DataBase.section2[i]).answer, Toast.LENGTH_SHORT).show(); help+=1; tryC+=1;view_coins.setText(Integer.toString(MainActivity.coins));}}
                else if (help == 2){Toast.makeText(this, "Ответ на загадку стоит 100 монет! Нажми еще раз, чтобы купить", Toast.LENGTH_SHORT).show(); help+=1;}
                else if (help == 1){
                    if (MainActivity.coins - 10 <0){ Toast.makeText(this, "Недостаточно монет!", Toast.LENGTH_SHORT).show();
                    } else { MainActivity.coins -= 10; Toast.makeText(this, (DataBase.section2[i]).help, Toast.LENGTH_SHORT).show(); help+=1; tryC+=1;view_coins.setText(Integer.toString(MainActivity.coins));}}
                else if (help == 0){Toast.makeText(this, "1ая подсказка стоит 10монет! Нажми еще раз, чтобы купить", Toast.LENGTH_SHORT).show(); help+=1;}
                MainActivity.saveSettings();onPause();
                break;
        }
    }
}
