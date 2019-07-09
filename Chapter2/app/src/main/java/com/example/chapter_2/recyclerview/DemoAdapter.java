package com.example.chapter_2.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chapter_2.R;

import java.util.List;

/**
 * author : neo
 * time   : 2019/07/09
 * desc   :
 */
public class DemoAdapter extends RecyclerView.Adapter {

    private List<Data> mList;

    @NonNull @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View root = LayoutInflater.from(viewGroup.getContext()).
                        inflate(R.layout.layout_item_data, viewGroup, false);
        return new DemoViewHolder(root);
    }

    @Override public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        ((DemoViewHolder)viewHolder).bind(mList.get(position));
    }

    @Override public int getItemCount() {
        return mList.size();
    }

    public void setData(List<Data> list) {
        mList = list;
    }
}
