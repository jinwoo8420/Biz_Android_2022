package com.example.acivitytransform2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    /*
    Activity
        앱의 화면을 구성하는 요소
        화면을 구성하는 파일(xml)과 동작하기 위한 파일(java)

    액티비티 전환
        다른 액티비티를 띄울 때는 반드시 인텐트(Intent) 클래스 사용
        startActivity(), startActivityForResult() 메소드 호출하여 출력
            startActivity(): 액티비티를 띄우기만 하는 메소드

            startActivityForResult(intent, requestCode): 액티비티를 띄우고 띄운 액티비티로부터 결과 값을 받아오는 메소드
                requestCode(요청 코드): 내가 요청한 액티비티의 코드 값 / 내가 띄울 액티비티의 코드 값

    액티비티 간 데이터 전달
        - Main → Menu: intent 객체에 저장 후 전달
        - Menu → Main: startActivityForResult 메소드를 통해서 액티비티를 실행
                        menu → setResult(resultCode,data) 메소드를 통해 데이터 전달
                             resultCode : 액티비티의 실행 결과를 코드 값, 정의된 코드값이 있고, 따로 정의를 해서 사용을 할 수 있음.
                             data: 인텐트 객체, 데이터만 저장하기 위한 규칙
                        Main에서 Menu가 보낸 데이터를 처리하기 위한 메소드 (onActivityResult()를 오버라이딩)
     */

    private final int REQUEST_MENU = 101;
    private final int REQUEST_LOGIN = 102;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultText = findViewById(R.id.main_text_result);

        Button button = findViewById(R.id.main_button_menu);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);

                intent.putExtra(String.valueOf(R.string.key_activity_name),"Hello Android");

                startActivityForResult(intent, REQUEST_MENU);
            }
        });

        Button button1 = findViewById(R.id.main_button_login);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), LoginActivity.class);

                startActivityForResult(intent1, REQUEST_LOGIN);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_MENU) {
            if(resultCode == RESULT_OK) {
                int result = data.getIntExtra("Result", -1);
                resultText.setText("Result: " + result);
            }
            else if(resultCode == RESULT_CANCELED) {
                resultText.setText("Result: Canceled");
            }
            else if(resultCode == MenuActivity.RESULT_FAIL) {
                resultText.setText("Result: Input Fail");
            }
        }
        else if(requestCode == REQUEST_LOGIN) {
            if(resultCode == RESULT_OK) {
                String id = data.getStringExtra("User ID");

                Toast.makeText(this,id+"님 환영합니다",Toast.LENGTH_SHORT).show();
            }
            else if(resultCode ==RESULT_CANCELED) {
                Toast.makeText(this,"로그인 실패",Toast.LENGTH_SHORT).show();
            }
        }
    }
}