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

public class ThirdFragment3 extends Fragment {

    private Spinner selectDropdown3;
    public static String symptomSelection; //stores type selection

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState

    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third2, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ThirdFragment3.this)
                        .navigate(R.id.action_ThirdFragment3_to_ThirdFragment2);
            }
        });
        //clicking "next" saves selection and takes us to next fragment
        //uncomment when results page is working
      /*  view.findViewById(R.id.firstNext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAnswer(view);
                NavHostFragment.findNavController(ThirdFragment.this).navigate((R.id.action_ThirdFragment_to_ThirdFragment2));
            }
        }); */

        //display species list
        selectDropdown3 = getView().findViewById(R.id.selectDropdown3);

        if(ThirdFragment.typeSelection.equals("Succulents")){
            //runs readSuccSymp from FirebaseHelper
            new FirebaseDatabaseHelper().readSuccSymp(new FirebaseDatabaseHelper.DataStatus() {
                @Override
                public void PlantDataIsLoaded(List<Plant> plants, List<String> keys) { }

                @Override
                public void SympDataIsLoaded(List<Symptoms> symptoms, List<String> keys) {
                    List<String> selections = new ArrayList<>();
                    for(int i=0; i<symptoms.size(); i++){
                        selections.add(symptoms.get(i).getName());
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, selections);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    selectDropdown3.setAdapter(adapter);
                }

                @Override
                public void DataIsInserted() { }

                @Override
                public void DataIsUpdated() { }

                @Override
                public void DataIsDeleted() { }
            });
        }

        else if(ThirdFragment.typeSelection.equals("House Plants")){
            //run readHouseSymp from FirebaseHelper
            new FirebaseDatabaseHelper().readHouseSymp(new FirebaseDatabaseHelper.DataStatus() {
                @Override
                public void PlantDataIsLoaded(List<Plant> plants, List<String> keys) { }

                @Override
                public void SympDataIsLoaded(List<Symptoms> symptoms, List<String> keys) {
                    List<String> selections = new ArrayList<>();
                    for(int i=0; i<symptoms.size(); i++){
                        selections.add(symptoms.get(i).getName());
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, selections);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    selectDropdown3.setAdapter(adapter);
                }

                @Override
                public void DataIsInserted() { }

                @Override
                public void DataIsUpdated() { }

                @Override
                public void DataIsDeleted() { }
            });
        }
    }

    public void getAnswer(View v){
        symptomSelection = (String) selectDropdown3.getSelectedItem();
    }
}