package com.example.expass3;

import java.util.HashMap;

public class User {

    private String username;
    private String email;
    //              pollId
    private HashMap<Integer, Poll> polls;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
        this.polls = new HashMap<>();
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public HashMap<Integer, Poll> getPolls() {
        return polls;
    }

    public void setPolls(HashMap<Integer, Poll> polls) {
        this.polls = polls;
    }

    public void addPoll(Poll poll) {
        polls.put(poll.getPollId(), poll);
    }
    public void removePoll(Integer pollId) {
        polls.remove(pollId);
    }

}
