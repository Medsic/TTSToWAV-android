package com.medsic.ttstowav.model;

import android.content.Context;
import android.speech.tts.TextToSpeech;

import java.util.Locale;

/**
 * Created by romaintempo on 06/10/2016.
 */

public class TTSManager {
    private TextToSpeech tts;

    public TTSManager(Context ctx) {
        tts = new TextToSpeech(ctx, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.US);
                }
            }
        });
    }

    public  void speak(String text) {
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "text to speech");
    }
}
