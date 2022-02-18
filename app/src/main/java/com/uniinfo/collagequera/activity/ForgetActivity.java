package com.uniinfo.collagequera.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.uniinfo.collagequera.R;

public class ForgetActivity extends AppCompatActivity {

    EditText registered_mobile;
    TextView forgot_button, backToLoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        registered_mobile =findViewById(R.id.registered_mobile);
        forgot_button = findViewById(R.id.forgot_button);
        backToLoginBtn = findViewById(R.id.backToLoginBtn);

        backToLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}