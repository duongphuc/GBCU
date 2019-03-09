package com.example.gbcu.ui.login;

import com.example.gbcu.data.DataManager;
import com.example.gbcu.ui.base.BaseViewModel;
import com.example.gbcu.util.SchedulerProvider;

public class LoginViewModel extends BaseViewModel<LoginNavigator> {
    public LoginViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
}
