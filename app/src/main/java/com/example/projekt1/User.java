package com.example.projekt1;

public class User {

    private int id;
    private String name;
    private String votedValue;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getVotedValue() {
        return votedValue;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVotedValue(String votedValue) {
        this.votedValue = votedValue;
    }
}
