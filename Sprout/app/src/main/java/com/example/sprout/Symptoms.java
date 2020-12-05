package com.example.sprout;

public class Symptoms {
    private String detailed;
    private String title;
    private String ID;

    public Symptoms() {
    }

    public Symptoms(String detailed, String title, String ID) {
        this.detailed = detailed;
        this.title = title;
        this.ID = ID;
    }

    public String getDetailed() {
        return detailed;
    }

    public void setDetailed(String detailed) {
        this.detailed = detailed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
