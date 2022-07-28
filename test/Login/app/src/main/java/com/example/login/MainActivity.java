package com.example.login;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText idEdit, pwEdit;

    final int REQUEST_MENU = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idEdit = findViewById(R.id.main_edit_id);
        pwEdit = findViewById(R.id.main_edit_pw);

        Button loginBtn = findViewById(R.id.main_button_login);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idEdit.getText().toString();
                String pw = pwEdit.getText().toString();

                if (id.isEmpty() || pw.isEmpty()) {
                    Toast.makeText(MainActivity.this, "아이디 또는 패스워드가 입력되지 않았습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(getApplicationContext(), com.example.login.MenuActivity.class);

                startActivityForResult(intent, REQUEST_MENU);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_MENU) {
            if(resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Menu Activity", Toast.LENGTH_SHORT).show();
            }
        }
    }
}