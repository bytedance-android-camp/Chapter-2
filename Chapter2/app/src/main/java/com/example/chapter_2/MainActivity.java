package com.example.chapter_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.chapter_2.lifecycle.LifecycleActivity;

public class MainActivity extends AppCompatActivity {

    Button mRlButton, mLifecycleButton;

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
    }
}
