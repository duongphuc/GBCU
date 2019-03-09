package com.example.gbcu.ui.login;

import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;

import com.example.gbcu.data.DataManager;
import com.example.gbcu.ui.base.BaseViewModel;
import com.example.gbcu.util.CommonUtil;
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
                    setIsLoading(false);
                }, throwable -> {
                    getNavigator().onLoginFail();
                    setIsLoading(false);
                }));
    }

    public void onTextChange(CharSequence text) {
        getNavigator().onTextChange(text);
    }
}
