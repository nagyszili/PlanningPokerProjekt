package com.example.projekt1;

import java.util.Vector;

public class Feature {

    private String name;
    private int id;
    private boolean active;
    private Vector<User> usersVoted;

//    private boolean voted;


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
}
