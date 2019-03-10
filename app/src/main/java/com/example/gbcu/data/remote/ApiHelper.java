package com.example.gbcu.data.remote;

import com.example.gbcu.data.model.NewsResponse;
import com.example.gbcu.data.model.NewsSchema;

import java.util.List;

import io.reactivex.Single;

public interface ApiHelper {
    Single<NewsResponse> fetchListNews();

    void doLogout();
}
