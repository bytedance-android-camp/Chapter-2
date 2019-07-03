package com.example.chapter_2.lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.chapter_2.R;

public class LifecycleActivity extends AppCompatActivity {

    private static final String TAG = "LifecycleActivity";
    private EditText mEditText;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle2);
        mEditText = findViewById(R.id.et_lifecycle);
        mButton = findViewById(R.id.bt_lifecycle);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                mEditText.setVisibility(View.GONE);

            }
        });
        Log.i(TAG, "onCreate ");
    }

    @Override protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
//        outState.putBoolean("visible", mEditText.getVisibility() == View.VISIBLE);
    }

    @Override protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState");
        boolean visible = savedInstanceState.getBoolean("visible");
//        mEditText.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    @Override protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }

    @Override protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }
}
