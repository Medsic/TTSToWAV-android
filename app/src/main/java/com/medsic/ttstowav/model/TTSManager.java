package com.medsic.ttstowav.model;

import android.content.Context;
import android.speech.tts.TextToSpeech;

import java.util.Locale;

/**
 * Created by romaintempo on 06/10/2016.
 */

public class TTSManager implements BaseActivityLifeCycle {
    private Context ctx;
    private TextToSpeech tts;

    public TTSManager(Context ctx) {
        this.ctx = ctx;
    }

    public void speak(String text) {
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "text to speech");
    }

    public void setPitch(float level) {
        tts.setPitch(level);
    }

    public void setSpeechRate(float rate) {
        tts.setSpeechRate(rate);
    }

    @Override
    public void onStart() {
        tts = new TextToSpeech(ctx, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.US);
                }
            }
        });
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {
        tts.stop();
    }
}
