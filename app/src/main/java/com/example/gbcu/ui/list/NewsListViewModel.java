package com.example.gbcu.ui.list;

import com.example.gbcu.data.DataManager;
import com.example.gbcu.ui.base.BaseViewModel;
import com.example.gbcu.util.SchedulerProvider;

public class NewsListViewModel extends BaseViewModel<NewsListNavigator> {
    public NewsListViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
}
