package com.starlingbank.sbtechchallenge.model;

import java.util.List;


public class FeedItems {
    @Override
    public String toString() {
        return "FeedItems{" +
                "feedItems=" + feedItems +
                '}';
    }

    public FeedItems(List<FeedItem> feedItems) {
        this.feedItems = feedItems;
    }

    public FeedItems() {
    }

    private List<FeedItem> feedItems;

    public List<FeedItem> getFeedItems() {
        return feedItems;
    }

    public void setFeedItems(List<FeedItem> feedItems) {
        this.feedItems = feedItems;
    }

}
