package com.example.gbcu.data.model;

import com.example.gbcu.util.SecureTokenGenerator;

public class LoginResponse {
    private String accessToken;

    private UserInfo userInfo;

    public LoginResponse() {
        this.accessToken = SecureTokenGenerator.nextToken();
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
