package com.example.app0203;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    Button btn_result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn_result = findViewById(R.id.btn_result);

        btn_result.setOnClickListener(v -> {

            // 이전 화면(Main)으로 결과값 전달하기!
            Intent intent = new Intent();
            intent.putExtra("data","Next화면에서 전달받은 데이터입니다.");

            // setResult(resultCode, intent);
            // - resultCode : 이전화면에서 값을 접근할 때 성공/실패
            //                혹은 화면을 구분하기 위한 값
            // 종류 - resultCode : RESULT_OK(성공), RESULT_CANCELED(실패)
            setResult(RESULT_OK,intent);
            finish();

        });
    }
}