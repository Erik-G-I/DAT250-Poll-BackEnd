package com.example.expass3.controller;

import com.example.expass3.Poll;
import com.example.expass3.User;
import com.example.expass3.Vote;
import com.example.expass3.manager.AppManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class PollController {
    private final AppManager appManager;

    @Autowired
    public PollController(AppManager appManager) {
        this.appManager = appManager;
    }

    @PostMapping("/polls/{username}")
    public Poll createPoll(@RequestBody Poll poll, @PathVariable String username) {
        Integer pollId = poll.getPollId();
        appManager.setPoll(pollId, poll);
        User user = appManager.getUserMap().get(username);
        user.addPoll(poll);
        return appManager.getPollMap().get(pollId);
    }

    @GetMapping("/polls/all")
    public HashMap<Integer, Poll> getAllPolls() {
        return appManager.getPollMap();
    }

    @GetMapping("/polls/{pollId}")
    public Poll getPollById(@PathVariable Integer pollId) {
        return appManager.getPollMap().get(pollId);
    }

    @GetMapping("/polls/{pollId}/votes")
    public HashMap<String, Vote> getVotesFromPoll(@PathVariable Integer pollId) {
        Poll poll = appManager.getPollMap().get(pollId);
        return poll.getVotes();
    }

    @DeleteMapping("/polls/{username}")
    public Poll deletePoll(@RequestParam Integer pollId, @PathVariable String username) {
        User user = appManager.getUserMap().get(username);
        user.removePoll(pollId);
        return appManager.getPollMap().remove(pollId);
    }

}
