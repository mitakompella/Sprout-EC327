package com.example.sprout;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.navigation.fragment.NavHostFragment;

import java.util.ArrayList;
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
        return inflater.inflate(R.layout.fragment_third3, container, false);
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
        view.findViewById(R.id.firstNext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAnswer(view);
                //NavHostFragment.findNavController(ThirdFragment3.this).navigate((R.id.action_ThirdFragment3_to_ThirdFragment));
            }
        });

        //display species list
        selectDropdown3 = getView().findViewById(R.id.selectDropdown3);

        if(ThirdFragment.typeSelection.equals("Succulents")){
            //runs readSuccSymp from FirebaseHelper
            new FirebaseDatabaseHelper().readSuccSymp(new FirebaseDatabaseHelper.DataStatus() {
                @Override
                public void SympDataIsLoaded(List<Symptoms> thesymptoms, List<String> keys) {
                    List<String> selections2 = new ArrayList<>();
                    selections2.add("Plant looks great!");
                    for(int j = 0; j<thesymptoms.size(); j++){
                        selections2.add(thesymptoms.get(j).getName());
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, selections2);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    selectDropdown3.setAdapter(adapter);
                }

                @Override
                public void PlantDataIsLoaded(List<Plant> plants, List<String> keys) { }

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
                    List<String> selections2 = new ArrayList<>();
                    selections2.add("Plant looks great!");
                    for(int i=0; i<symptoms.size(); i++){
                        if(symptoms.get(i).getID().contains(ThirdFragment2.selectedID)) {
                            selections2.add(symptoms.get(i).getName());
                        }
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, selections2);
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