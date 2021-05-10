package com.example.design1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Cart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
    }

    public void onHome(View view) {
        Intent mainActivity = new Intent(this, MainActivity.class);
        startActivity(mainActivity);
    }

    public void onFirst(View view){
        Intent optionFirst = new Intent(this, OptionFirst.class);
        startActivity(optionFirst);
    }


    public void onSecond(View view){
        Intent optionSecond = new Intent(this, OptionSecond.class);
        startActivity(optionSecond);
    }
    public void onThird(View view){
        Intent optionThird = new Intent(this, OptionThird.class);
        startActivity(optionThird);
    }
}