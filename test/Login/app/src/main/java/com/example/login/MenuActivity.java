package com.example.login;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.login.CustomerManagementActivity;
import com.example.login.ProductManagementActivity;
import com.example.login.R;
import com.example.login.SalesManagementActivity;

public class MenuActivity extends AppCompatActivity {

    private final int REQUEST_CUSTOMER = 101;
    private final int REQUEST_SALES = 102;
    private final int REQUEST_PRODUCT = 103;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button customerBtn = findViewById(R.id.menu_button_customer);
        Button salesBtn = findViewById(R.id.menu_button_sales);
        Button productBtn = findViewById(R.id.menu_button_product);


        customerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CustomerManagementActivity.class);
                startActivityForResult(intent, REQUEST_CUSTOMER);
            }
        });

        salesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SalesManagementActivity.class);
                startActivityForResult(intent, REQUEST_SALES);
            }
        });

        productBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProductManagementActivity.class);
                startActivityForResult(intent, REQUEST_PRODUCT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CUSTOMER) {
            Toast.makeText(this, "CustomerManagementActivity", Toast.LENGTH_SHORT).show();
        }else if(requestCode == REQUEST_SALES) {

        }else if(requestCode == REQUEST_PRODUCT) {

        }
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        super.onBackPressed();
    }
}
