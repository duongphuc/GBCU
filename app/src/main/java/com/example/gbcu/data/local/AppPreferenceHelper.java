package com.example.gbcu.data.local;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.gbcu.di.PreferenceInfo;
import com.example.gbcu.util.AppConstant;
import com.example.gbcu.util.SecurePreferences;

import javax.inject.Inject;

public class AppPreferenceHelper implements PreferenceHelper {
    private final SecurePreferences mPrefs;
    @Inject
    public AppPreferenceHelper(SecurePreferences pref) {
        mPrefs = pref;
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
}
