package com.example.chapter_2.recyclerview;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.chapter_2.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecyclerViewAnimatorActivity extends AppCompatActivity {

    private RecyclerView mListView;
    private ListAnimatorAdapter mAdapter;
    private List<Data> list = new ArrayList<>();

    private Button mAddButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_animator_view);
        mListView = findViewById(R.id.rl_list);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mListView.setLayoutManager(linearLayoutManager);
        mAdapter = new ListAnimatorAdapter();
        mListView.setAdapter(mAdapter);
        for (int i = 0; i < 10; ++ i) {
            Data data = new Data(i + "");
            list.add(data);
        }
        mAdapter.setDataList(list);
        mAdapter.notifyDataSetChanged();
        mListView.post(new Runnable() {
            @Override public void run() {
                int first = linearLayoutManager.findFirstVisibleItemPosition();
                int last = linearLayoutManager.findLastVisibleItemPosition();
                for (int i = first; i < last + 1; ++ i) {
                    ListAnimatorViewHolder holder = (ListAnimatorViewHolder) mListView.findViewHolderForLayoutPosition(i);
                    holder.startAnimator(i);
                }
            }
        });
        mListView.animate().alpha(1).setDuration(5000).start();
        mAddButton = findViewById(R.id.bt_add);
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                insert(new Data(""), list.size());
            }
        });
    }

    public void insert(Data data, int index) {
        mAdapter.insert(data, index);
        mAdapter.notifyItemInserted(index);
    }

    public void insertRange(List<Data> list, int startIndex) {
        mAdapter.insertRange(list, startIndex);
        mAdapter.notifyItemRangeInserted(startIndex, list.size());
    }

    public void delete(int index) {
        mAdapter.delete(index);
        mAdapter.notifyItemRemoved(index);
    }

    public void deleteRange(int index, int count) {
        mAdapter.deleteRange(index, count);
        mAdapter.notifyItemRangeRemoved(index, count);
    }

    public void change(Data data, int index) {
        mAdapter.change(data, index);
        mAdapter.notifyItemChanged(index);
    }
}
