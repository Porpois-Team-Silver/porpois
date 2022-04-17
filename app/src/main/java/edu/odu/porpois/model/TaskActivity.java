package edu.odu.porpois.model;

import static java.lang.Integer.parseInt;

import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Activity class to hold the values stored in FireBase
public class TaskActivity {
    // Keys
    public final static String CATEGORY = "category";
    public final static String CITY = "city";
    public final static String DISLIKES = "dislikes";
    public final static String LIKES = "likes";
    public final static String POINT_VALUE = "point_value";
    public final static String TAGS = "tags";
    public final static String IMAGE = "image";
    public final static String URL = "url";
    public final static String URL_VALID = "url_valid";

    private int category;
    private String city;
    private int dislikes;
    private int likes;
    private int pointValue;
    private List<String> tags;
    private String image;
    private String url;
    private boolean urlValid;

    // empty default constructor
    public TaskActivity() {
        this.category = 0;
        this.city = "N/A";
        this.dislikes = 0;
        this.likes = 0;
        this.pointValue = 0;
        this.image = "N/A";
        this.url = "N/A";
        this.urlValid = false;
    }

    // parameterized default constructor
    public TaskActivity(int category, String city, int dislikes, int likes, int pointValue,
                        List<String> tags, String image, String url, boolean urlValid) {
        this.category = category;
        this.city = city;
        this.dislikes = dislikes;
        this.likes = likes;
        this.pointValue = pointValue;
        this.tags = tags;
        this.image = image;
        this.url = url;
        this.urlValid = urlValid;
    }

    // document constructor
    public TaskActivity(QueryDocumentSnapshot document)
    {
        this.category = parseInt(document.get(CATEGORY).toString());
        this.city = document.get(CITY).toString();
        this.dislikes = parseInt(document.get(DISLIKES).toString());
        this.likes = parseInt(document.get(LIKES).toString());
        this.pointValue = parseInt(document.get(POINT_VALUE).toString());
        this.tags = (List) document.get(TAGS);
        this.image = document.get(IMAGE).toString();
        if (document.get(URL) != null)
            this.url = document.get(URL).toString();
        else
            this.url = null;
        this.urlValid = (boolean) document.get(URL_VALID);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaskActivity)) return false;
        TaskActivity that = (TaskActivity) o;
        return dislikes == that.dislikes && likes == that.likes && pointValue == that.pointValue
                && urlValid == that.urlValid && category == that.category
                && city.equals(that.city) && tags.equals(that.tags) && image.equals(that.image)
                && url.equals(that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, city, dislikes,
                likes, pointValue, tags, image, url, urlValid);
    }

    @Override
    public String toString() {
        return "TaskActivity{" +
                "category=" + category +
                ", city=" + city +
                ", dislikes=" + dislikes +
                ", likes=" + likes +
                ", pointValue=" + pointValue +
                ", tags=" + tags +
                ", image=" + image +
                ", url=" + url +
                ", urlValid=" + urlValid + "}";
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
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

    public List<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String title) {
        this.image = title;
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
