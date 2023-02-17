package com.example.app0201;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

// 주사위 App
// 1. 버튼을 누르면 주사위 눈이 랜덤으로 출력된다.(Random)
// 2. 두 주사위 눈을 비교한다.
// 2-1. img1 > img2 : tv_user1에 카운트 +1
// 2-2. img1 < img2 : tv_user2에 카운트 +1
// 2-3. img1 == img2 : Toast 를 이용해서 "무승부!" 알림메시지 출력
public class MainActivity extends AppCompatActivity {

    int[] imgArray = {R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,
                      R.drawable.dice4, R.drawable.dice5,R.drawable.dice6};
    TextView tv_user1,tv_user2;
    Button btn_shake;
    ImageView img1,img2;
    int user1 = 0;
    int user2 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random rd = new Random();
        btn_shake = findViewById(R.id.btn_shake);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        tv_user1 = findViewById(R.id.tv_user1);
        tv_user2 = findViewById(R.id.tv_user2);
tv_user1.setText(Integer.toString(user1));

        // 버튼에 클릭이벤트 적용(익명클래스)
        btn_shake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int arr = rd.nextInt(6);
                int arr1 = rd.nextInt(6);
                img1.setImageResource(imgArray[arr]);
                img2.setImageResource(imgArray[arr1]);
                if(arr > arr1){
                    user1 +=1;
                }else if(arr < arr1){
                    user2 +=1;
                }else{
                    Toast.makeText(MainActivity.this, "무승부!", Toast.LENGTH_SHORT).show();
                }
                tv_user1.setText(Integer.toString(user1));
                tv_user2.setText(Integer.toString(user2));



            }
        });


    }
}