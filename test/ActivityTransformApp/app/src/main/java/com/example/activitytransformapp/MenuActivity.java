package com.example.activitytransformapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MenuActivity extends AppCompatActivity {
    /*
        입력창에 두 정수가 입력되면
        두 정수의 합을 전달 : 정상 처리가 됐기 때문에 OK

        하나로 입력이 되지않으면
        비 정상 처리가 되기 때문에 CANCEL
     */
    static final int RESULT_CODE_STRING = 11;
    EditText aEdit, bEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        aEdit = findViewById(R.id.menu_edit_a);
        bEdit = findViewById(R.id.menu_edit_b);

        Button button = findViewById(R.id.menu_button_result);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 두 입력창에서 값을 가져와서
                // 입력된 값이 둘다 있는지 판단 한 후
                // 둘중 하나라도 없으면 cancel
                // 둘 다 있으면 합한 값을 전달(ok)
                try {
                    int a = Integer.parseInt(aEdit.getText().toString());
                    int b = Integer.parseInt(bEdit.getText().toString());
                    int result = a + b;

                    // 데이터를 전달하기 위한 인텐트 생성
                    Intent data = new Intent(); // 값을 저장하기위한 인텐트
                    // 인텐트 내에 Bundle 객체가 있어서 데이터를 저장할 수 있음.
                    data.putExtra("result", result);

                    setResult(RESULT_OK, data);
                }catch(NumberFormatException e ) {
                    if(aEdit.getText().toString().length() > 0
                            && bEdit.getText().toString().length() > 0) {
                        setResult(RESULT_CODE_STRING);
                    }else {
                        setResult(RESULT_CANCELED);
                    }


                }
                finish();

            }
        });
    }
}
