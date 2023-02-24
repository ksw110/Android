package com.example.app0209;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DirectHolder extends RecyclerView.ViewHolder {
    // 재사용할 View (TextView *2개 Button 한개) 저장하는 용도
    // - 상위클래스에 생성자가 설계되어 있다면 하위클래스는 반드시 생성자 구현해야함!

    TextView tv_title;
    TextView tv_address;
    Button btn_go;
    public DirectHolder(@NonNull View itemView) {
        super(itemView); // 상위클래스의 생성자를 호춯하는 명령! 반드시 생성자 첫째줄!!

        tv_title = itemView.findViewById(R.id.tv_title);
        tv_address = itemView.findViewById(R.id.tv_address);
        btn_go = itemView.findViewById(R.id.btn_go);




    }
}
