package com.example.porpois.data;

import java.util.ArrayList;

// Activity class to hold the values stored in FireBase
public class TaskActivity {
    private String category;
    private String city;
    private int dislikes;
    private int likes;
    private int pointValue;
    private ArrayList<String> tags = new ArrayList<>();
    private String title;
    private String url;
    private boolean urlValid;

    // empty default constructor
    public TaskActivity() {
        this.category = "N/A";
        this.city = "N/A";
        this.dislikes = 0;
        this.likes = 0;
        this.pointValue = 0;
        this.title = "N/A";
        this.url = "N/A";
        this.urlValid = false;
    }

    // parameterized default constructor
    public TaskActivity(String category, String city, int dislikes, int likes, int pointValue,
                        ArrayList<String> tags, String title, String url, boolean urlValid) {
        this.category = category;
        this.city = city;
        this.dislikes = dislikes;
        this.likes = likes;
        this.pointValue = pointValue;
        this.tags = tags;
        this.title = title;
        this.url = url;
        this.urlValid = urlValid;

        // sets the empty default ArrayList. | Default size = 10
        for(int i = 0; i < tags.size(); i++) {
            tags.set(i, "");
        }
    }


    // getters and setters
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getPointValue() {
        return pointValue;
    }

    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isUrlValid() {
        return urlValid;
    }

    public void setUrlValid(boolean urlValid) {
        this.urlValid = urlValid;
    }
}
