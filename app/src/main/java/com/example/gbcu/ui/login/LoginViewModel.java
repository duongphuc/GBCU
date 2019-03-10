package com.example.gbcu.ui.login;

import android.text.TextUtils;

import com.example.gbcu.data.DataManager;
import com.example.gbcu.ui.base.BaseViewModel;
import com.example.gbcu.util.SchedulerProvider;

public class LoginViewModel extends BaseViewModel<LoginNavigator> {
    public LoginViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void onLoginClick(String userName, String password) {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .doOnLogin(userName, password)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {
                    getNavigator().onLoginSuccess();
                    getDataManager().updateAuthToken(response.getAccesToken());
                    getDataManager().saveUserInfo(response.getUserInfo());
                    setIsLoading(false);
                }, throwable -> {
                    getNavigator().onLoginFail();
                    setIsLoading(false);
                }));
    }

    public void onRememberClick(boolean isSelected, String userName, String password) {
        if (isSelected) {
            getDataManager().rememberUser(userName, password);
        } else  {
            getDataManager().removeRememberUser(userName);
        }
    }

    public void onTextChange(CharSequence text) {
        getNavigator().onTextChange(text);
    }

    public void checkRememberUser(String userName) {
        String savedPassword = getDataManager().getRememberUser(userName);
        getNavigator().setPasswordFromRemember(savedPassword);
    }
}
