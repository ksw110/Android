package com.psy.app0210;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {


    ArrayList<kakaoVO> kakaoVOS = new ArrayList<>();



    RecyclerView rv;
    Button btn_send;
    EditText text;

    // FireBase 객체 생성
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    // DataBase 경로 가져오기
    DatabaseReference myRef = database.getReference("message");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kakaoVOS.add(new kakaoVO(R.drawable.aa,"장서연","야~~조앵~~~~~~","오전 11:17"));
        kakaoVOS.add(new kakaoVO(R.drawable.bb,"임소완","공쥬다 공쥬!@ 공쥬다~!~!~!~!","오전 11:18"));
        kakaoVOS.add(new kakaoVO(R.drawable.cc,"조연경","배불러 ㅜㅜㅜ","오전 11:19"));
        kakaoVOS.add(new kakaoVO(R.drawable.dd,"박서연","시끄러!@!@!@","오전 11:20"));
        kakaoVOS.add(new kakaoVO(R.drawable.ee,"박유정","(지는즁)","오전 11:21"));


        rv = findViewById(R.id.RV);
        btn_send = findViewById(R.id.btn_send);
        text = findViewById(R.id.text);



        kakaoAdapter adapter = new kakaoAdapter(kakaoVOS, getApplicationContext());
        rv.setAdapter(adapter);

        rv.setLayoutManager(new LinearLayoutManager(this));

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//              현재시간 출력
//              Date today = new Date();
//              SimpleDateFormat time = new SimpleDateFormat("hh:mm a");

                long now = System.currentTimeMillis();
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a"); //날짜 형식지정

                int random = (int)(Math.random() * kakaoVOS.size()+1);

                myRef.push().setValue(new kakaoVO(R.drawable.dd,
                        kakaoVOS.get(random).getTv_name(),text.getText().toString(),sdf.format(now)));
                text.setText(null);
            }
        });

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                // 데이터 추가
                kakaoVO kakao = snapshot.getValue(kakaoVO.class);
                // !@ VO에 디폴트 생성자(매개변수가 없는 생성자)가 있어야 함
                // !@ setter 반드시 있어야 함 !@

                //arrayList에 담고
                kakaoVOS.add(kakao);

                //adapter 새로고침
                adapter.notifyDataSetChanged();
                rv.smoothScrollToPosition(adapter.getItemCount()-1);

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                // 수정됐을 때
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                // 지워졌을 때
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                //이동했을 때
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // 변경을 감지하다가 무언가 문제가 발생했을 때
                // Exception 처럼
            }
        });

    }
}