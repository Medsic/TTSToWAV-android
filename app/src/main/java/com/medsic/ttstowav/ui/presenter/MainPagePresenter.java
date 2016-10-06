package com.medsic.ttstowav.ui.presenter;

import com.medsic.ttstowav.TTWApplication;
import com.medsic.ttstowav.ui.view.MainPageView;

/**
 * Created by romaintempo on 06/10/2016.
 */

public class MainPagePresenter {
    private TTWApplication app;
    private MainPageView mainPageView;

    public MainPagePresenter(MainPageView mainPageView) {
        this.mainPageView = mainPageView;
        app = TTWApplication.app();
    }

    public void saveNewPitchValue(int progress) {
        app.getTtsManager().setPitch((float) progress / 100);
    }

    public void saveNewSpeechrateValue(int progress) {
        app.getTtsManager().setSpeechRate((float) progress / 100);
    }

    public void testSpeech(String text) {
        app.getTtsManager().speak(text);
    }

    public void recordSpeech(String text) {
        //todo record speech method in presenter
    }
}
