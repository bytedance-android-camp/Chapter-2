package com.example.chapter_2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.chapter_2.recyclerview.Data;
import com.example.chapter_2.recyclerview.DemoAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * author : neo
 * time   : 2019/07/09
 * desc   :
 */
public class DemoActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private DemoAdapter mDemoAdapter;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_2);
        mRecyclerView = findViewById(R.id.rv_list_2);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mDemoAdapter = new DemoAdapter();
        mRecyclerView.setAdapter(mDemoAdapter);
        List<Data> list = new ArrayList<>();
        for(int i = 0; i < 100; ++ i) {
            Data data = new Data(i + "");
            list.add(data);
        }
        mDemoAdapter.setData(list);
        mDemoAdapter.notifyDataSetChanged();
    }
}
