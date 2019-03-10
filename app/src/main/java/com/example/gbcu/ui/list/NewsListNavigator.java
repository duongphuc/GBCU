package com.example.gbcu.ui.list;

import com.example.gbcu.data.model.NewsSchema;

import java.util.List;

public interface NewsListNavigator {
    void fetchNewsSuccess(List<NewsSchema> items);

    void fetchNewsFail();

    void onRefresh();

    void logout();

    void loadDetail(String link, String title);
}
