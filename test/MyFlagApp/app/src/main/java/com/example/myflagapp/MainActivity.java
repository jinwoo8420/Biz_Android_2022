package com.example.myflagapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/*
    Main -> Main
         -> Menu -> Main
                 -> Sub01 -> Main
                          -> Menu






 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
