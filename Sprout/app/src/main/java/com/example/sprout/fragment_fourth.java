package com.example.sprout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_fourth#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_fourth extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    SeekBar seek_bar_sun;
    SeekBar seek_bar_temp;
    SeekBar seek_bar_water;
    TextView sun_res;
    TextView temp_res;
    TextView water_res;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_fourth() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_fourth.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_fourth newInstance(String param1, String param2) {
        fragment_fourth fragment = new fragment_fourth();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        seek_bar_sun = (SeekBar)getView().findViewById(R.id.sunSeekBar);
        seek_bar_temp = (SeekBar)getView().findViewById(R.id.tempSeekBar);
        seek_bar_water = (SeekBar)getView().findViewById(R.id.waterSeekBar);
        sun_res = (TextView)getView().findViewById(R.id.sun_results);
        temp_res = (TextView)getView().findViewById(R.id.temp_results);
        water_res = (TextView)getView().findViewById(R.id.water_results);
        final int[] values = new int[3];

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
                //where progress is the value of
                sun_res.setText(new CompareCare().CompareSun(values[0], ThirdFragment2.selection.getSun()));

            }
        });
        seek_bar_temp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                values[1] = progress;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                temp_res.setText(new CompareCare().CompareTemp(values[1], ThirdFragment2.selection.getTemp()));

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
                water_res.setText(new CompareCare().CompareTemp(values[2], ThirdFragment2.selection.getWater()));
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourth, container, false);
    }
}