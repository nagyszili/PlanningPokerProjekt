package com.example.projekt1;

import java.util.HashMap;

public class Feature {

    private String name;
    private static int count;
    private int id;
    private boolean active;
    private HashMap<String,User> usersVoted = new HashMap<>();

    public Feature() {
        count += 1;
        this.id = count;
    }

    public Feature(String name) {
        this.name = name;
        count += 1;
        this.id = count;

    }

//    public Feature(String name, int id) {
//        this.name = name;
//        count += 1;
//        this.id = id;
//    }

//    public Feature(String name, int id, boolean active) {
//        this.name = name;
//        this.id = id;
//        this.active = active;
//    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getCount() {
        return count;
    }


    public boolean isActive() {
        return active;
    }

    public HashMap<String,User> getUsersVoted() {
        return usersVoted;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public void setActive(boolean active) {
        this.active = active;
    }

//    public void setUsersVoted(HashMap<String,User> usersVoted) {
//        this.usersVoted = usersVoted;
//    }

//    public void addVotedUser(User user) {
//        this.usersVoted.put(user.getName(),user);
//    }
}
