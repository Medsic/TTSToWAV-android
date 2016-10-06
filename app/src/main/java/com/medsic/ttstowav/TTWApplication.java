package com.medsic.ttstowav;

import android.app.Application;

import com.medsic.ttstowav.model.TTSManager;

/**
 * Created by romaintempo on 06/10/2016.
 */

public class TTWApplication extends Application {
    private static TTWApplication app;
    private TTSManager ttsManager;


    @Override
    public void onCreate() {
        app = this;
        ttsManager = new TTSManager(this);
        super.onCreate();
    }

    public static TTWApplication app() {
        return app;
    }

    public TTSManager getTtsManager() {
        return ttsManager;
    }
}
