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

public class ThirdFragment extends Fragment {
    //this class includes the functionality of fragment_third.xml
    //it is the first page after clicking plant diagnosis and it asks the user for the type of plant
    //that they are diagnosing

    private Spinner selectDropdown;
    public static String typeSelection; //stores type selection

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState

    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //this is the implementation for the back button, takes us to the second fragment
        view.findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ThirdFragment.this)
                        .navigate(R.id.action_ThirdFragment_to_SecondFragment);
        }
        });
        //clicking "next" saves selection and takes us to next fragment
        view.findViewById(R.id.firstNext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAnswer(view);
                NavHostFragment.findNavController(ThirdFragment.this).navigate((R.id.action_ThirdFragment_to_ThirdFragment2));
            }
        });

       //populates the spinner with the plant type selections
        selectDropdown = getView().findViewById(R.id.selectDropdown);
        List<String> firstQuestion = new ArrayList<>();
        Collections.addAll(firstQuestion, MainActivity.plantTypes);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, firstQuestion);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectDropdown.setAdapter(adapter);

    }

    //this method saves the current selection in the dropdown menu and stores it in a global variable
    public void getAnswer(View v){
        typeSelection = (String) selectDropdown.getSelectedItem();
    }

}