package com.example.projekt1;

import java.util.Vector;

public class Group {

    private String id;
    private String groupName;
    private String admin;

    private Vector<Feature> features;

    public Group(String id, String groupName) {
        this.id = id;
        this.groupName = groupName;
    }

    public String getId() {
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
