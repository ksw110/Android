package com.example.app0203;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<String> items;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        // View or 객체를 초기화하는 메소드! ctrl+alt+M
        init();

        // 데이터를 레이아웃에 연결(바인딩)하여 아이템뷰로 변환해주기 위한 어댑터 객체 생성!
        // 생성할 때 필요한 데이터 3가지!
        // 1. 액티비티 정보 : 액티비티명.this
        // 2. 아이템 레이아웃
        // 3. 데이터(배열 or ArrayList)
        adapter = new ArrayAdapter<>(
                ListViewActivity.this,
                android.R.layout.simple_list_item_1,
                items
        );

        // 생성된 어댑터 객체를 화면에 보여주기 위해 어댑터뷰인 리스트뷰에 저장
        lv.setAdapter(adapter);


        // 아이템을 클릭했을 때 이벤트 처리하기!
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                // view : 클릭한 아이템뷰를 Object로 가져온다!
                // i : 클릭한 아이템의 행 위치 -> 인덱스로 활용!
                Log.v("[ListViewActivity]", items.get(i));
            }
        });
    }

    private void init() {
        lv = findViewById(R.id.lv);
        items = new ArrayList<>();
        items.add("사과");
        items.add("딸기");
        items.add("수박");
        items.add("오렌지");
        items.add("키위");
        items.add("포도");
        items.add("거봉");
        items.add("망고");
        items.add("파인애플");
        items.add("귤");
        items.add("복숭아");
        items.add("애플망고");
        items.add("두리안");
        items.add("바나나");
        items.add("샤인머스켓");
    }
}