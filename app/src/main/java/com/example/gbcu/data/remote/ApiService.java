package com.example.gbcu.data.remote;

import com.example.gbcu.data.model.NewsResponse;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/news/world/asia/rss.xml")
    Single<NewsResponse> fetchNews();
}
