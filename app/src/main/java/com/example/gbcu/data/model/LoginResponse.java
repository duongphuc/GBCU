package com.example.gbcu.data.model;

import com.example.gbcu.util.SecureTokenGenerator;

import java.util.Date;

public class LoginResponse {
    private String accessToken;
    private long expireTime;
    private UserInfo userInfo;

    public LoginResponse(String accessToken, long expireTime) {
        this.accessToken = accessToken;
        this.expireTime = expireTime;
        this.userInfo = new UserInfo();
    }

    public String getAccesToken() {
        return accessToken;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public class UserInfo {
    }
}
