package com.example.gbcu;

import com.example.gbcu.data.DataManager;
import com.example.gbcu.ui.list.NewsListViewModel;
import com.example.gbcu.ui.login.LoginViewModel;
import com.example.gbcu.ui.walkthrough.WalkThroughViewModel;
import com.example.gbcu.util.SchedulerProvider;

import javax.inject.Inject;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelProviderFactory extends ViewModelProvider.NewInstanceFactory {
    private final DataManager dataManager;
    private final SchedulerProvider schedulerProvider;

    @Inject
    public ViewModelProviderFactory(DataManager dataManager,
                                    SchedulerProvider schedulerProvider) {
        this.dataManager = dataManager;
        this.schedulerProvider = schedulerProvider;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(WalkThroughViewModel.class)) {
            return (T) new WalkThroughViewModel(dataManager,schedulerProvider);
        } else if (modelClass.isAssignableFrom(LoginViewModel.class)) {
            return (T) new LoginViewModel(dataManager, schedulerProvider);
        } else if (modelClass.isAssignableFrom(NewsListViewModel.class)) {
            return (T) new NewsListViewModel(dataManager, schedulerProvider);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
