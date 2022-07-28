package com.example.myexampleapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView topImageView, bottomImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topImageView = findViewById(R.id.main_image_top);
        bottomImageView = findViewById(R.id.main_image_bottom);
    }

    public void onClickImageChangeButton(View v) {
        // 선택된 방향에 따라 위치해있는 이미지뷰를 보여짐.
        switch (v.getId()) {
            case R.id.main_button_top:
                topImageView.setVisibility(View.VISIBLE);
                bottomImageView.setVisibility(View.INVISIBLE);
                break;
            case R.id.main_button_bottom:
                bottomImageView.setVisibility(View.VISIBLE);
                topImageView.setVisibility(View.INVISIBLE);
                break;
        }
    }
}