package com.example.chapter_2.intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chapter_2.R;
import com.example.chapter_2.intent.ui.login.LoginActivity;

public class ResultActivity extends AppCompatActivity {

    TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        findViewById(R.id.bt_login).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent i = new Intent(ResultActivity.this, LoginActivity.class);
                startActivityForResult(i, 0);
            }
        });
        mText = findViewById(R.id.tv_result);
    }

    @Override protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == ResultActivity.RESULT_OK) {
            updateUiWithUser("welcome " + data.getStringExtra("userName"));
        } else if (resultCode == ResultActivity.RESULT_CANCELED) {

        }
    }

    private void updateUiWithUser(String s) {
        // TODO : initiate successful logged in experience
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
        mText.setText(s);
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), "login error", Toast.LENGTH_SHORT).show();
    }
}
