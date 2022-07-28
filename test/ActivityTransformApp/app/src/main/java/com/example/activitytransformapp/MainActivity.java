package com.example.activitytransformapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /*
        액티비티의 관리
            액티비티 스택이라는 공간에 의해 관리가 이뤄짐.
            스택 : 순서대로 쌓이는 구조




     */

    // 요청 코드
    final int REQUEST_CODE_MENU = 101;
    final int REQUEST_CODE_SETTING = 102;



    TextView resultText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.main_button_menu);
        resultText = findViewById(R.id.main_text_result);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // menu 화면으로 이동
                Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
                startActivityForResult(intent, REQUEST_CODE_MENU);
                //startActivity(new Intent(getApplicationContext(), MenuActivity.class));
            }
        });

        Button settingBtn = findViewById(R.id.main_button_setting);
        settingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getApplicationContext(), SettingActivity.class), REQUEST_CODE_SETTING);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // requestCode : 요청코드 (어떤 액티비티에 요청했는가)
        // resultCode : 결과 코드 (결과에 대한 코드)
        // data : 액티비티가 보내는 데이터

        if(requestCode == REQUEST_CODE_MENU) { // MenuActivity 로부터 결과 값을 받으면
            if(resultCode == RESULT_OK){    // 그 결과가 RESULT_OK 이면
                // 텍스트에 결과값을 출력
                // 전달받은 데이터를 키 값을 통해 가져와서 출력
                int res = data.getIntExtra("result",0);
                resultText.setText("Result : " + res);
            }else if(resultCode == RESULT_CANCELED){
                resultText.setText("Operation Fail");
            }else if(resultCode == MenuActivity.RESULT_CODE_STRING) {
                resultText.setText("Input Value Type is String Type");
            }
        }else if(requestCode == REQUEST_CODE_SETTING) { // SettingActivity 로부터 결과 값을 받으면
            if(resultCode == RESULT_OK) {
                String name = data.getStringExtra("name");
                resultText.setText("Result : " + name);
            }else if(resultCode == RESULT_CANCELED) {
                resultText.setText("Input Fail");
            }




        }













    }
}
