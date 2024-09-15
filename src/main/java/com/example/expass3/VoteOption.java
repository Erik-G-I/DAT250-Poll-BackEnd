package com.example.expass3;

public class VoteOption {
    private String caption;
    private Integer presentationOrder;
    private Integer voteCount;

    public VoteOption(String caption, Integer presentationOrder) {
        this.caption = caption;
        this.presentationOrder = presentationOrder;
        this.voteCount = 0;
    }

    public String getCaption() {
        return caption;
    }

    public Integer getPresentationOrder() {
        return presentationOrder;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void upVoteCount() {
        this.voteCount = this.voteCount + 1;
    }
    public void downVoteCount() {
        this.voteCount = this.voteCount - 1;
    }
}
