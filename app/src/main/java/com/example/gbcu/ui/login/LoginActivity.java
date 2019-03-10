package com.example.gbcu.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gbcu.BR;
import com.example.gbcu.R;
import com.example.gbcu.ViewModelProviderFactory;
import com.example.gbcu.databinding.ActivityLoginBinding;
import com.example.gbcu.ui.base.BaseActivity;
import com.example.gbcu.ui.list.NewsListActivity;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProviders;

public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel> implements LoginNavigator {
    @Inject
    ViewModelProviderFactory factory;
    private LoginViewModel mLoginViewModel;
    private ActivityLoginBinding mActivityLoginBinding;

    public static Intent newIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public LoginViewModel getViewModel() {
        mLoginViewModel = ViewModelProviders.of(this, factory).get(LoginViewModel.class);
        return mLoginViewModel;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityLoginBinding = getViewDataBinding();
        mLoginViewModel.setNavigator(this);
        mLoginViewModel.checkToken();
    }

    @Override
    public void onTextChange(CharSequence text) {
        TextView loginBtn = mActivityLoginBinding.btnLogin;
        Switch switchBtn = mActivityLoginBinding.switchRemember;
        String userName = mActivityLoginBinding.etUserName.getText().toString();
        String password = mActivityLoginBinding.etPassword.getText().toString();

        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)) {
            loginBtn.setEnabled(false);
            switchBtn.setEnabled(false);
            loginBtn.setBackground(ContextCompat.getDrawable(this, R.drawable.round_corner_button_bg_disable));
        } else {
            loginBtn.setEnabled(true);
            switchBtn.setEnabled(true);
            loginBtn.setBackground(ContextCompat.getDrawable(this, R.drawable.round_corner_button_bg_active));
        }

        if (text.toString().equals(userName) && TextUtils.isEmpty(password)) {
            mLoginViewModel.checkRememberUser(userName);
        }
    }

    @Override
    public void onLoginSuccess() {
        Intent intent = NewsListActivity.newIntent(this);
        startActivity(intent);
        finish();
    }

    @Override
    public void onLoginFail() {
        mActivityLoginBinding.etPassword.requestFocus();
        Toast.makeText(this, "Signon information is not recognized", Toast.LENGTH_LONG).show();
    }

    @Override
    public void setPasswordFromRemember(String savedPassword) {
        if (!TextUtils.isEmpty(savedPassword)) {
            mActivityLoginBinding.etPassword.setText(savedPassword);
            if (!mActivityLoginBinding.switchRemember.isChecked()) {
                mActivityLoginBinding.switchRemember.setChecked(true);
            }
        } else {
            mActivityLoginBinding.switchRemember.setChecked(false);
        }
    }
}
