package com.example.gbcu.data.remote;

import com.example.gbcu.data.model.NewsResponse;
import com.example.gbcu.data.model.NewsSchema;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import retrofit2.Retrofit;

public class AppApiHelper implements ApiHelper {
    private ApiService apiService;

    @Inject
    public AppApiHelper(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Single<NewsResponse> fetchListNews() {
        return apiService.fetchNews();
    }

    @Override
    public void doLogout() {
        //Use for call to server inform invalid token in case logout
    }
}
