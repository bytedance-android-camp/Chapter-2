package com.example.chapter_2.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.chapter_2.R;

/**
 * author : neo
 * time   : 2019/07/09
 * desc   :
 */
public class DemoViewHolder extends RecyclerView.ViewHolder {

    TextView mTextView;

    public DemoViewHolder(@NonNull View itemView) {
        super(itemView);
        mTextView = itemView.findViewById(R.id.tv_data);
    }

    public void bind(Data data) {
        mTextView.setText(data.getInfo());
    }
}
