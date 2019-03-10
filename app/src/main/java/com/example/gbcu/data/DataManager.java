package com.example.gbcu.data;

import com.example.gbcu.data.model.LoginResponse;
import com.example.gbcu.data.model.NewsResponse;

import io.reactivex.Single;

public interface DataManager {
    Single<LoginResponse> doOnLogin(String userName, String password);

    void updateAuthToken(String token, long expireTime);

    void saveUserInfo(LoginResponse.UserInfo userInfo);

    void rememberUser(String userName, String password);

    void removeRememberUser(String userName);

    String getRememberUser(String userName);

    Single<NewsResponse> fetchListNews();

    void logout();

    boolean isUserLogin();

    void removeLoginTokenIfAvailable();
}
