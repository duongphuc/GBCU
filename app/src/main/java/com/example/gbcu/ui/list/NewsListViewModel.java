package com.example.gbcu.ui.list;

import com.example.gbcu.data.DataManager;
import com.example.gbcu.data.model.NewsResponse;
import com.example.gbcu.data.model.NewsSchema;
import com.example.gbcu.ui.base.BaseViewModel;
import com.example.gbcu.util.SchedulerProvider;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;

public class NewsListViewModel extends BaseViewModel<NewsListNavigator> {
    public NewsListViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void fetchNews() {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager().fetchListNews()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .map(newsResponse -> {
                    List<NewsSchema> newsSchemaList = new ArrayList<>();
                    List<NewsResponse.Item> itemList = newsResponse.channel.getItems();
                    for (NewsResponse.Item item : itemList) {
                        NewsSchema news = new NewsSchema(item.getTitle(), item.getPubDate(), item.getImgUrl().getUrl(), item.getDescription());
                        newsSchemaList.add(news);
                    }
                    return newsSchemaList;
                })
                .subscribe(response -> {
                    setIsLoading(false);
                    getNavigator().fetchNewsSuccess(response);
                }, throwable -> {
                    setIsLoading(false);
                    getNavigator().fetchNewsFail();
                }));
    }

    public void onRefresh() {
        setIsLoading(true);
        getNavigator().onRefresh();
        fetchNews();
    }

    public void logoutClick() {
        getDataManager().logout();
        getNavigator().logout();
    }
}
