package com.example.app0202;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

// 나가기 버튼 클릭 시, 현재 액티비티를 종료하는 기능 구현해보기
// -finish() 활용
public class NextActivity extends AppCompatActivity {

    Button btnMain;
    TextView tvMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        btnMain = findViewById(R.id.btnMain);
        tvMsg = findViewById(R.id.tvMsg);

        // 안드로이드 시스템에 저장된 Intent 가져오기! ★★★
        Intent intent = getIntent();

        // 특정 이름을 이용해서 Intent 내 데이터 가져오기
        String msg = intent.getStringExtra("msg");

        // intent에 "nun" 에 해당하는 값이 없는 경우에 defoultvalue 값이 저장된다.
        // 테스트는 Main에서 주석처리 해보기
        int num = intent.getIntExtra("num",0);

        // 가져온 데이터를 TextView에 보여주기!
        tvMsg.setText(msg+"/"+num);

        btnMain.setOnClickListener(v -> {
            finish();
        });
    }
}