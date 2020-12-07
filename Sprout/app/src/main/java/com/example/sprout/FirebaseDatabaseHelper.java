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

    //this class is used to access and read data from our Firebase Realtime Database

    private final FirebaseDatabase myDatabase;
    private final DatabaseReference plantReference;
    private final DatabaseReference succReference;
    private final DatabaseReference houseplantReference;
    private final DatabaseReference succsymptomsReference;
    private final DatabaseReference houseplantsymptomsReference;
    //the public static variables are made this way so they can be accessed throughout the app
    public static List<Plant> succulents = new ArrayList<>();
    public static List<Plant> houseplants = new ArrayList<>();
    public static List<Symptoms> succsymp = new ArrayList<>();
    public static List<Symptoms> houseplantsymp = new ArrayList<>();

    //when the database data is successfully loaded by our app, we call this function to be able to access
    //the plant or plant symptom data in other methods and classes throughout the app
    public interface DataStatus{
        void PlantDataIsLoaded(List<Plant> plants, List<String> keys);
        void SympDataIsLoaded(List<Symptoms> thesymptoms, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    //this is a constructor for the method. it accesses our database and assigns different reference
    //variables for the different child components of our root database
    public FirebaseDatabaseHelper() {
        myDatabase = FirebaseDatabase.getInstance();
        plantReference = myDatabase.getReference("plants");
        succReference = plantReference.child("succulents");
        succsymptomsReference = plantReference.child("succ_symptoms");
        houseplantReference = plantReference.child("houseplants");
        houseplantsymptomsReference = plantReference.child("houseplant_symptoms");
    }

    //when values are in the succulent reference, method executes, as well as when there is any changes to
    //the database, making it so the app can access new data inputs as our team adds them.
    public void readSucculents(final DataStatus dataStatus){
        succReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //if the database data changes, the saved arraylist of plant data is cleared and
                //through a for loop, we cycle through every node that has child values, which are
                //then extracted into our custom Plant class variable and then added to our global list of
                //all plant data
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

    //this works exactly like the readSucculents method but we access the succulent symptoms node in
    //our database and the values are extracted into our custom Symptoms class
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

    //works exactly like readSucculents but accesses the houseplant node in our database
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

    //works exactly like readSuccSymp but accesses the houseplant symptom node in our database
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
