package com.example.chapter_2.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.chapter_2.R;
import com.example.chapter_2.recyclerview.Data;
import com.example.chapter_2.recyclerview.ListAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mListView;
    private ListAdapter mAdapter;
    private Button mInsertButton, mInsertRangeButton, mDeleteButton, mDeleteRangeButton, mChangeButton, mChangeRangeButton;
    private List<Data> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        mListView = findViewById(R.id.rl_list);
        mListView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ListAdapter();
        mListView.setAdapter(mAdapter);
        for (int i = 0; i < 10; ++ i) {
            Data data = new Data(i + "");
            list.add(data);
        }
        mAdapter.setDataList(list);
        mAdapter.notifyDataSetChanged();
        mInsertButton = findViewById(R.id.bt_insert);
        mInsertButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Data data = new Data("insert one");
                insert(data, 5);
            }
        });
        mInsertRangeButton = findViewById(R.id.bt_insert_range);
        mInsertRangeButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Data data1 = new Data("insert one");
                Data data2 = new Data("insert two");
                Data data3 = new Data("insert three");
                insertRange(Arrays.asList(data1, data2, data3), 5);
            }
        });
        mDeleteButton = findViewById(R.id.bt_delete);
        mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                delete( 5);
            }
        });
        mDeleteRangeButton = findViewById(R.id.bt_delete_range);
        mDeleteRangeButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                deleteRange( 5, 3);
            }
        });
        mChangeButton = findViewById(R.id.bt_change);
        mChangeButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Data data = new Data("change one");
                change( data,5);
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
