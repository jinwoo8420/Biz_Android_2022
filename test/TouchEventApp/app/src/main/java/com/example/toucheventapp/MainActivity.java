package com.example.toucheventapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/*
    방향 전환 이벤트
        방향 전환할 때 액티비티가 어떻게 실행되는가
            - 기존의 액티비티가 종료
            - 바뀐 방향으로 새 액티비티를 띄움.

 */
public class MainActivity extends AppCompatActivity {
    TextView topText, bottomText;
    TextView logText;
    final String TAG = "MainActivity";
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toast.makeText(this, "OnCreate ", Toast.LENGTH_SHORT).show();

       // 로그 작성 하는 법
       Log.i(TAG, "onCreate 호출");





        // 터치 이벤트를 하기 위한 텍스트
        topText = findViewById(R.id.main_container_top);

        // 제스처 이벤트를 하기 위한 텍스트
        bottomText = findViewById(R.id.main_container_bottom);

        // 위의 이벤트의 결과를 출력하기 위한 로그 텍스트
        logText = findViewById(R.id.main_text_log);

        if(savedInstanceState != null) {
            logText.setText(savedInstanceState.getString("logText"));
        }

        topText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                /*
                    MotionEvent : 터치 모션에 대한 행동을 정의 및 구현한 클래스
                     - ACTION_DOWN  : 터치 함
                     - ACTION_UP    : 터치 뗌
                     - ACTION_MOVE  : 터치한 상태로 움직임


                     반환 값
                      true : 이후 터치 이벤트를 받음
                      false : 이후 터치 이벤트를 받지 않음.
                 */

                // 좌표 값
                float x = event.getX();
                float y = event.getY();




                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    // [x , y] 터치 함
                    logText.append("["+ x + ", " + y + "] 터치 함\n");
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    logText.append("["+ x + ", " + y + "] 터치 뗌\n");
                }else if(event.getAction() == MotionEvent.ACTION_MOVE) {
                    logText.append("["+ x + ", " + y + "] 터치한 상태로 움직임\n");
                }


                return true;
            }
        });


        final GestureDetector detector = new GestureDetector(new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {

                return false;
            }

            @Override
            public void onShowPress(MotionEvent e) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                /*
                    e1 : 터치를 시작했을 때 발생한 이벤트
                    e2 : 터치를 땠을 때 발생한 이벤트
                 */
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {

            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

                return false;
            }

        });


        bottomText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                detector.onTouchEvent(event);
                return true;
            }
        });
    }


    // 키패드 키 이벤트
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // KeyCode : 키패드 또는 물리적 버턴을 코드값으로 표현




        return super.onKeyDown(keyCode, event);

    }


    @Override
    public void onBackPressed() {
        // 뒤로가기 버튼을 눌렀을 때 발생하는 메소드
        // 밑의 코드가 현재 엑티비티를 종료하고 이전 액티비티를 띄움
        super.onBackPressed();

    }

    // 액티비티가 소멸할 때 실행하는 메소드
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy 호출");
    }

    // 액티비티가 종료했을 때 실행하는 메소드
    // 해당 액티비티의 값을 저장하는데 사용.
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // outState : 값을 저장하는 객체
        // 데이터 저장
        outState.putString(/*key*/"logText",/*value*/logText.getText().toString());
    }

//    @Override
//    public void onConfigurationChanged(@NonNull Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//
//        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            Toast.makeText(this, "LANDSCAPE", Toast.LENGTH_SHORT).show();
//        }else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
//            Toast.makeText(this, "PORTRAIT", Toast.LENGTH_SHORT).show();
//        }
//
//
//
//
//
//
//    }
}
