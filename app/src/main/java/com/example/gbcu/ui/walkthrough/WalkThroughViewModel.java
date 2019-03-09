package com.example.gbcu.ui.walkthrough;

import com.example.gbcu.data.DataManager;
import com.example.gbcu.ui.base.BaseViewModel;
import com.example.gbcu.util.SchedulerProvider;

import androidx.lifecycle.ViewModel;

public class WalkThroughViewModel extends BaseViewModel<WalkThroughNavigator> {
    public WalkThroughViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void onSkipClick() {
        getNavigator().skip();
    }
}
