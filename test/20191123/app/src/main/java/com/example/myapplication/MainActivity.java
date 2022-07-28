package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
/*
    View: 컨트롤, 위젯 등으로 불리는 UI 구성 요소 / 사용자 눈에 보이는 화면 구성 요소
    뷰 그룹: 뷰들을 포함할 수 있는 것 / 뷰 그룹 내에서 뷰들의 위치 지정
            뷰 그룹 포함 가능(뷰 = 뷰 그룹) → 뷰를 상속 받았기 때문

    Object: 자바에서 모든 클래스의 최상위 클래스
    View: 안드로이드에서 모든 뷰들의 최상위 뷰

    위젯: 컨트롤 가능한 뷰
    레이아웃: 뷰들을 담아서 배치하는 뷰(뷰 그룹) / 뷰는 레이아웃 안에 들어가야 동작 가능 / 최소 하나는 존재해야 함
             레이아웃 안에 레이아웃을 배치함으로써 다양한 화면 구성 가능(종류에 따라 구성 방식 다름)

    뷰들의 속성
        필수 속성(반드시 설정해야 함)
            크기에 대한 속성 → 가로(layout_width) 세로(layout_height)
                가로(layout_width): 너비
                세로(layout_height): 높이
                입력 단위: dp
            wrap_content: 뷰 안에 있는 내용에 따라 크기를 조절
            match_parent: parent → 자신이 속해있는 레이아웃 의미
                          레이아웃의 영역을 전체를 차지하도록 조절
            match_constraint: constraint Layout 에서 사용하는 속성 값
                             타겟으로 지정 된 곳까지 차지하도록 조절

        id 속성
            뷰들의 이름
                java 파일에서 xml 상에 있는 뷰들을 찾을 때 사용하기 위함

        xml
            데이터를 기술해놓은 문서
                태그: < > 안에 데이터의 형태(종류)가 들어가 있으며 시작태그와 끝태그가 존재
                    시작태그( <View> ) 끝태그( </View>)

                속성: 시작태그 안에 작성을 하고 공백으로 구분하며 작성
                    <View 속성: "___"
                        속성: "___"
                      >

            레이아웃 같은 경우
                뷰들을 포함시킬 때: 시작태그와 끝태그 사이에 뷰들을 작성

 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*  xml 상에 있는 뷰들을 객체화
            findViewById: xml 상에 있는 뷰를 id를 통해서 가져옴
            R: resource 를 의미
            id: res 에서 찾는 기준
            main_Button: 뷰의 id
         */
        Button button = findViewById(R.id.main_Button);
        /*
            Button 객체에 클릭 이벤트 설정
         */
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(위치, 무엇, 기간).show();
                Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_LONG).show();
            }
        });
    }
/*
    매개변수 View v
        v → onClikedText를 호출한 뷰: 업캐스팅
        setText() 메소드는 TextView에 정의된 메소드이기 때문에 다운캐스팅
 */
    public void onClikedText(View v) {
        TextView textView = (TextView) v;
        textView.setText("Hello");
    }
}
