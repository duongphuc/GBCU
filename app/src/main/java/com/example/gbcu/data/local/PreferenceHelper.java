package com.example.gbcu.data.local;

public interface PreferenceHelper {
    void saveToken(String token);

    void saveUser(String userName, String password);

    void removeSavedUser(String userName);

    String getAuthUserName();

    String getAuthPassword();

    String getSavedUser(String userName);
}
