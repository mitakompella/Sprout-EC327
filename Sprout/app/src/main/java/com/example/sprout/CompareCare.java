package com.example.sprout;

import android.app.Application;

public class CompareCare extends Application {

    public String CompareSun(int inputSun, int optimalSun){
        int dif = inputSun-optimalSun;
        if(dif <= 1 && dif >= -1){
            return "Perfect amount of sun! #plant parent goals!";
        }
        else if(dif > 1 && dif < 4){
            return "Too much sun! This could stress your plant, try moving it to a shadier spot.";
        }
        else if(dif > 4){
            return "Don’t give your plant sunburn!! Move your plant to a shadier spot.";
        }
        else if(dif < -1 && dif > -4){
            return "Uh Oh! Looks like your plant might need more sun, try moving it to a spot that gets more sunlight!";
        }
        else if(dif < -4){
            return "WOAH! Your plant’s desperate for some sunshine! Move it to a sunnier spot.";
        }
        return null;
    }

    public String CompareTemp(int inputTemp, int optimalTemp) {
        int dif = inputTemp - optimalTemp;
        if (dif <= 1 && dif >= -1) {
            return "Your plant is thriving at your temperature! Keep up the great plant parenting!";
        }
        else if(dif > 1 && dif < 4){
            return "“I’m sweating!” says your plant. The heat could stress out the plant, try moving it somewhere less warm!";
        }
        else if(dif > 4){
            return "WOAH! It’s way too hot out here! Move your plant to somewhere cooler";
        }
        else if(dif < -1 && dif > -4){
            return "“I’m chilly!!” whispers your plant. Try moving it to a place where the cold can’t stress it out!";
        }
        else if(dif < -4){
            return "Warning: cold shock imminent! Move your place somewhere warmer.";
        }
        return null;
    }

    public String CompareWater(int inputWater, int optimalWater) {
        int dif = inputWater - optimalWater;
        if (dif <= 1 && dif >= -1) {
            return "You’re an A+ plant parent! Your watering schedule is great!";
        }
        else if(dif > 1 && dif < 4){
            return "Uh Oh! Your plant looks like it’s lost at sea in all that water - try watering it less!";
        }
        else if(dif > 4){
            return "Your plant is drowning!!! Water it less so it can breathe.";
        }
        else if(dif < -1 && dif > -4){
            return "Warning: your plant is probably thirsty! Water your plant more frequently and/or thoroughly!";
        }
        else if(dif < -4){
            return "Your plant is begging for a drink! Water it more frequently and/or thoroughly!";
        }
        return null;
    }

}
