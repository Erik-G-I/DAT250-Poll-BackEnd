package com.example.expass3.controller;

import com.example.expass3.Poll;
import com.example.expass3.User;
import com.example.expass3.Vote;
import com.example.expass3.VoteOption;
import com.example.expass3.manager.AppManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class UserController {
    private final AppManager appManager;

    @Autowired
    public UserController(AppManager appManager) {
        this.appManager = appManager;
    }
    @PostMapping("/users")
    public User createUser(@RequestBody User newUser) {
        String username = newUser.getUsername();
        appManager.setUser(username, newUser);
        return appManager.getUserMap().get(username);
    }

    @GetMapping("/users/all")
    public HashMap<String, User> getAllUsers() {
        return appManager.getUserMap();
    }
    @PutMapping("/polls/{pollId}")
    public VoteOption vote(@PathVariable Integer pollId, @RequestBody Vote vote) {
        String username = vote.getUsername();
        HashMap<Integer, Poll> pollMap = appManager.getPollMap();
        Poll poll = pollMap.get(pollId);
        if (poll.getVotes().containsKey(username)) {
            Vote oldVote = poll.getVotes().get(username);
            poll.getOptions().get(oldVote.getOption()).downVoteCount();
        }
        poll.addVote(username, vote);
        poll.getOptions().get(vote.getOption()).upVoteCount();
        return poll.getOptions().get(vote.getOption());
    }


}
