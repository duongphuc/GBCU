package com.example.gbcu.data;

import com.example.gbcu.data.model.LoginResponse;
import com.example.gbcu.util.AppConstant;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

public class AppDataManager implements DataManager {
    @Inject
    public AppDataManager() {
    }

    @Override
    public Single<LoginResponse> doOnLogin(String userName, String password) {
        return Single.create(new SingleOnSubscribe<LoginResponse>() {
            @Override
            public void subscribe(SingleEmitter<LoginResponse> emitter) throws Exception {
                if (userName.equals(AppConstant.AUTH_USER_NAME) && password.equals(AppConstant.AUTH_PASS_WORD)) {
                    LoginResponse loginResponse = new LoginResponse(AppConstant.DUMMY_ACCESS_TOKEN);
                    emitter.onSuccess(loginResponse);
                    return;
                }
                throw new Exception("Login fail");
            }
        });
    }
}
