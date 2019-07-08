package com.example.chapter_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.chapter_2.intent.ResultActivity;
import com.example.chapter_2.lifecycle.LifecycleActivity;
import com.example.chapter_2.recyclerview.RecyclerViewActivity;
import com.example.chapter_2.view.LinearLayoutActivity;
import com.example.chapter_2.view.RelativeLayoutActivity;
import com.example.chapter_2.view.ViewActivity;

public class MainActivity extends AppCompatActivity {

    Button mRlButton, mResultButton, mImplicitButton, mViewButton, mLinearLayoutButton, mRelativeLayoutManager, mLifecycleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLifecycleButton = findViewById(R.id.bt_lifecycle);
        mLifecycleButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LifecycleActivity.class);
                startActivity(intent);
            }
        });
        mResultButton = findViewById(R.id.bt_result);
        mResultButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                startActivity(intent);
            }
        });
        mImplicitButton = findViewById(R.id.bt_implicit);
        mImplicitButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("neo");
                startActivity(intent);
            }
        });
        mViewButton = findViewById(R.id.bt_view);
        mViewButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewActivity.class);
                startActivity(intent);
            }
        });
        mLinearLayoutButton = findViewById(R.id.bt_linear_layout);
        mLinearLayoutButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LinearLayoutActivity.class);
                startActivity(intent);
            }
        });

        mRelativeLayoutManager = findViewById(R.id.bt_relative_layout);
        mRelativeLayoutManager.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RelativeLayoutActivity.class);
                startActivity(intent);
            }
        });
        mRlButton = findViewById(R.id.bt_rl);
        mRlButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                startActivity(intent);
            }
        });
    }
}
