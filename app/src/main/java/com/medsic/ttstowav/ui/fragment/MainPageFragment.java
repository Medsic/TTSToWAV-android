package com.medsic.ttstowav.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
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

        pitchSeekbar.setProgress(1);
        pitchSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pitchValueText.setText(Integer.toString(progress));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                presenter.saveNewPitchValue(pitchSeekbar.getProgress());
            }
        });

        speechRateSeekbar.setProgress(1);
        speechRateSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                speechRateValueText.setText(Integer.toString(progress));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                presenter.saveNewSpeechrateValue(speechRateSeekbar.getProgress());
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_page, container, false);
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
