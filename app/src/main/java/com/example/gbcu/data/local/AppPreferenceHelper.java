package com.example.gbcu.data.local;

import com.example.gbcu.data.model.LoginResponse;
import com.example.gbcu.util.AppConstant;
import com.example.gbcu.util.SecurePreferences;
import com.google.gson.Gson;

import javax.inject.Inject;

public class AppPreferenceHelper implements PreferenceHelper {
    private final SecurePreferences mPrefs;
    private Gson gson;

    @Inject
    public AppPreferenceHelper(SecurePreferences pref, Gson gson) {
        mPrefs = pref;
        this.gson = gson;
        mPrefs.put("auth_user_name", AppConstant.AUTH_USER_NAME);
        mPrefs.put("auth_password", AppConstant.AUTH_PASS_WORD);
    }

    @Override
    public void saveToken(String token) {
        mPrefs.put("token", token);
    }



    @Override
    public void saveUser(String userName, String password) {
        mPrefs.put(userName, password);
    }

    @Override
    public void removeSavedUser(String userName) {
        mPrefs.removeValue(userName);
    }

    @Override
    public String getAuthUserName() {
        return mPrefs.getString("auth_user_name");
    }

    @Override
    public String getAuthPassword() {
        return mPrefs.getString("auth_password");
    }

    @Override
    public String getSavedUser(String userName) {
        return mPrefs.getString(userName);
    }

    @Override
    public void removeToken() {
        mPrefs.removeValue("token");
    }

    @Override
    public void saveUserInfo(LoginResponse.UserInfo userInfo) {
        String userInfoString = gson.toJson(userInfo);
        mPrefs.put("userInfo", userInfoString);
    }

    @Override
    public void removeUserInfo() {
        mPrefs.removeValue("userInfo");
    }
}
