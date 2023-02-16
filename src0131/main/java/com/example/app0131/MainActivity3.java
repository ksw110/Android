package com.example.app0131;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

// 각 버튼을 눌렀을 때, 이미지가 바뀌는 기능을 구현하기!
// 1. "다음" 버튼을 누르면 이미지가 순서대로 넘어간다.
// 2. "이전" 버튼을 누르면 이미지가 역순으로 넘어간다.
// 3. 마지막 이미지에서 다음 버튼을 누르면 다시 처음으로 처음에서 이전누르면 마지막으로
public class MainActivity3 extends AppCompatActivity {
    Button btn_next, btn_pre;
    ImageView img;
    // 이미지를 보관하는 배열 생성
    int[] imgArray = {R.drawable.r1,R.drawable.r2,R.drawable.r3};
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        img = findViewById(R.id.img);
        btn_next = findViewById(R.id.btn_next);
        btn_pre = findViewById(R.id.btn_pre);

        // ImageView 의 이미지를 변경할 때 사용!
        // R.drawable.파일명
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                img.setImageResource(imgArray[pos]);
                if(pos == 2){
                    pos = 0;
                }else{
                    pos += 1;
                }

            }
        });
        btn_pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                img.setImageResource(imgArray[pos]);
                if(pos == 0){
                    pos = 2;
                }else{
                    pos -= 1;
                }
            }
        });

    }


}