package com.example.mrz;

import android.os.Bundle;

public class LoginActivity extends BaseActive {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fullScreen();
        setContentView(R.layout.activity_login);
    }
}
