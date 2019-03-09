package com.example.gbcu.data;

import com.example.gbcu.data.model.LoginResponse;

import io.reactivex.Single;

public interface DataManager {
    Single<LoginResponse> doOnLogin(String userName, String password);

    void updateAuthToken(String token);

    void rememberUser(String userName, String password);

    void removeRememberUser(String userName);

    String getRememberUser(String userName);
}
