package com.example.mikhail.game2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class CreatorLvls extends AppCompatActivity {

    private TextView view_levels;
    private TextView view_coins;
    public static ImageView imageView;

    public static int help = 0;
    public static int i=0;

    public static final String T2T_mbd = "1mbd1";
    public static final String T2T_mbd_lvl = "1lvl1";
    public static final String T2T_mbd_tryc = "1tryc1";
    public static final String T2T_mbd_help = "1help1";
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

        b_back = (Button)findViewById(R.id.b_back);
        vvod = (EditText)findViewById(R.id.vvod);
        b_next = (Button)findViewById(R.id.b_next);

        if (i==DataBase.section1.length) {
            Toast.makeText(this, "Вы прошли всю компанию", Toast.LENGTH_SHORT).show();
            Intent goMenu = new Intent(CreatorLvls.this, MainActivity.class);
            startActivity(goMenu);
        }
        if (DataBase.section1[i].status==1){vvod.setKeyListener(null); vvod.setGravity(Gravity.CENTER); vvod.setText(DataBase.section1[i].answer); b_next.setVisibility(View.INVISIBLE);}
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = mbd.edit();
        editor.putInt(T2T_mbd_lvl, i);
        editor.putInt(T2T_mbd_tryc, tryC);
        editor.putInt(T2T_mbd_help, help);
        editor.apply();
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
            //i = mbd.getInt(T2T_mbd_lvl, 0);
            tryC = mbd.getInt(T2T_mbd_tryc, 0);
            help = mbd.getInt(T2T_mbd_help, 0);
        }
        if (i==DataBase.section1.length) {
            Toast.makeText(this, "Вы прошли всю компанию", Toast.LENGTH_SHORT).show();
            Intent goMenu = new Intent(CreatorLvls.this, MainActivity.class);
            startActivity(goMenu);
        }
        if (i!=DataBase.section1.length) {imageView.setImageResource((DataBase.section1[i]).image);}
    }

    public void win(){
        if (((DataBase.section1[i]).ch)==1){MainActivity.levels_ch1 +=1;}
        if (((DataBase.section1[i]).ch)==2){MainActivity.levels_ch2 +=1;}
        if (((DataBase.section1[i]).ch)==3){MainActivity.levels_ch3 +=1;}
        if (DataBase.section1[i].tryc==0){
            MainActivity.coins += 50;
            Toast.makeText(this, "Правильно! +50 монет!", Toast.LENGTH_SHORT).show();}
        if (DataBase.section1[i].tryc==1){
            MainActivity.coins += 25;
            Toast.makeText(this, "Правильно! +25 монет!", Toast.LENGTH_SHORT).show();}
        if (DataBase.section1[i].tryc>1){
            MainActivity.coins += 10;
            Toast.makeText(this, "Правильно! +10 монет!", Toast.LENGTH_SHORT).show();}
        DataBase.section1[i].status=1;
        DataBase.section1[i].tryc=0;
        help=0;
        //DataBase.templvl[i].status=1;
        MainActivity.savesettings();
        MainActivity.loadsettings();
        i++;
        view_coins.setText(Integer.toString(MainActivity.coins));
        view_levels.setText(Integer.toString(MainActivity.levels_summ));
        if (i==DataBase.section1.length) {
            Toast.makeText(this, "Поздравляем! Вы прошли всю компанию!", Toast.LENGTH_SHORT).show();
            Intent goMenu = new Intent(CreatorLvls.this, MainActivity.class);
            startActivity(goMenu);
        } else{ imageView.setImageResource((DataBase.section1[i]).image);}
        vvod.setText("");
        if (DataBase.section1[i].status==1){vvod.setKeyListener(null); vvod.setGravity(Gravity.CENTER); vvod.setText(DataBase.section1[i].answer); b_next.setVisibility(View.INVISIBLE);}
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.b_next:
                if (DataBase.section1[i].status==1){Toast.makeText(this, "Вы проходили этот уровень", Toast.LENGTH_SHORT).show(); this.finish();}else
                if (Arrays.asList((DataBase.section1[i]).answer).contains(vvod.getText().toString().replaceAll(" ", "").toLowerCase())) {
                    win();
                }else if (vvod.getText().length() == 0) {
                    Toast.makeText(this, "Введи ответ!", Toast.LENGTH_SHORT).show();
                } else {
                    DataBase.section1[i].tryc+=1;
                    Toast.makeText(this, "Неправильно! Подумай еще!", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.b_menu:
                //Intent goMenu = new Intent(Section1.this, MainActivity.class);
                //startActivity(goMenu);
                super.onStop();
                onStop();
                finish();
                break;
            case R.id.b_help:
                if (DataBase.section1[i].status==1){Toast.makeText(this, "Вы проходили этот уровень", Toast.LENGTH_SHORT).show();}else
                if (help > 3){Toast.makeText(this, (DataBase.section1[i]).answer, Toast.LENGTH_SHORT).show();}
                else if (help == 3){
                    if (MainActivity.coins - 100 <0){Toast.makeText(this, "Недостаточно монет!", Toast.LENGTH_SHORT).show();
                    } else {MainActivity.coins -= 100; Toast.makeText(this, (DataBase.section1[i]).answer, Toast.LENGTH_SHORT).show(); help+=1; DataBase.section1[i].tryc+=1;view_coins.setText(Integer.toString(MainActivity.coins));}}
                else if (help == 2){Toast.makeText(this, "Ответ на загадку стоит 100 монет! Нажми еще раз, чтобы купить", Toast.LENGTH_SHORT).show(); help+=1;}
                else if (help == 1){
                    if (MainActivity.coins - 10 <0){ Toast.makeText(this, "Недостаточно монет!", Toast.LENGTH_SHORT).show();
                    } else { MainActivity.coins -= 10; Toast.makeText(this, (DataBase.section1[i]).help, Toast.LENGTH_SHORT).show(); help+=1; DataBase.section1[i].tryc+=1;view_coins.setText(Integer.toString(MainActivity.coins));}}
                else if (help == 0){Toast.makeText(this, "1ая подсказка стоит 10монет! Нажми еще раз, чтобы купить", Toast.LENGTH_SHORT).show(); help+=1;}
                MainActivity.savesettings();onPause();
                break;
        }
    }
}
