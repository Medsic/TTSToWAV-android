package com.medsic.ttstowav;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.medsic.ttstowav.model.TTSManager;

public class MainActivity extends AppCompatActivity {
    private TTWApplication app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        app = TTWApplication.app();
    }

    @Override
    protected void onStart() {
        super.onStart();
        app.getTtsManager().onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        app.getTtsManager().onDestroy();
    }
}
