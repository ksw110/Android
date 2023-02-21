package com.example.app0203;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ColorPickerActivity extends AppCompatActivity {
    private final static int COLOR_PICKER_CODE = 1;
    Button btn_red, btn_green, btn_blue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker);
        btn_red = findViewById(R.id.btn_red);
        btn_green = findViewById(R.id.btn_green);
        btn_blue = findViewById(R.id.btn_blue);

        btn_red.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("color","#FF4747");

            // setResult(resultCode, intent);
            // - resultCode : 이전화면에서 값을 접근할 때 성공/실패
            //                혹은 화면을 구분하기 위한 값
            // 종류 - resultCode : RESULT_OK(성공), RESULT_CANCELED(실패)
            setResult(COLOR_PICKER_CODE,intent);
            finish();
        });
        btn_blue.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("color","#3FFF46");

            // setResult(resultCode, intent);
            // - resultCode : 이전화면에서 값을 접근할 때 성공/실패
            //                혹은 화면을 구분하기 위한 값
            // 종류 - resultCode : RESULT_OK(성공), RESULT_CANCELED(실패)
            setResult(COLOR_PICKER_CODE,intent);
            finish();
        });
        btn_green.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("color","#4662FF");

            // setResult(resultCode, intent);
            // - resultCode : 이전화면에서 값을 접근할 때 성공/실패
            //                혹은 화면을 구분하기 위한 값
            // 종류 - resultCode : RESULT_OK(성공), RESULT_CANCELED(실패)
            setResult(COLOR_PICKER_CODE,intent);
            finish();
        });
    }
}