package com.example.newsappphenyo.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Articles {

    @SerializedName("Source")
    @Expose
    private Source source;

    @SerializedName("Author")
    @Expose
    private String Author;

    @SerializedName("Title")
    @Expose
    private String Title;

    @SerializedName("Description")
    @Expose
    private String Description;

    @SerializedName("URLToImage")
    @Expose
    private String URLToImage;

    @SerializedName("PublishedAt")
    @Expose
    private String PublishedAt;


    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getURLToImage() {
        return URLToImage;
    }

    public void setURLToImage(String URLToImage) {
        this.URLToImage = URLToImage;
    }

    public String getPublishedAt() {
        return PublishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        PublishedAt = publishedAt;
    }
}
