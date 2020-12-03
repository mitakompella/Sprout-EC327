package com.example.sprout;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper {
    private FirebaseDatabase myDatabase;
    private DatabaseReference myReference;
    private List<Plant> plants = new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<Plant> plants, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }
    public FirebaseDatabaseHelper() {
        myDatabase = FirebaseDatabase.getInstance();
        myReference = myDatabase.getReference("plants");
    }

    public void readPlants(final DataStatus dataStatus){
        myReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                plants.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Plant plant = keyNode.getValue(Plant.class);
                    plants.add(plant);
                }
                dataStatus.DataIsLoaded(plants, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
