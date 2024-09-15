package com.example.expass3.manager;

import com.example.expass3.Poll;
import com.example.expass3.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class AppManager {
    private final HashMap<String, User> userMap;
    private final HashMap<Integer, Poll> pollMap;

    public AppManager() {
        userMap = new HashMap<>();
        pollMap = new HashMap<>();
    }

    public HashMap<String, User> getUserMap() {
        return userMap;
    }

    public HashMap<Integer, Poll> getPollMap() {
        return pollMap;
    }

    public void setUser(String username, User newUser){
        userMap.put(username, newUser);
    }

    public void setPoll(int pollId, Poll newPoll){
        pollMap.put(pollId, newPoll);
    }


}
