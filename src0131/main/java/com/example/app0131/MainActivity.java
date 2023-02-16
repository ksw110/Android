package com.example.app0131;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

    // 각 버튼을 눌렀을 때, 배경색을 변경하는 기능을 구현하기!
    // 1. View.OnclickListener 를 인터페이스로 구현
    // 2. onClick()를 오버라이딩
    // 3. onClick() 메소드 내 버튼을 구별하는 조건문 만들기
    // 4. c_layout의 배경색을 변경하는 기능 구현

    // View.OnClickListener 인터페이스 구현
    // : 여러 개의 버튼이 공통된 기능으로 구현할 경우에 적합
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ConstraintLayout c_layouy ;
    Button btn_red, btn_green, btn_blue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // view 를 초기화 하기!
        c_layouy = findViewById(R.id.c_layout);
        btn_red = findViewById((R.id.btn_red));
        btn_green = findViewById((R.id.btn_green));
        btn_blue = findViewById((R.id.btn_blue));

        // 각 버튼에 onClick() 메소드 연결해주기!
        btn_red.setOnClickListener(this);
        btn_blue.setOnClickListener(this);
        btn_green.setOnClickListener(this);



    }

        @Override
        public void onClick(View view) {
            Log.v("syatus","버튼클릭!");
            // 클릭이 발생된 view의 id를 가져오는 메소드
            int viewId = view.getId();

            // 빨강색 버튼을 눌렀는지 판단
            if(viewId == R.id.btn_red){
                Log.v("syatus","빨강색 버튼클릭!");
                c_layouy.setBackgroundColor(Color.RED);
            }else if(viewId == R.id.btn_green){
                Log.v("syatus","초록색 버튼클릭!");
                c_layouy.setBackgroundColor(Color.GREEN);
            }else if(viewId == R.id.btn_blue){
                Log.v("syatus","파랑색 버튼클릭!");
                c_layouy.setBackgroundColor(Color.BLUE);
            }
        }
    }