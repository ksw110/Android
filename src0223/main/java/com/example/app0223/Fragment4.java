package com.example.app0223;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class Fragment4 extends Fragment {
    Button btn_1 , btn_2;
    TextView tv_1, tv_2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // java 랑 짝지어진 xml 파일을 view객체(Inflate해서)로 만들어서 리턴~
        View view = inflater.inflate(R.layout.fragment_4, container, false);

        tv_1 = view.findViewById(R.id.tv_1);
        tv_2 = view.findViewById(R.id.tv_2);
        btn_1 = view.findViewById(R.id.btn_1);
        btn_2 = view.findViewById(R.id.btn_2);

        // 1. 1~30까지 숫자를 세느 Thread를 설계 (클래스로) - 설계는 1개
        // 2. 버튼 눌렀을 때 Thread 객체를 생성하고 start! - 생성은 2개
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Thread 객체생성
                TimeThread thread = new TimeThread(tv_1);
                thread.start();
            }
        });



        return view;
    }

    Handler handler = new Handler(){
        // handler에 메세지 보낼 때는 sendMessage 메소드
        // 받은 메세지 처리할 때는 handlerMessage 에서 처리

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

            // 매개변수 Message 객체는 Thread 에서 보내준 메세지 그대로~
            // 받아온 Message 객체에서 TextView랑 i 값 꺼내서 setText 해보기~

            int i = msg.arg1;
            TextView tv = (TextView) msg.obj;
            tv.setText(i+"");




        }
    };

    class TimeThread extends Thread{

        // Thread 메소드 실행 순서 (Life Cycle)
        // start -> run -> destroy

        private TextView tv;

        public  TimeThread(TextView tv){
            this.tv = tv;
        }
        @Override
        public void run() {

            for(int i = 1; i <= 30 ; i++){

                // 개발자가 설계한 Thread 에서는 UI 작업(setText, setImageResource 등등) 못함
                // Handler에게 요청(Message를 보낸다) 해서 MainThread로 작업을 전달

                Message msg = new Message();
                // 예전에 배웠던 ViewHoler랑 비슷, 데이터를 담는 역할만 함!
                // Object 타입 객체 1개, int타입 변수 2개(arg1, arg2)
                // 그렇다면! 지금 이 예제에서 Handler 한테 보내줘야할 데이터는?
                // - 숫자를 적어야하는 TextView, 적힐 숫자 (i)
                msg.obj =tv;
                msg.arg1 = i;

                handler.sendMessage(msg); // 위에서 구성한 msg 객체 보내기~
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

}