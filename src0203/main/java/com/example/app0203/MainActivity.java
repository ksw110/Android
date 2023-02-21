package com.example.app0203;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

// Intent 용도 3가지
// 1. 다른 액티비티 실행
// 2. 실행된 액티비티에 데이터 전달
// 3. 실행된 액티비티로부터 결과 수신
public class MainActivity extends AppCompatActivity {
    private final static int COLOR_PICKER_CODE = 1;
    ConstraintLayout c_layout;
    TextView tv_msg;
    Button btn_next, btn_color;

    // 이동환 화면(Next)에서 결과값을 수신하기 위한 객체 생성
    ActivityResultLauncher<Intent> mainLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    // result변수를 이용해서 Intent 정보를 가져오기!


                    // result.getResultCode() : setResult()에 넘겼던 resultCode값을 가져온다!
                    // result.getData() : setResult()에 넘겼던 intent값을 가져온다!
                    if(result.getResultCode() == RESULT_OK){
                            Intent intent =result.getData();
                            String msg = intent.getStringExtra("data");
                            tv_msg.setText(msg);

                    }else if(result.getResultCode() == COLOR_PICKER_CODE){
                        // 액티비티 화면이 2개 이상인 경우, COLOR_PICKER_CODE처럼
                        // 화면을 구분할 수 있는 변수를 생성해서 비교문에 활용해야 한다.
                        Intent intent =result.getData();
                        String color = intent.getStringExtra("color");
                        c_layout.setBackgroundColor(Color.parseColor(color));
                    }
                }
            }
    );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_msg = findViewById(R.id.tv_msg);
        btn_next = findViewById(R.id.btn_next);
        btn_color =findViewById(R.id.btn_color);
        c_layout = findViewById(R.id.c_layout);

        btn_next.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,MainActivity2.class);

            // 다른 액티비티를 실행해주기!
            // : 이동한 화면에서 보내준 데이터를 가져오는 기능
            mainLauncher.launch(intent);
        });
        btn_color.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this,ColorPickerActivity.class);
            mainLauncher.launch(intent);
        });
    }
}