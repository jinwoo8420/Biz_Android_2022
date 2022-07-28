package com.example.myexampleapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.edit_button_print);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = editText.getText().toString(); //텍스트를 가져옴

                if(msg.isEmpty()) { //입력된 메세지가 없는 경우
                    Toast.makeText(EditActivity.this, "ID, PASSWORD no Input", Toast.LENGTH_SHORT).show();
                }

                Toast.makeText(EditActivity.this, msg, Toast.LENGTH_SHORT).show();

                editText.setText(""); //입력값 바꾸기(비우기)
            }
        });
    }
}
