package com.example.app0127;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

// AppCompatActivity 2가지
// 1) appcompat
// 2) supportv7 : androidx 버전에서는 지원하지 않음
public class KaKaoLoginActivity extends AppCompatActivity
        implements View.OnClickListener{

    // View.Onclicklistener 인터페이스 : implements
    EditText edtEmail;
    EditText edtPw ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ka_kao_login);
        // 기능을 달아주는 곳

        // 1) 뷰한테 기능을 달아주려면 ID값 (뷰가 가진 고유값)을 찾아와야한다
        Button btnLogin = findViewById(R.id.btnLogin);
        // + findViewById는 setContentView 아래에 작성해야한다!
        // PlainText의 자료형은 EditText
         edtEmail = findViewById(R.id.edtEmail);
         edtPw = findViewById(R.id.edtPw);

        // Toast
        // Log : 버튼이 눌림!

        // 2) 버튼 클릭 이벤트 달아주기(클릭 감지하기)
        // 1) inner class 사용하기
        // 2) 람다식 사용하기

        // 3) 인터페이스 상속받기
        // 인터페이스를 통해서 OnClick이라는 메서드를 오버라이딩
        btnLogin.setOnClickListener(this);
        // this : 현재 Activity 모든 화면 정보 !

        // 4) 메서드를 만들어서 속성에서 달아주기

    }
    // 매개변수 : View에대한 정보를 받아와야 한다.
    // 정보: ID, 속성
    public void click(View view){

        // 클릭했을 때에 이벤트(실행시킬 코드)

        Log.v("status","클릭이 감지 되었습니다.");
        // msg의 데이터타입 : String
        // 정수형 변수를 출력하고싶다 : cast(형변환)
        // 형변환 : toString, String.valueOf
    }
    @Override
    public void onClick(View view) {
        // 어떤 뷰를 클릭했는지 구분이 필요!
        // : View의 ID

        // int : ==
        if(view.getId() == R.id.btnLogin){
            // 실행코드
            Log.v("status","인터페이스로 클릭 구현");

            // 이메일과 비밀번호를 임의의 데이터와 비교하는 로직을 구현하시오
            // 일치할 경우) "로그인 성공!"
            // 일치하지 않을 경우 ) "로그인 실패"
           String email = edtEmail.getText().toString();
           String pw = edtPw.getText().toString();
           if(email.equals("12345") && pw.equals("1234")){
               Log.v("Login Status","로그인성공");
           }else{
               Log.v("Login Status","로그인실패");
           }

            Log.v("유저 이메일:",email);
        }
    }


}