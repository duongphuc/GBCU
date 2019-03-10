package com.example.gbcu.ui.login;

import com.example.gbcu.TestSchedulerProvider;
import com.example.gbcu.data.DataManager;
import com.example.gbcu.data.model.LoginResponse;
import com.example.gbcu.util.SchedulerProvider;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.schedulers.TestScheduler;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

public class LoginViewModelTest {
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String TOKEN = "token";

    LoginNavigator mLoginCallback;
    DataManager dataManagerMock;
    TestScheduler mTestScheduler;

    LoginViewModel SUT;
    @Before
    public void setUp() throws Exception {
        dataManagerMock = mock(DataManager.class);
        mTestScheduler = new TestScheduler();
        TestSchedulerProvider testSchedulerProvider = new TestSchedulerProvider(mTestScheduler);
        mLoginCallback = mock(LoginNavigator.class);
        SUT = new LoginViewModel(dataManagerMock, testSchedulerProvider);
        SUT.setNavigator(mLoginCallback);

    }

    @After
    public void tearDown() throws Exception {
        mLoginCallback = null;
        dataManagerMock = null;
        mTestScheduler = null;
    }

    @Test
    public void login_success_usernameAndPasswordPassedToEndpoint() {
        success();
        ArgumentCaptor<String> ac =ArgumentCaptor.forClass(String.class);
        SUT.onLoginClick(USERNAME, PASSWORD);
        verify(dataManagerMock, times(1)).doOnLogin(ac.capture(), ac.capture());
        List<String> captures = ac.getAllValues();
        assertThat(captures.get(0), is(USERNAME));
        assertThat(captures.get(1), is(PASSWORD));
    }

    @Test
    public void login_success_tokenCached() throws Exception {
        success();
        SUT.onLoginClick(USERNAME, PASSWORD);
        mTestScheduler.triggerActions();
        verify(dataManagerMock).updateAuthToken(TOKEN);
    }

    @Test
    public void login_success_successReturned() {
        success();
        SUT.onLoginClick(USERNAME, PASSWORD);
        mTestScheduler.triggerActions();
        verify(mLoginCallback).onLoginSuccess();
    }

    @Test
    public void onTextChange_success_navigate() {
        SUT.onTextChange(USERNAME);
        verify(mLoginCallback).onTextChange(USERNAME);
    }

    @Test
    public void checkRemember_success_cached() {
        SUT.onRememberClick(true, USERNAME, PASSWORD);
        verify(dataManagerMock).rememberUser(USERNAME, PASSWORD);
    }

    @Test
    public void checkRemoveRemember_success_remove() {
        SUT.onRememberClick(false, USERNAME, PASSWORD);
        verify(dataManagerMock).removeRememberUser(USERNAME);
    }

    @Test
    public void getRemember_user() {
        doReturn(PASSWORD).when(dataManagerMock).getRememberUser(USERNAME);
        SUT.checkRememberUser(USERNAME);
        verify(mLoginCallback).setPasswordFromRemember(PASSWORD);
    }
    
    private void success() {
        LoginResponse loginResponse = new LoginResponse(TOKEN);
        doReturn(Single.just(loginResponse))
                .when(dataManagerMock)
                .doOnLogin(USERNAME, PASSWORD);
    }
}