package com.example.gbcu.data.model;

public class NewsSchema {
    private String title;
    private String date;
    private String imgUrl;
    private String storyIntro;
    private String link;

    public NewsSchema(String title, String date, String imgUrl, String storyIntro, String link) {
        this.title = title;
        this.date = date;
        this.imgUrl = imgUrl;
        this.storyIntro = storyIntro;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getStoryIntro() {
        return storyIntro;
    }

    public String getLink() {
        return link;
    }
}
