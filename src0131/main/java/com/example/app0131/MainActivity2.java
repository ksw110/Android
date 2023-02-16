package com.example.app0131;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

// 버튼을 눌렀을때 유저가 입력한 값을 TextView에 출력하기
// 1. 익명클래스방식으로 이벤트 적용
// 2. 유저가 입력한 값을 가져오기! (EditText)
// 3. 가져온 값을 화면에 출력하기! (TextView)

public class MainActivity2 extends AppCompatActivity {

    TextView tv_text;
    EditText edt_text;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv_text = findViewById(R.id.tv_text);
        edt_text = findViewById(R.id.edt_text);
        btn = findViewById(R.id.btn);

        // 익명클래스로 이벤트 처리하기!
        // 독립적인 이벤트를 View에 적용할 때 사용
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast : 유저에게 알림메시지를 보여줄 때 사용
                // makeTest() : 유저에게 보여줄 메시지 생성
                // show() : 생성된 메시지를 앱 화면에 출력
                Toast.makeText(MainActivity2.this, "클릭!", Toast.LENGTH_SHORT).show();
                tv_text.setText(edt_text.getText());
                edt_text.setText("");
            }
        });

    }
}