package com.example.sprout;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;


public class fragment_fourth extends Fragment {

    private Button submit_button;
    private SeekBar seek_bar_sun;
    private SeekBar seek_bar_temp;
    private SeekBar seek_bar_water;
    private TextView sun_res;
    private TextView temp_res;
    private TextView water_res;
    private int count = 0;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState

    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        submit_button = (Button) getView().findViewById(R.id.submit_button);
        seek_bar_sun = (SeekBar) getView().findViewById(R.id.sunSeekBar);
        seek_bar_temp = (SeekBar) getView().findViewById(R.id.tempSeekBar);
        seek_bar_water = (SeekBar) getView().findViewById(R.id.waterSeekBar);
        sun_res = (TextView) getView().findViewById(R.id.sun_results);
        temp_res = (TextView) getView().findViewById(R.id.temp_results);
        water_res = (TextView) getView().findViewById(R.id.water_results);
        final int[] values = new int[3];

        //back button
        view.findViewById(R.id.back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(fragment_fourth.this)
                        .navigate(R.id.action_fragment4_to_ThirdFragment3);
            }
        });

        //submit and next button
        view.findViewById(R.id.submit_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count==0) {
                    sun_res.setText(new CompareCare().CompareSun(values[0], ThirdFragment2.selection.getSun()));
                    water_res.setText(new CompareCare().CompareWater(values[2], ThirdFragment2.selection.getWater()));
                    temp_res.setText(new CompareCare().CompareTemp(values[1], ThirdFragment2.selection.getTemp()));
                    submit_button.setText("Next");
                    count=1;
                }
                else if(count==1){
                    NavHostFragment.findNavController(fragment_fourth.this)
                            .navigate(R.id.action_fragment4_to_ThirdFragment3);
                    submit_button.setText("Submit");
                    count=0;
                }
            }
        });

        seek_bar_sun.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                values[0] = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        seek_bar_temp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                values[1] = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        seek_bar_water.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                values[2] = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
}



