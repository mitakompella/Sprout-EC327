package com.example.sprout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.fragment.NavHostFragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class fifth_fragment extends Fragment {
    TextView Title;
    TextView Detailed;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState

    )
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fifth_fragment, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        Title = (TextView)getView().findViewById(R.id.title);
        Detailed = (TextView)getView().findViewById(R.id.detailed);
        if(ThirdFragment3.sympSelection==null){
            Title.setText("#Plant parent goals!");
            Detailed.setText("You’re doing a great job and your plant loves you and its home! Keep up the great work.");
        }
        else {
            Title.setText(ThirdFragment3.sympSelection.getTitle());
            Detailed.setText(ThirdFragment3.sympSelection.getDetailed());
        }
        view.findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(fifth_fragment.this)
                        .navigate(R.id.action_fifth_to_ThirdFragment3);
            }
        });
        //clicking "next" saves selection and takes us to next fragment
        //uncomment when results page is working
        view.findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(fifth_fragment.this).navigate((R.id.action_Fifth_to_SecondFragment));
            }
        });
    }


}