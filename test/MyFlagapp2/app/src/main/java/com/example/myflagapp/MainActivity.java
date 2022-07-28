package com.example.myflagapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/*
    Main → Main
         → Menu → Main
                 → Sub01 → Main
                          → Menu

    1. FLAG_ACTIVITY_SINGLE_TOP
        이전 액티비티와 동일한 액티비티를 띄운다고 해서 이전액티비에 있던 데이터를 그대로 사용하는게 아님
        이전 액티비티를 띄울 때 새로운 액티비티를 호출하는게 아닌 이전 액티비티를 재 호출(onCreate() 메소드 호출 x) → onNewIntent()
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button toMainButton = findViewById(R.id.main_button_to_main);
        toMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        Button toMenuButton = findViewById(R.id.main_button_to_menu);
        toMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
            }
        });
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Toast.makeText(this,"onNewIntent",Toast.LENGTH_SHORT).show();
    }
}