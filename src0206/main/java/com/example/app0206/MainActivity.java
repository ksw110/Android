package com.example.app0206;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    // 배열, ArrayList => 순서가 없는 값에 순서 부여!
    // 배열 => 개발자가 크기를 정해두고 변동(사용자)이 없을 때!
    // ArrayList => 가변배열, 사용자가 데이터를 개수를 바꿔야 할 때

    // 직접 해보기 ! Button 을 저장할 수 있는 배열 25칸 생성!

    Button[] buttons = new Button[25];
    // button에 적힐 숫자 25개 미리 셋팅
    int[] ranNums = new int[25];
    int clickCnt = 1;
    Chronometer chronometer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Activity 실행 시 최초 딱 한번만 실행!!
        super.onCreate(savedInstanceState);
        // 상위 클래스의 onCreate 호출해서 Activity 실행 준비 환료!
        // => 정확한 내용은 알 필요 없음...!!
        setContentView(R.layout.activity_main);
        // xml-java 연결

        chronometer = findViewById(R.id.tv_time);
        chronometer.start();

        // findViewById를 할 때 setContentView 한 xml에서 찾아옴
        // => 다른 xml에서 id 중복사용 o
        // => setContentView 하기 전에 findViewById 가능?

        // 3. 셋팅 다 해놓고 섞기
        // - 1~25까지 ranNum에 저장하고 시장
        for(int i = 0; i< ranNums.length; i++){
            ranNums[i] = i+1;
        }

        for(int loop = 0 ; loop <= 100; loop++){ // 100번 섞기
            int index1 = new Random().nextInt(ranNums.length);
            int index2 = new Random().nextInt(ranNums.length);

            if(index1 != index2){
                int temp = ranNums[index1];
                ranNums[index1] = ranNums[index2];
                ranNums[index2] = temp;
            }
        }





        // button 25개 findViewById 해야함
        // 배열의 0번부터 24번까지 1칸씩
        for(int i = 0 ; i < buttons.length ; i++){
            // String인 id로 "button1" => int형 id = 1000006 변환하는 기능
            int btnId = getResources().getIdentifier("button"+(i+1),
                    "id",getPackageName());

            buttons[i] = findViewById(btnId);
            buttons[i].setBackgroundColor(Color.parseColor("#B2CCFF"));
            buttons[i].setText(ranNums[i]+"");

            buttons[i].setOnClickListener(new View.OnClickListener() {
                // 1. setOnclickListener 메소드에 onClickLister 객체 넣어줘야함
                // 2. 그래서 new View(경로).OnClickLister 라고 적어준것임
                // 3. 그런데!! OCL는 인터페이서(only 추상메소드).... 객체생성이 안됨..!!
                // 4. 하지만 !!! 객체생성과 동시에{} 안에 추상메소드 오버라이딩하면 가능~!
                @Override
                public void onClick(View view) {



                    // - onClick 메소드의 매개변수가 View 타입인 이유?
                    // - View를 상속받고 있는 그 어떠한 것이라도
                    //      (Button, TextView 등등...) onClick 메소드로 퉁칠려고!
                    // -> 향후에 다른 View들이 추시되어도 onClick은 고칠필요가 없음!

                    if(((Button)view).getText().equals(clickCnt+"")){

                        view.setVisibility(View.INVISIBLE);
                        clickCnt ++;
                    }
                    if(((Button)view).getText().equals("25")){
                        chronometer.stop();}

                }
            });

        }

//        // 1. 랜덤 수 중복없이 이중 for문으로로
//        for(int i = 0; i < ranNums.length;i++){
//            ranNums[i] = new Random().nextInt(25)+1;
//            for(int j = 0; j < i; j++){
//                if(ranNums[i] == ranNums[j]){
//                    i--;
                     //   break; // 가장 가까운
//                }
//            }
//        }
//
//        // 2. ArrayList 사용하기
//
//        // -card 셋팅하기
//        ArrayList<Integer> cards = new ArrayList<>();
//        for(int num = 1 ; num <= 25; num++){
//            cards.add(num);
//        } // cards에 1~25까지 숫자 저장
//
//        for(int i = 0; i < ranNums.length ; i++){ // ranNum에 카드 한개씩 저장
//            int cardIndex = new Random().nextInt(cards.size());// 남아있는 카드중 하나
//            ranNums[i] = cards.get(cardIndex);
//            cards.remove(cardIndex);
//        }
//
//        // 3. 셋팅 다 해놓고 섞기
//        // - 1~25까지 ranNum에 저장하고 시장
//        for(int i = 0; i< ranNums.length; i++){
//            ranNums[i] = i+1;
//        }
//
//        for(int loop = 0 ; loop <= 100; loop++){ // 100번 섞기
//            int index1 = new Random().nextInt(ranNums.length);
//            int index2 = new Random().nextInt(ranNums.length);
//
//            if(index1 != index2){
//                int temp = ranNums[index1];
//                ranNums[index1] = ranNums[index2];
//                ranNums[index2] = temp;
//            }
//        }


    }
}