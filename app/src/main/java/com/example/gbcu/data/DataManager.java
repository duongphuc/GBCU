package com.example.gbcu.data;

import com.example.gbcu.data.model.LoginResponse;

import io.reactivex.Single;

public interface DataManager {
    Single<LoginResponse> doOnLogin(String userName, String password);
}
