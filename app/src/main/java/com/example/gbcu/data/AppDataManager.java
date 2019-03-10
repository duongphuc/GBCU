package com.example.gbcu.data;

import com.example.gbcu.data.local.PreferenceHelper;
import com.example.gbcu.data.model.LoginResponse;
import com.example.gbcu.data.model.NewsResponse;
import com.example.gbcu.data.remote.ApiHelper;
import com.example.gbcu.util.AppConstant;
import com.example.gbcu.util.SecureTokenGenerator;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

public class AppDataManager implements DataManager {
    private PreferenceHelper preferenceHelper;
    private ApiHelper apiHelper;

    @Inject
    public AppDataManager(PreferenceHelper preferencesHelper, ApiHelper apiHelper) {
        this.preferenceHelper = preferencesHelper;
        this.apiHelper = apiHelper;
    }

    @Override
    public Single<LoginResponse> doOnLogin(String userName, String password) {
        return Single.create(new SingleOnSubscribe<LoginResponse>() {
            @Override
            public void subscribe(SingleEmitter<LoginResponse> emitter) throws Exception {
                if (userName.equals(preferenceHelper.getAuthUserName()) && password.equals(preferenceHelper.getAuthPassword())) {
                    LoginResponse loginResponse = new LoginResponse(SecureTokenGenerator.nextToken());
                    emitter.onSuccess(loginResponse);
                    return;
                }
                throw new Exception("Login fail");
            }
        });
    }

    @Override
    public void updateAuthToken(String token) {
        preferenceHelper.saveToken(token);
    }

    @Override
    public void saveUserInfo(LoginResponse.UserInfo userInfo) {
        preferenceHelper.saveUserInfo(userInfo);
    }

    @Override
    public void rememberUser(String userName, String password) {
        preferenceHelper.saveUser(userName, password);
    }

    @Override
    public void removeRememberUser(String userName) {
        preferenceHelper.removeSavedUser(userName);
    }

    @Override
    public String getRememberUser(String userName) {
        return preferenceHelper.getSavedUser(userName);
    }

    @Override
    public Single<NewsResponse> fetchListNews() {
        return apiHelper.fetchListNews();
    }

    @Override
    public void logout() {
        apiHelper.doLogout();
        preferenceHelper.removeToken();
        preferenceHelper.removeUserInfo();
    }
}
