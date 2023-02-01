package com.example.app0126;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt;

    // onCreate() : 앱이 처음 실행했을 때 화면(XML)을 생성하는 메소드
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ★findViewById(R.id.view의 id값) : 화면에 배치된 View의
        // 객체정보를 가져오는 메소드
        txt = findViewById(R.id.txt);

        // View의 text속성값을 가져오는 메소드
        // String 타입이 아니기때문에 형변환 해줘야함
        String data = txt.getText().toString();

        // Log클래스 : 앱에서 발생된 값들을 확인하기 위한 클래스
        // 종류: i(info), w(worning), v(verbose)
        //       d(debug), e(error)
        // -> Logcat도구를 이용해서 조회
        // -> Run도구에서도 확인 (앱을 실행했을 때만 활성화)
        Log.d("[MainActivity]",data);

        // View의 text 속성값을 변경하는 메소드
        txt.setText("나의 첫 앱 실행!");

        // View의 배경색을 변경하는 메소드
        // Color.parseColor() : 16진수(HEX) 포맷의 데이터를 색상으로 변환해주는 메소드
        //https://flatuicolors.com/ 사이트 또는 네이버 생상코드 참조
        txt.setBackgroundColor(Color.parseColor("#546de5"));

        // View 의 글자색을 변경하는 메소드
        txt.setTextColor(Color.parseColor("#ffffff"));



    }
}