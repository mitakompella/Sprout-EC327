package com.example.sprout;

public class Plant {
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
