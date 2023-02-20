package com.example.app0202;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class LoginResultActivity extends AppCompatActivity {
    TextView tv_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_result);
        String id = "q1w2";
        String pw = "12345";
        tv_result = findViewById(R.id.tv_result);
        tv_result.setText("로그인 성공");
        Intent intent = getIntent();
        String ID = intent.getStringExtra("ID");
        String PW = intent.getStringExtra("PW");

        if(id.equals(ID) && pw.equals(PW)){
            tv_result.setText("로그인 성공");
        }else{
            tv_result.setText("로그인 실패");
        }
    }
}