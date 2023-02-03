package com.example.app0127;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

// drowable폴더에 이미지를 넣을 때 주의할 점
// 1. 숫자가 먼저 나오면 안된다
// 2. 대문자를 사용하면 안된다
// 3. 한글명으로 사용하면 안된다
//ex) 1cat.jpg(X) -> cat1.jpg
//    cAt.jpg(X) -> cat.jpg
//    고양이.jpg(X) -> cat.jpg
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kakao_login);
    }
}