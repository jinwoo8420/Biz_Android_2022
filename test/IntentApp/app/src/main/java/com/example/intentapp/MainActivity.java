package com.example.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.intentapp.Model.User;

public class MainActivity extends AppCompatActivity {
    /*
        부가 데이터
            Intent 객체에 데이터를 추가적으로 저장하기 위한 수단
                데이터 저장: Intent 객체.putExtra(name, value)
                    주의점: 개발자가 작성한 클래스의 객체는 데이터를 저장 불가
                            → Parcelable 인터페이스 사용하여 객체를 직렬화 후 저장
                            → 객체 -> 직렬화한 데이터(Parcel) -> 객체
                데이터 읽기: Intent 객체.get(value)Extra(name)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.main_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel: 000-0000"));
                Intent intent = new Intent(getApplicationContext(),userActivity.class);

                intent.putExtra("username","ljw");
                intent.putExtra("userage",24);

                User user = new User("ljw",24);
                intent.putExtra("user",user);

                startActivity(intent);
            }
        });
    }
}
