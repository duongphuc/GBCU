package com.example.gbcu.ui.login;

public interface LoginNavigator {
    void onTextChange(CharSequence text);

    void onLoginSuccess();

    void onLoginFail();

    void setPasswordFromRemember(String savedPassword);
}
