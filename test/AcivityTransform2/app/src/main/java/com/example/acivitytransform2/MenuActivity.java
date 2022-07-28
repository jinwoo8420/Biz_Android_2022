package com.example.acivitytransform2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    final static int RESULT_FAIL = 200;

    EditText numEditA, numEditB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent data = getIntent();

        String name = data.getStringExtra(String.valueOf(R.string.key_activity_name));

        TextView textView = findViewById(R.id.menu_text_name);
        textView.setText(name);

        numEditA = findViewById(R.id.menu_edit_a);
        numEditB = findViewById(R.id.menu_edit_b);

        Button button = findViewById(R.id.menu_button_a);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int numA = Integer.parseInt(numEditA.getText().toString());
                    int numB = Integer.parseInt(numEditB.getText().toString());

                    int result = numA + numB;

                    Intent data = new Intent();
                    data.putExtra("Result", result);
                    setResult(RESULT_OK, data);
                }
                catch(NumberFormatException e) {
                    setResult(RESULT_FAIL);
                }
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        super.onBackPressed();
    }
}