package com.medsic.ttstowav;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.medsic.ttstowav.model.TTSManager;

public class MainActivity extends AppCompatActivity {
    TTSManager ttsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ttsManager = new TTSManager(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ttsManager.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ttsManager.onDestroy();
    }
}
