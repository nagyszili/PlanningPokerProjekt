package com.example.projekt1;

import java.util.Vector;

public class Group {

    private int id;
    private String groupName;
    private String admin;

    private Vector<Feature> features;

    public Group(int id, String groupName) {
        this.id = id;
        this.groupName = groupName;
    }

    public int getId() {
        return id;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getAdmin() {
        return admin;
    }

    public Vector<Feature> getFeatures() {
        return features;
    }
}
