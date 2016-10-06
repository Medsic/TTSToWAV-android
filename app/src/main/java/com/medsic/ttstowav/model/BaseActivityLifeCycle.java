package com.medsic.ttstowav.model;

/**
 * Created by romaintempo on 06/10/2016.
 */

public interface BaseActivityLifeCycle {
    void onStart();
    void onPause();
    void onResume();
    void onDestroy();
}
