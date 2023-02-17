package com.example.app0201;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity3 extends AppCompatActivity {

    Button btnWeb,btnCamera,btnDial,btnCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btnWeb = findViewById(R.id.btnWeb);
        btnCamera = findViewById(R.id.btnCamera);
        btnDial = findViewById(R.id.btnDial);
        btnCall = findViewById(R.id.btnCall);

        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 현재 액티비티에서 다른 액티비티를 실행시켜보자!
                // 1. Intent 객체생성
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.naver.com"));

                // 2. Intent에 담긴 정보로 실행!
                startActivity(intent);
            }
        });
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });
        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:010-7155-7148")); // 전화번호 자동기입방법
                startActivity(intent);
            }
        });
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL,
                        Uri.parse("tel:010-7155-7148")); // 전화번호 자동기입방법
                // 유저에게 권한 사용에 대한 허가를 받아야 한다!
                // 앱에 권한 설정이 되어있는지 확인 후 유저 화면에 요청알림 띄우기!
                // * 앱이 실행되었을 때 권한을 요청해야 할 경우 onStart() or on Resume() 에 구현한다
                if(ContextCompat.checkSelfPermission(MainActivity3.this,
                        android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(MainActivity3.this,
                            new String[]{android.Manifest.permission.CALL_PHONE}, 0);
                    return;
                }

                startActivity(intent);
            }
        });
    }
}