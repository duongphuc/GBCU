package com.example.gbcu.data.local;

import com.example.gbcu.data.model.LoginResponse;

public interface PreferenceHelper {
    void saveToken(String token);

    void saveUser(String userName, String password);

    void removeSavedUser(String userName);

    String getAuthUserName();

    String getAuthPassword();

    String getSavedUser(String userName);

    void removeToken();

    void saveUserInfo(LoginResponse.UserInfo userInfo);

    void removeUserInfo();
}
