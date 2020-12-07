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
    //this class includes the functionality of fragment_third2.xml
    //it is the second page of the plant diagnosis feature and it asks the user for the species of plant
    //that they are diagnosing

    private Spinner selectDropdown2;
    public static String speciesSelection; //stores species selection
    public static List<Plant> checkWhich = new ArrayList<>(); //stores database plant data to get later ID from selection
    public static String selectedID; //stores the ID of the plant selected
    public static Plant selection; //stores the selected plant object

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

        //back button functionality
        view.findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ThirdFragment2.this)
                        .navigate(R.id.action_ThirdFragment2_to_ThirdFragment);
            }
        });

        //implementation for the next button, which saves the species selection by running the getAnswer
        //function and takes us to next fragment
        view.findViewById(R.id.firstNext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAnswer(view);
                NavHostFragment.findNavController(ThirdFragment2.this).navigate((R.id.action_ThirdFragment2_to_fourthfrag));
            }
        });

        selectDropdown2 = getView().findViewById(R.id.selectDropdown2);

        //if statements checks which plant type user selected and then runs the FirebaseDatabaseHelper
        //method to extract the plants that match that type in our database
        if(ThirdFragment.typeSelection.equals("Succulents")){
            new FirebaseDatabaseHelper().readSucculents(new FirebaseDatabaseHelper.DataStatus() {
                @Override
                public void PlantDataIsLoaded(List<Plant> plants, List<String> keys) {
                    List<String> selections = new ArrayList<>();
                    checkWhich = plants;
                    for(int i=0; i<plants.size(); i++){
                        selections.add(plants.get(i).getSpecies());
                    }
                    //populates the spinner with the string species of the succulent plant entries
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

        //exact functionality as the if statement above
        else if(ThirdFragment.typeSelection.equals("House Plants")){
            new FirebaseDatabaseHelper().readHousePlants(new FirebaseDatabaseHelper.DataStatus() {
                @Override
                public void PlantDataIsLoaded(List<Plant> plants, List<String> keys) {
                    List<String> selections = new ArrayList<>();
                    checkWhich = plants;
                    for(int i=0; i<plants.size(); i++){
                        selections.add(plants.get(i).getSpecies());
                    }
                    //same functionality as the previous statement
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

    //function that extracts the currently selected dropdown entry and saves the selection in a global variable
    public void getAnswer(View v){
        speciesSelection = (String) selectDropdown2.getSelectedItem();
        for(int i=0;i<checkWhich.size();i++){
            if(checkWhich.get(i).getSpecies().equals(speciesSelection)){
                selection = checkWhich.get(i);
                selectedID = checkWhich.get(i).getID();
            }
        }
    }
}