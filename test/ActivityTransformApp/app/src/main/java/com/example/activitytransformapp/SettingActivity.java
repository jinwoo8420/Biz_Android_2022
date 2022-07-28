package com.example.activitytransformapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SettingActivity extends AppCompatActivity {
    /*
        입력창에 입력된 문자열을 MainActivity 에 전달해서
        텍스트로 출력을 해주시면 됩니다.

        만약에 입력된 문자열이 없으면
        Input Fail 을 출력해주시면 됩니다.


     */






    EditText nameEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        nameEdit = findViewById(R.id.setting_edit_name);
        Button button = findViewById(R.id.setting_button_send);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = nameEdit.getText().toString();

                if(name.isEmpty()) { // 입력값이 없는 경우
                    setResult(RESULT_CANCELED);
                }else { //입력값이 있는 경우
                    Intent data = new Intent();
                    data.putExtra("name", name);
                    setResult(RESULT_OK, data);

                }

                finish();

            }
        });




    }
}
