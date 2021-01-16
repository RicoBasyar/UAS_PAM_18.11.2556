package com.example.UASPAM.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class hasilResponse {
    @SerializedName("events")
    private ArrayList<hasil> events;

    public ArrayList<hasil> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<hasil> events) {
        this.events = events;
    }
}
