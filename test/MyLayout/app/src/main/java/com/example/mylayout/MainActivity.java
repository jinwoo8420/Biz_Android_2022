package com.example.mylayout;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    /*
        제약 레이아웃(constraint Layout)
            가장 최근에 나온 레이아웃이기 때문에 외부 라이브러리에 존재
            Activity 의 기본 레이아웃
                뷰의 크기, 위치를 제약 조건에 의해서 결정
                    제약 조건: 뷰가 레이아웃 안의 다른 뷰와 어떤 조건으로 연결 되어있는지 알려주는 것
                              뷰의 연결점과 다른 뷰를 연결을 통해 제약 조건을 활성
                              연결점은 뷰의 상하좌우 하나씩 총 4개 존재
                                → 상하 중 하나와 좌우 중 하나를 반드시 연결해야 제약 조건 완성
                                    상(Top) 하(Bottom) 좌(Left, Start) 우(Right, End)
                    연결점의 주 타겟
                        같은 레이아웃 안에 있는 다른 뷰의 연결점
                        부모 레이아웃의 연결점
                        가이드라인
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
