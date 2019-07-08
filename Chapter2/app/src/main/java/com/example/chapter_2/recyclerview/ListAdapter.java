package com.example.chapter_2.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * author : neo
 * time   : 2019/06/18
 * desc   :
 */
public class ListAdapter extends RecyclerView.Adapter {

    public static final int TYPE_TEXT = 0;
    public static final int TYPE_IMAGE = 1;

    private List<Data> mDataList = new ArrayList<>();

    @NonNull @Override public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if (viewType == TYPE_IMAGE) {
            return ListImageViewHolder.create(viewGroup.getContext(), viewGroup);
        } else {
            return ListTextViewHolder.create(viewGroup.getContext(), viewGroup);
        }
    }

    @Override public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        int type = getItemViewType(position);
        if (type == TYPE_TEXT) {
            ((ListTextViewHolder) viewHolder).bind(mDataList.get(position));
        } else if (type == TYPE_IMAGE) {
            ((ListImageViewHolder) viewHolder).bind(mDataList.get(position));
        }
    }

    public void setDataList(List<Data> list) {
        if (!checkListNonNull(list)) {
            return;
        }
        mDataList = list;
    }

    @Override public int getItemCount() {
        return mDataList.size();
    }

    @Override public int getItemViewType(int position) {
        if (TextUtils.equals(mDataList.get(position).getInfo(), "Paris")) {
            return TYPE_IMAGE;
        }
        return TYPE_TEXT;
    }

    private boolean checkListNonNull(List<Data> list) {
        return list != null && list.size() != 0;
    }

    public void insert(Data data, int index) {
        if (data == null || index < 0 || index > mDataList.size()) return;
        mDataList.add(index, data);
    }

//    public void insertRange(List<Data> list, int index) {
//        if (list == null || list.size() == 0 || index < 0 || index > mDataList.size()) return;
//        mDataList.addAll(index, list);
//    }
//
//    public void delete(int index) {
//        if (index < 0 || index >= mDataList.size()) return;
//        mDataList.remove(index);
//    }
//
//    public void deleteRange(int index, int count) {
//        if (index < 0 || index >= mDataList.size()) return;
//        for (int i  = index; i < index + count; ++ i) {
//            mDataList.remove(i);
//        }
//    }
//
//    public void change(Data data, int index) {
//        if (data == null || index < 0 || index >= mDataList.size()) return;
//        mDataList.set(index, data);
//    }
}
