package com.example.app0202;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
Button btn_login;
EditText edt_id,edt_pw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        btn_login = findViewById(R.id.btn_login);
        edt_id = findViewById(R.id.edt_id);
        edt_pw = findViewById(R.id.edt_pw);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,LoginResultActivity.class);

                intent.putExtra("ID",edt_id.getText().toString());
                intent.putExtra("PW",edt_pw.getText().toString());

                startActivity(intent);

            }
        });
    }
}