package com.example.UASPAM.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class jadwalResponse {
    @SerializedName("events")
    private ArrayList<jadwal> events;

    public ArrayList<jadwal> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<jadwal> events) {
        this.events = events;
    }
}
