package com.example.chapter_2.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chapter_2.R;

/**
 * author : neo
 * time   : 2019/06/18
 * desc   :
 */
public class ListImageViewHolder extends RecyclerView.ViewHolder {

    private TextView mTextView;
    private ImageView mImageView;

    public static ListImageViewHolder create(Context context, ViewGroup root) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_item_image_list, root, false);
        return new ListImageViewHolder(v);
    }

    public ListImageViewHolder(@NonNull View itemView) {
        super(itemView);
        mTextView = itemView.findViewById(R.id.tv_info);
        mImageView = itemView.findViewById(R.id.iv_image);
    }

    public void bind(Data data) {
        if (null == data) return;
        mTextView.setText(data.getInfo());
        mImageView.setImageResource(R.drawable.eiffel);
    }
}
