package com.example.messangerapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

public class SplashActivity extends AppCompatActivity {
    /*
    앱이 맨처음 실행 시 띄어지는 로딩 화면
    앱에서 필요한 네트워크, DB 연결은 물론 앱에 필요한 리소스를 가져오는 동안 띄어지는 화면
    앱의 상태, 점검 알림을 알리는 화면

    Remote Config(원격 구성)
        서버에서 앱의 대한 설정 또는 값을 정의

    점검 유무 / 점검 내용 / 테마 색
     */
    ConstraintLayout constraintLayout;
    FirebaseRemoteConfig remoteConfig;
    final String TAG = "SplashActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        constraintLayout = findViewById(R.id.splash_layout_container);

        // RemoteConfig 객체 생성
        remoteConfig = FirebaseRemoteConfig.getInstance();

        // 디버깅을 위해서 제한 시간 줄임
        FirebaseRemoteConfigSettings settings = new FirebaseRemoteConfigSettings.Builder().setMinimumFetchIntervalInSeconds(0).build();
        remoteConfig.setConfigSettingsAsync(settings);

        remoteConfig.setDefaultsAsync(R.xml.config_default);

        // 서버에 있는 값을 가져오기(fetch), 활용(Activate)
        remoteConfig.fetchAndActivate().addOnCompleteListener(new OnCompleteListener<Boolean>() {
            @Override
            public void onComplete(@NonNull Task<Boolean> task) {
                if(task.isSuccessful()) {
                    Log.i(TAG,"Remote Config Read Success");
                }
                else {
                    Log.i(TAG,"Remote Config Read Fail");
                }
                display();
            }
        });
    }

    private void display() {
        // RemoteConfig 에 저장 된 데이터 가져와서 사용
        String themeColor = remoteConfig.getString( getString(R.string.app_theme) );
        boolean caps = remoteConfig.getBoolean( getString(R.string.server_caps) );
        String caps_message = remoteConfig.getString( getString(R.string.server_caps_message) );
        // 배경색 설정
        constraintLayout.setBackgroundColor(Color.parseColor(themeColor));
        // 점검 중
        if(caps) {
            new AlertDialog.Builder(this).setMessage(caps_message).setPositiveButton("예", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            }).create().show();
        }
        // 점검이 아닐 시
        else {
            // LoginActivity 이동
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
            finish(); // Login → Splash 화면으로 넘어 올 일이 없기 때문에 종료
        }
    }
}
