package com.example.sprout;

public class Plant {
    //this is our custom Plant class that includes all plant data that is accessed throughout the app

    //these variables are what are stored in our database
    private String species;
    private String ID;
    private int sun;
    private int water;
    private int temp;

    public Plant() {
    }

    public Plant(String ID, String species, int sun, int water, int temp) {
        this.species = species;
        this.ID = ID;
        this.sun = sun;
        this.water = water;
        this.temp = temp;
    }

    //basic setter and getter functions so we can output more common variable types such as ints and
    //strings to make working with the data easier
    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getID() { return ID; }

    public void setID(String ID) { this.ID = ID; }

    public int getSun() {
        return sun;
    }

    public void setSun(int sun) {
        this.sun = sun;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}
