package com.example.expass3;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Poll {
    private Integer pollId;
    private String creator;
    private String question;
    private List<VoteOption> options;
    private Instant publishedAt;
    private Instant validUntil;
    private HashMap<String, Vote> votes;

    public Poll(Integer pollId, String creator, String question, List<VoteOption> options, Instant validUntil) {
        this.pollId = pollId;
        this.creator = creator;
        this.question = question;
        this.options = options;
        this.publishedAt = Instant.now();
        this.validUntil = publishedAt.plus(30, ChronoUnit.DAYS);
        this.votes = new HashMap<>();
    }

    public Integer getPollId() {
        return pollId;
    }

    public String getCreator() {
        return creator;
    }

    public String getQuestion() {
        return question;
    }

    public List<VoteOption> getOptions() {
        return options;
    }

    public Instant getPublishedAt() {
        return publishedAt;
    }

    public Instant getValidUntil() {
        return validUntil;
    }

    public HashMap<String, Vote> getVotes() {
        return votes;
    }

    public void addVote(String username, Vote vote) {
        votes.put(username, vote);
    }
    public void removeVote(String username) {
        votes.remove(username);
    }
}