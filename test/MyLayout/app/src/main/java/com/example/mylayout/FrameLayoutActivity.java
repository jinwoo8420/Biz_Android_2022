package com.example.mylayout;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
/*
    프레임 레이아웃: 액자와 같은 레이아웃
        특성
            중첩(Overlay): 뷰들을 중첩시킬 수 있는 특성
            가시성(Visibility): 뷰의 전환, 뷰를 화면에 보이고 안 보이게 하는 특성
        속성
            visibility
                visible: 화면에 보여짐
                insivible: 화면에 안 보임 (크기,자리 차지)
                gone: xml에서 사라짐 (크기, 자리 차지 않 함)
 */
public class FrameLayoutActivity extends AppCompatActivity {
    TextView blueText, orangeText, primaryText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);

        blueText= findViewById(R.id.frame_blue);
        orangeText= findViewById(R.id.frame_orange);
        primaryText = findViewById(R.id.frame_primary);
    }

    public void onClickColorButton(View v) {
        blueText.setVisibility(View.INVISIBLE);
        orangeText.setVisibility(View.INVISIBLE);
        primaryText.setVisibility(View.INVISIBLE);

        switch (v.getId()) {
            case R.id.frame_button_blue:
                blueText.setVisibility(View.VISIBLE);
                break;
            case R.id.frame_button_orange:
                orangeText.setVisibility(View.VISIBLE);
                break;
            case R.id.frame_button_primary:
                primaryText.setVisibility(View.VISIBLE);
                break;
        }
    }
}