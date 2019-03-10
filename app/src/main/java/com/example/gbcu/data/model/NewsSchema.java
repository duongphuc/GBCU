package com.example.gbcu.data.model;

public class NewsSchema {
    private String title;
    private String date;
    private String imgUrl;
    private String storyIntro;

    public NewsSchema(String title, String date, String imgUrl, String storyIntro) {
        this.title = title;
        this.date = date;
        this.imgUrl = imgUrl;
        this.storyIntro = storyIntro;
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
}
