package com.example.chapter_2.recyclerview;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chapter_2.R;

/**
 * author : neo
 * time   : 2019/06/18
 * desc   :
 */
public class ListAnimatorViewHolder extends RecyclerView.ViewHolder {

    private TextView mTextView;

    public static ListAnimatorViewHolder create(Context context, ViewGroup root) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_item_animator_list, root, false);
        return new ListAnimatorViewHolder(v);
    }

    public ListAnimatorViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void bind(Data data, int position) {
    }

    public void startAnimator(int position) {
        itemView.setTranslationY(-20);
        itemView.setAlpha(0);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(itemView, "alpha", 0, 1f).setDuration(500);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(itemView, "translationY", -20f, 0f).setDuration(500);
        animator1.setStartDelay(position * 500);
        animator1.start();
        animator2.setStartDelay(position * 500);
        animator2.start();
    }
}
