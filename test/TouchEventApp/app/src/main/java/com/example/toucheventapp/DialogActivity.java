package com.example.toucheventapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.strictmode.NonSdkApiUsedViolation;
import android.view.WindowManager;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {
    /*
        알림창 띄우기
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dialog);


        /*
        // 알림 대화상자 클래스
        // AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // builder 의 역할
        // 대화상자의 제목, 내용, 버튼의 유뮤 및 기능
        builder.setTitle("대화상자 제목");
        builder.setMessage("대화상자 내용");
        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNeutralButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });


        AlertDialog dialog = builder.create();

        dialog.show();

         */
        //createDialog();
    }

    void createDialog() {
        new AlertDialog.Builder(this)
                .setTitle("알림창") // 알림 제목
                .setMessage("종료하시겠습니까?") // 알림 내용
                .setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish(); // 액티비티 종료
                    }
                })    // 긍정
                .setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })    // 부정
                .setNeutralButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })   // 취소
                .create() //AlertDialog 객체로 생성
                .show();  // 생성된 AlertDialog 객체를 보여줌

    }

    @Override
    public void onBackPressed() {
        createDialog();
    }
}
