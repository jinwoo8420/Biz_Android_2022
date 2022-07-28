package com.example.myexampleapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ButtonsActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttons);

        radioGroup = findViewById(R.id.buttons_radiogroup_group);
        checkBox = findViewById(R.id.buttons_checkBox1);

        checkBox.setChecked(true); //체크를 설정하는 메소드
        checkBox.toggle();
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { //체크 설정 값이 바뀌면 실행 할 이벤트
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                /*
                    ※ 체크가 설정/해제 될 때 실행
                    isChecked: 체크가 되어있는지(true) 해제가 됐는지(false) 값을 가져옴
                 */
                if(isChecked) {
                    Toast.makeText(ButtonsActivity.this, "CheckBox Checked", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(ButtonsActivity.this, "CheckBox no Checked", Toast.LENGTH_SHORT).show();
                }
            }
        });
        
        radioGroup.check(R.id.radioButton);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton:
                        break;
                    case R.id.radioButton2:
                        break;
                }
            }
        });
    }
}
