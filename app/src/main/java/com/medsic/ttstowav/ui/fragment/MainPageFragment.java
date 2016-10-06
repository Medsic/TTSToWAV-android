package com.medsic.ttstowav.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.medsic.ttstowav.R;
import com.medsic.ttstowav.ui.presenter.MainPagePresenter;
import com.medsic.ttstowav.ui.view.MainPageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by romaintempo on 06/10/2016.
 */

public class MainPageFragment extends Fragment implements MainPageView {

    MainPagePresenter presenter;

    @BindView(R.id.main_edit_text) EditText textToSpeechEdit;

    @BindView(R.id.main_voice_pitch_value_text) TextView pitchValueText;
    @BindView(R.id.main_voice_speech_rate_value_text) TextView speechRateValueText;

    @BindView(R.id.main_voice_pitch_seekbar) SeekBar pitchSeekbar;
    @BindView(R.id.main_voice_speech_rate_seekbar) SeekBar speechRateSeekbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new MainPagePresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_page, container, false);
        ButterKnife.bind(this, view);

        pitchSeekbar.setProgress(100);
        pitchSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pitchValueText.setText(Float.toString((float) progress / 100));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int progress = pitchSeekbar.getProgress() == 0 ? 1 : pitchSeekbar.getProgress();
                presenter.saveNewPitchValue(progress);
            }
        });

        speechRateSeekbar.setProgress(100);
        speechRateSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                speechRateValueText.setText(Float.toString((float) progress / 100));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int progress = speechRateSeekbar.getProgress() == 0 ? 1 : speechRateSeekbar.getProgress();
                presenter.saveNewSpeechrateValue(progress);
            }
        });

        return view;
    }

    @OnClick(R.id.main_test_speech_button)
    public void testButtonClicked() {
        presenter.testSpeech(textToSpeechEdit.getText().toString());
    }

    @OnClick(R.id.main_record_speech_button)
    public void recordButtonClicked() {
        presenter.recordSpeech(textToSpeechEdit.getText().toString());
    }

}
