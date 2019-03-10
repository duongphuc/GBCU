package com.example.gbcu.ui.list;

import com.example.gbcu.data.model.NewsSchema;

import java.util.List;

public interface NewsListNavigator {
    void fetchNewsSuccess(List<NewsSchema> items);

    void fetchNewsFail();
}
