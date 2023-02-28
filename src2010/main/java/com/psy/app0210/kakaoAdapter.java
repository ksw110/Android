package com.psy.app0210;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class kakaoAdapter extends RecyclerView.Adapter<kakaoHolder> {

    private ArrayList<kakaoVO> datas;
    private Context context;

    public kakaoAdapter(ArrayList<kakaoVO> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @NonNull
    @Override
    public kakaoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new kakaoHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.template,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull kakaoHolder holder, int position) {

        holder.tv_profile.setImageResource(datas.get(position).getTv_profile());
        holder.tv_name.setText(datas.get(position).getTv_name());
        holder.tv_content.setText(datas.get(position).getTv_content());
        holder.tv_time.setText(datas.get(position).getTv_time());

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
}
