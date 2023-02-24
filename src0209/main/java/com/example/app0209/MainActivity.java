package com.example.app0209;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // 바로가기 데이터 만들기!
    // => 데이터 하나에는 제목(Strain), 주소(String)
    // => DirectVO(ValueObject) => 사용자(개발자) 정의 자료형


    // 1. DirectVO 를 저장할 ArrayList 생성

    ArrayList<DirectVO> directVOS = new ArrayList<>();
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2. DirectVO 객체 생성해서 ArrayList에 3개 저장~
        // - 제목과 주소는 여러분 하고싶은데로~
        directVOS.add(new DirectVO("네이버", "https://www.naver.com/"));
        directVOS.add(new DirectVO("구글", "https://www.google.com/"));
        directVOS.add(new DirectVO("유튜브", "https://www.youtube.com/"));

        rv = findViewById(R.id.RecyclerView);

        DirectAdapter adapter = new DirectAdapter(directVOS,getApplicationContext());
        rv.setAdapter(adapter);

        // 리스트(LinearLayoutManager) 형태로 할건지 그리드(GridLayoutManager) 형태로 할건지
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
}