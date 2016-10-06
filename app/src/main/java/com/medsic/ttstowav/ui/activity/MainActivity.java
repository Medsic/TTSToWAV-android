package com.medsic.ttstowav.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.medsic.ttstowav.R;
import com.medsic.ttstowav.TTWApplication;
import com.medsic.ttstowav.ui.fragment.MainPageFragment;

public class MainActivity extends AppCompatActivity {
    private TTWApplication app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        app = TTWApplication.app();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_fragment_container, new MainPageFragment())
                .commit();
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
