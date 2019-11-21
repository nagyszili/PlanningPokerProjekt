package com.example.projekt1;

import java.util.ArrayList;

public class Group {

    private String id;
    private String groupName;
    private String admin;
    private Feature activeFeature;
    private ArrayList<Feature> features = new ArrayList<>();

    public Group() {
    }

    public Group(String id, String groupName) {
        this.id = id;
        this.groupName = groupName;
    }

    public Group(String id, String groupName, ArrayList<Feature> features) {
        this.id = id;
        this.groupName = groupName;
        this.features = features;
    }

    public Group(String id, String groupName, String admin, ArrayList<Feature> features) {
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

    public ArrayList<Feature> getFeatures() {
        return features;
    }

    public Feature getActiveFeature() {
        return activeFeature;
    }

    public void activateFeature(Feature activeFeature) {
        this.activeFeature = activeFeature;
        this.activeFeature.setActive(true);
    }

    public void deactivateFeature()
    {
        this.activeFeature.setActive(false);
        this.activeFeature = null;
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

    public void setFeatures(ArrayList<Feature> features) {
        this.features = features;
    }

    public void addNewFeature(Feature feature)
    {
        this.features.add(feature);
    }
}
