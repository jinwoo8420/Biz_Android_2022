package com.example.acivitytransform2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    /*
        MainActivity → LoginActivity 띄우기
        LoginActivity에서 아이디, 패스워드 입력
        로그인 버튼 누르면 MainActivity에서 토스트 메시지로 "~님,환영합니다"
        빈 칸이 있는 상태로 로그인 버튼을 누르면 토스트 메시지로 "로그인 실패"

        - 액티비티를 띄울 인텐트 객체 생성
        - startActivity() or startActivityForResult() 호출
        - requestCode 정의
        - LoginActivity 구현 (뷰를 객체화, 이벤트 리스너 설정)
        - 실행 결과에 따라 setResult() 메소드 호출
            아이디와 패스워드가 입력될 때 setResult() 호출
            아이디 또는 패스워드가 입력되지않고 로그인 버튼이 눌렸을 때 setResult() 호출
            필요에 따라 resultCode 정의
        - onActivityResult() 메소드를 오버라이딩
     */
    EditText idEdit, pwEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button button = findViewById(R.id.login_button_login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idEdit.getText().toString();
                String pw = pwEdit.getText().toString();

                if(id.isEmpty() || pw.isEmpty()) {
                    setResult(RESULT_CANCELED);
                }
                else {
                    Intent data = new Intent();
                    data.putExtra("User ID",id);
                    setResult(RESULT_OK, data);
                }
                finish();
            }
        });
    }
}
