package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        R: resource
        layout: layout resource folder
        activity_menu: layout xml file
        연결된 레이아웃의 뷰들만 사용 가능
         */
        setContentView(R.layout.activity_menu);

        Button button = findViewById(R.id.menu_button_fun4);
        button.setText("버튼입니다");

        /*
        버튼을 눌렀을 때 기능 수행 방법
            이벤트 리스너 설정
                하나의 버튼을 설정 할 때 주로 사용

            onClick 속성으로 메소드를 설정
                비슷한 기능을 하는 버튼을 하나의 메소드로 구현해서 xml 에서 onClick 속성 적용
         */
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuActivity.this, "버튼 4 클릭", Toast.LENGTH_SHORT).show();
                //다른 화면 띄우기
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
    //매개변수 v는 onClickButton 을 속성값으로 버튼 중에 눌려진 버튼의 정보가 업캐스팅 되어서 넘어옴
    public void onClickButton(View v) {
        String msg = "";
        switch(v.getId()) {
            case R.id.menu_button_fun1:
                msg = "버튼 1 클릭";
                break;
            case R.id.menu_button_fun2:
                msg = "버튼 2 클릭";
                break;
            case R.id.menu_button_fun3:
                msg = "버튼 3 클릭";
                break;
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
