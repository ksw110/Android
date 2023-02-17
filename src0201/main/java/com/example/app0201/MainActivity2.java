package com.example.app0201;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

// 생명주기(Life cycle)
// : App이 시작부터 종료까지 실행되는 일련의 과정
// : onCreate-onStart-onResume-onPause-onStop-onDestory
// : onRestart
public class MainActivity2 extends AppCompatActivity {

    // Log에 사용할 Tag 변수 생성
    private final static String TAG = "MainActivity2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.v(TAG,"onCreate() 실행!");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG,"onStart() 실행!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG,"onResume() 실행!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG,"onPause() 실행!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG,"onStop() 실행!");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(TAG,"onRestart() 실행!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG,"onDestroy() 실행!");
    }


}