package com.example.app0223;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Fragment1 extends Fragment {


    ImageView[] dodos = new ImageView[9];
    DoThread[] thread = new DoThread[9];
    int cnt = 0;
    TextView tv_score, tv_time;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        tv_score = view.findViewById(R.id.tv_score);
        tv_time = view.findViewById(R.id.tv_time);
        TimeThread1 thread1 = new TimeThread1(tv_time);
        thread1.start();


        // 두더지 imageView 9 개 findViewById
        for(int i = 0 ; i < dodos.length; i++){
            int imgID = getResources().getIdentifier
                    ("imageView"+(i+1),"id",getContext().getPackageName());
                                                // getContext() = Fragment 라서 넣어줘야함
            dodos[i] = view.findViewById(imgID);
            dodos[i].setTag("0");

            thread[i] = new DoThread(dodos[i]);
            thread[i].start();

            dodos[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(v.getTag().toString().equals("1")){
                        Toast.makeText(getContext(),"잡았다!",Toast.LENGTH_SHORT).show();
                        view.setTag("0");
                        cnt +=1;


                    }else{
                        Toast.makeText(getContext(), "못 잡았다!", Toast.LENGTH_SHORT).show();
                        cnt -=1;
                    }tv_score.setText(cnt+"");
                }
            });


        }





        return view;
    }




    Handler handler = new Handler(){

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

            ImageView img = (ImageView)msg.obj;
            img.setImageResource(msg.arg1);
            img.setTag(msg.arg2+"");

        }
    };

    class DoThread extends Thread{

        private ImageView dodo; // 이 쓰레드 담당 두더지

        public DoThread(ImageView dodo){
            this.dodo = dodo;
        }


        @Override
        public void run() {

            while (true){
                // 랜덤 시간만큼 내려간 상태 유지
                int offTime = new Random().nextInt(1000)+500; // 0.5~ 5.5)

                try {
                    Thread.sleep(offTime);

                    Message msg = new Message();
                    msg.obj = dodo;
                    msg.arg1 = R.drawable.on1;
                    msg.arg2 = 1;
                    // 핸들러한테 보내줄거임
                    handler.sendMessage(msg);

                    int onTime = new Random().nextInt(1000)+500; //0.5~1.5
                    Thread.sleep(onTime);
                    // 한번 보낸 Message 객체는 재활용 X
                    Message msg2 = new Message();
                    msg2.obj = dodo;
                    msg2.arg1 = R.drawable.off1;
                    msg2.arg2 = 0;
                    handler.sendMessage(msg2);




                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


            }

        }

    }
    Handler handler1 = new Handler(){
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

    class TimeThread1 extends Thread{

        // Thread 메소드 실행 순서 (Life Cycle)
        // start -> run -> destroy

        private TextView tv;

        public  TimeThread1(TextView tv){
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

                handler1.sendMessage(msg); // 위에서 구성한 msg 객체 보내기~
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }}


}