package com.example.app0209;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DirectAdapter extends RecyclerView.Adapter<DirectHolder> {
    private ArrayList<DirectVO> datas; // RecyclerView에 뿌릴 데이터
    private Context context; // Activity 에서 보내줄 화면 정보!

    public DirectAdapter(ArrayList<DirectVO> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @NonNull
    @Override
    public DirectHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DirectHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.templete,parent,false));
        // templete 만 바꿔주면됨 xml => view로 변환해주는거
    }

    @Override
    public void onBindViewHolder(@NonNull DirectHolder holder, int position) {
        // holder => 이전에 만들어진 View들이 저장된 ViewHolder
        // position => 위치
        holder.tv_title.setText(datas.get(position).getTv_title());
        holder.tv_address.setText(datas.get(position).getTv_address());
        holder.btn_go.setOnClickListener(v -> {
            Intent it_url = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(holder.tv_address.getText().toString()));
                              // datas.get(position).getTv_address() 둘다가능
            it_url.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            // 새로운 테스크 하나 더 만들어서 실행할꺼다 어뎁터에서 할때 꼭필요함
            context.startActivity(it_url);

        });
    }

    @Override
    public int getItemCount() {
        return datas.size(); // 데이터 갯수
    }
}
