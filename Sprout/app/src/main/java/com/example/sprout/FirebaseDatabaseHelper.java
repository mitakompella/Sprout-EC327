package com.example.sprout;

import android.app.Application;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper extends Application {
    private FirebaseDatabase myDatabase;
    private final DatabaseReference plantReference;
    private final DatabaseReference succReference;
    private final DatabaseReference houseplantReference;
    private final DatabaseReference succsymptomsReference;
    private final DatabaseReference houseplantsymptomsReference;
    public static List<Plant> succulents = new ArrayList<>();
    public static List<Plant> houseplants = new ArrayList<>();
    public static List<Symptoms> succsymp = new ArrayList<>();
    public static List<Symptoms> houseplantsymp = new ArrayList<>();

    public interface DataStatus{
        void PlantDataIsLoaded(List<Plant> plants, List<String> keys);
        void SympDataIsLoaded(List<Symptoms> symptoms, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }
    public FirebaseDatabaseHelper() {
        myDatabase = FirebaseDatabase.getInstance();
        plantReference = myDatabase.getReference("plants");
        succReference = plantReference.child("succulents");
        succsymptomsReference = plantReference.child("succ_symptoms");
        houseplantReference = plantReference.child("houseplants");
        houseplantsymptomsReference = plantReference.child("houseplant_symptoms");
    }

    public void readSucculents(final DataStatus dataStatus){
        succReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                succulents.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Plant succulent = keyNode.getValue(Plant.class);
                    succulents.add(succulent);
                }
                dataStatus.PlantDataIsLoaded(succulents, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void readSuccSymp(final DataStatus dataStatus){
        succsymptomsReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                succsymp.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Symptoms symptom = keyNode.getValue(Symptoms.class);
                    succsymp.add(symptom);
                }
                dataStatus.SympDataIsLoaded(succsymp, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void readHousePlants(final DataStatus dataStatus){
        houseplantReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                houseplants.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Plant houseplant = keyNode.getValue(Plant.class);
                    houseplants.add(houseplant);
                }
                dataStatus.PlantDataIsLoaded(houseplants, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void readHouseSymp(final DataStatus dataStatus){
        houseplantsymptomsReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                houseplantsymp.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Symptoms symptom = keyNode.getValue(Symptoms.class);
                    houseplantsymp.add(symptom);
                }
                dataStatus.SympDataIsLoaded(houseplantsymp, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
