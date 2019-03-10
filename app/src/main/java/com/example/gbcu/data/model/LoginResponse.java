package com.example.gbcu.data.model;

import com.example.gbcu.util.SecureTokenGenerator;

public class LoginResponse {
    private String accessToken;

    private UserInfo userInfo;

    public LoginResponse(String accessToken) {
        this.accessToken = accessToken;
        this.userInfo = new UserInfo();
    }

    public String getAccesToken() {
        return accessToken;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public class UserInfo {
    }
}
