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

public class ThirdFragment2 extends Fragment {

    private Spinner selectDropdown2;
    public static String speciesSelection; //stores type selection
    public static List<Plant> checkWhich = new ArrayList<>(); //stores houseplant data to get ID from selection
    public static String selectedID;

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
                NavHostFragment.findNavController(ThirdFragment2.this)
                        .navigate(R.id.action_ThirdFragment2_to_ThirdFragment);

            }
        });
        //clicking "next" saves selection and takes us to next fragment
        view.findViewById(R.id.firstNext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAnswer(view);
                NavHostFragment.findNavController(ThirdFragment2.this).navigate((R.id.action_ThirdFragment2_to_ThirdFragment3));
            }
        });
        //display species list
        selectDropdown2 = getView().findViewById(R.id.selectDropdown2);

        if(ThirdFragment.typeSelection.equals("Succulents")){
            new FirebaseDatabaseHelper().readSucculents(new FirebaseDatabaseHelper.DataStatus() {
                @Override
                public void PlantDataIsLoaded(List<Plant> plants, List<String> keys) {
                    List<String> selections = new ArrayList<>();
                    for(int i=0; i<plants.size(); i++){
                        selections.add(plants.get(i).getSpecies());
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, selections);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    selectDropdown2.setAdapter(adapter);
                }

                @Override
                public void SympDataIsLoaded(List<Symptoms> thesymptoms, List<String> keys) { }

                @Override
                public void DataIsInserted() { }

                @Override
                public void DataIsUpdated() { }

                @Override
                public void DataIsDeleted() { }
            });
        }
           else if(ThirdFragment.typeSelection.equals("House Plants")){
            //run readHouseplants from FirebaseHelper
            new FirebaseDatabaseHelper().readHousePlants(new FirebaseDatabaseHelper.DataStatus() {
                @Override
                public void PlantDataIsLoaded(List<Plant> plants, List<String> keys) {
                    List<String> selections = new ArrayList<>();
                    checkWhich = plants;
                    for(int i=0; i<plants.size(); i++){
                        selections.add(plants.get(i).getSpecies());
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, selections);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    selectDropdown2.setAdapter(adapter);
                }

                @Override
                public void SympDataIsLoaded(List<Symptoms> thesymptoms, List<String> keys) { }

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
        speciesSelection = (String) selectDropdown2.getSelectedItem();
        for(int i=0;i<checkWhich.size();i++){
            if(checkWhich.get(i).getSpecies().equals(speciesSelection)){
                selectedID = checkWhich.get(i).getID();
            }
        }
    }
}