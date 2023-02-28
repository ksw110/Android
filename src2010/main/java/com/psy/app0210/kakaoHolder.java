package com.psy.app0210;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class kakaoHolder extends RecyclerView.ViewHolder {

    ImageView tv_profile;
    TextView tv_name;
    TextView tv_content;
    TextView tv_time;


    public kakaoHolder(@NonNull View itemView) {
        super(itemView);

        tv_profile = itemView.findViewById(R.id.tv_profile);
        tv_name = itemView.findViewById(R.id.tv_name);
        tv_content = itemView.findViewById(R.id.tv_content);
        tv_time = itemView.findViewById(R.id.tv_time);

    }
}
