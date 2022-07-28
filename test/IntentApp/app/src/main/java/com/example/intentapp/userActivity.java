package com.example.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.intentapp.Model.User;

public class userActivity extends AppCompatActivity {
    TextView textView;
    String username;
    int userage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        textView = findViewById(R.id.user_text);

        Intent data = getIntent(); //Intent는 안드로이드 시스템이 바로 주지 않으므로 요청

        if(data != null) {
            username = data.getStringExtra("username");
            userage = data.getIntExtra("userage",0);
            User user = data.getParcelableExtra("user");
            textView.setText(username + " : " + userage + " : " + user.toString());
        }
    }
}
