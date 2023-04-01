package com.starlingbank.sbtechchallenge.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "feedItems"
})

public class FeedItems {
    @Override
    public String toString() {
        return "FeedItems{" +
                "feedItems=" + feedItems +
                '}';
    }

    @JsonProperty("feedItems")
    private List<FeedItem> feedItems;

    @JsonProperty("feedItems")
    public List<FeedItem> getFeedItems() {
        return feedItems;
    }

    @JsonProperty("feedItems")
    public void setFeedItems(List<FeedItem> feedItems) {
        this.feedItems = feedItems;
    }

}
