package com.example.sprout;

public class Plant {
    private String plant_type;
    private String species;
    private int sun;
    private int water;
    private int temp;

    public Plant() {
    }

    public Plant(String plant_type, String species, int sun, int water, int temp) {
        this.plant_type = plant_type;
        this.species = species;
        this.sun = sun;
        this.water = water;
        this.temp = temp;
    }

    public String getPlant_type() {
        return plant_type;
    }

    public void setPlant_type(String plant_type) {
        this.plant_type = plant_type;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

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
