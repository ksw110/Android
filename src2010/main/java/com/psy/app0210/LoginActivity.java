package com.psy.app0210;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class LoginActivity extends AppCompatActivity {

    EditText edtEmail;
    EditText edtPw;
    ImageView img_join;
    Button btn_login;

    //데이터 전송 통로
    RequestQueue stream;

    // 전송정보 담는 Request 객체
    StringRequest stringRequest;

    // 규칙!@ 통로 생성하고 StringRequest에다가 전송정보 채워주고 통로(Queue) 쏴주면 됨


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        img_join = findViewById(R.id.img_join);
        edtEmail = findViewById(R.id.edtEmail);
        edtPw = findViewById(R.id.edtPw);
        btn_login = findViewById(R.id.btnLogin);

        //통로생성
        stream= Volley.newRequestQueue(getApplicationContext());

        // StringRequest 정보 채우기(전송방식 - get/post, 서버 url, 응답받았을 때 처리할 Listener, 에러났을 때 Listener)
        String url = "http://211.227.224.143:8081/Server/JoinServlet";
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.equals("1")){
                    Toast.makeText(getApplicationContext(), "회원가입성공", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "회원가입실패", Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                // 내가 보내고 싶은 데이터 Key, Value 형태(Map) 로 셋팅!
                HashMap<String, String> data = new HashMap<String, String>();
                // HashMap 은 Map을 상속받아 구현된 클래스! Map이랑 똑같음~~
                // Map은 인터페이스라서 객체생성 불가능!
                data.put("id", edtEmail.getText().toString());
                data.put("pw", edtPw.getText().toString());

                return data;
            }
        };

        img_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stream.add(stringRequest);

            }
        });
    }
}