package com.example.mikhail.game2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Section1_select extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section1_select);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
        b5=(Button)findViewById(R.id.b5);
        b6=(Button)findViewById(R.id.b6);
        b7=(Button)findViewById(R.id.b7);
        b8=(Button)findViewById(R.id.b8);
        b9=(Button)findViewById(R.id.b9);
        b10=(Button)findViewById(R.id.b10);
        b11=(Button)findViewById(R.id.b11);
        b12=(Button)findViewById(R.id.b12);
        b13=(Button)findViewById(R.id.b13);
        b14=(Button)findViewById(R.id.b14);
        b15=(Button)findViewById(R.id.b15);
        b16=(Button)findViewById(R.id.b16);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b1:
                Intent goLvL = new Intent(Section1_select.this, CreatorLvls.class);
                CreatorLvls.i=0;
                startActivity(goLvL);
                break;
            case R.id.b2:
                goLvL = new Intent(Section1_select.this, CreatorLvls.class);
                CreatorLvls.i=1;
                startActivity(goLvL);
                break;
            case R.id.b3:
                goLvL = new Intent(Section1_select.this, CreatorLvls.class);
                CreatorLvls.i=2;
                startActivity(goLvL);
                break;
            case R.id.b4:
                goLvL = new Intent(Section1_select.this, CreatorLvls.class);
                CreatorLvls.i=3;
                startActivity(goLvL);
                break;
            case R.id.b5:
                goLvL = new Intent(Section1_select.this, CreatorLvls.class);
                CreatorLvls.i=4;
                startActivity(goLvL);
                break;
            case R.id.b6:
                goLvL = new Intent(Section1_select.this, CreatorLvls.class);
                CreatorLvls.i=5;
                startActivity(goLvL);
                break;
            case R.id.b7:
                goLvL = new Intent(Section1_select.this, CreatorLvls.class);
                CreatorLvls.i=6;
                startActivity(goLvL);
                break;
            case R.id.b8:
                goLvL = new Intent(Section1_select.this, CreatorLvls.class);
                CreatorLvls.i=7;
                startActivity(goLvL);
                break;
            case R.id.b9:
                goLvL = new Intent(Section1_select.this, CreatorLvls.class);
                CreatorLvls.i=8;
                startActivity(goLvL);
                break;
            case R.id.b10:
                goLvL = new Intent(Section1_select.this, CreatorLvls.class);
                CreatorLvls.i=9;
                startActivity(goLvL);
                break;
            case R.id.b11:
                goLvL = new Intent(Section1_select.this, CreatorLvls.class);
                CreatorLvls.i=10;
                startActivity(goLvL);
                break;
            case R.id.b12:
                goLvL = new Intent(Section1_select.this, CreatorLvls.class);
                CreatorLvls.i=11;
                startActivity(goLvL);
                break;
            case R.id.b13:
                goLvL = new Intent(Section1_select.this, CreatorLvls.class);
                CreatorLvls.i=12;
                startActivity(goLvL);
                break;
            case R.id.b14:
                goLvL = new Intent(Section1_select.this, CreatorLvls.class);
                CreatorLvls.i=13;
                startActivity(goLvL);
                break;
            case R.id.b15:
                goLvL = new Intent(Section1_select.this, CreatorLvls.class);
                CreatorLvls.i=14;
                startActivity(goLvL);
                break;
            case R.id.b16:
                goLvL = new Intent(Section1_select.this, CreatorLvls.class);
                CreatorLvls.i=15;
                startActivity(goLvL);
                break;
            case R.id.b_menu:
                finish();
                break;
        }
    }
}
