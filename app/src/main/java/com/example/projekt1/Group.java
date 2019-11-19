package com.example.projekt1;

import java.util.Vector;

public class Group {

    private String id;
    private String groupName;
    private String admin;

    private Vector<Feature> features;

    public Group() {
    }

    public Group(String id, String groupName) {
        this.id = id;
        this.groupName = groupName;
    }

    public Group(String id, String groupName, Vector<Feature> features) {
        this.id = id;
        this.groupName = groupName;
        this.features = features;
    }

    public Group(String id, String groupName, String admin, Vector<Feature> features) {
        this.id = id;
        this.groupName = groupName;
        this.admin = admin;
        this.features = features;
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

    public void setId(String id) {
        this.id = id;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public void setFeatures(Vector<Feature> features) {
        this.features = features;
    }

    public void addNewFeature(Feature feature)
    {
        this.features.add(feature);
    }
}
