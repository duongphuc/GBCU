package com.example.gbcu.data.model;

public class LoginResponse {
    private String accessToken;

    public LoginResponse(String accesToken) {
        this.accessToken = accesToken;
    }

    public String getAccesToken() {
        return accessToken;
    }
}
