package com.example.gbcu.ui.detail;

import com.example.gbcu.data.DataManager;
import com.example.gbcu.ui.base.BaseViewModel;
import com.example.gbcu.util.SchedulerProvider;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;

public class NewsDetailViewModel extends BaseViewModel<NewsDetailNavigator> {
    public NewsDetailViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void onBackClick() {
        getNavigator().onBackClick();
    }
}
