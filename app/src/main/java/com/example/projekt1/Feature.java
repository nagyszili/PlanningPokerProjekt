package com.example.projekt1;

import java.util.Vector;

public class Feature {

    private String name;
    private int id;
    private boolean active;
    private Vector<User> usersVoted;

    public Feature() {
    }

    public Feature(String name) {
        this.name = name;
    }

    public Feature(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Feature(String name, int id, boolean active) {
        this.name = name;
        this.id = id;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public boolean isActive() {
        return active;
    }

    public Vector<User> getUsersVoted() {
        return usersVoted;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setUsersVoted(Vector<User> usersVoted) {
        this.usersVoted = usersVoted;
    }

    public void addVotedUser(User user)
    {
        this.usersVoted.add(user);
    }
}
