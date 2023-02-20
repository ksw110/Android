package com.example.app0202;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

// MainActivity 화면에서 NextActivity 화면으로 넘어가는 기능구현하기
public class MainActivity extends AppCompatActivity {

    Button btnNext;
    EditText edtMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNext = findViewById(R.id.btnNext);
        edtMsg = findViewById(R.id.edtMsg);
        // 람다식 이벤트 처리리
        // - 기존 이벤트 메소드의 매개변수 개수에 따라 정의해줘야 함
        // 버튼을 눌렀을 때, NextActivity 화면으로 이동하기 (intent)
        // + 유저가 입력한 데이터 전송하기
       btnNext.setOnClickListener(v -> {

           // new Intent(현재 액티비티 화면정보 , 이동할 액티비티 클래스명)
           Intent intent = new Intent(MainActivity.this,NextActivity.class);

           // Intent 객체에 데이터 저장하기!
           // putExtro(구분값, 데이터)
           intent.putExtra("msg",edtMsg.getText().toString());
           intent.putExtra("num",2023);

           // 생성된 Intent 정보를 안드로이드 시스템에 전달하여 실행해주는 역할!
           startActivity(intent);

           // 현재 익티비티 종료시키기!
           //finish();
        });
    }
}