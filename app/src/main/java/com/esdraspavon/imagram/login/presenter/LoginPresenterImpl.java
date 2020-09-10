package com.esdraspavon.imagram.login.presenter;

import com.esdraspavon.imagram.login.interactor.LoginInteractor;
import com.esdraspavon.imagram.login.interactor.LoginInteractorImpl;
import com.esdraspavon.imagram.login.view.LoginView;

/**
 * Created by Esdras on 26/3/2018.
 */

public class LoginPresenterImpl implements LoginPresenter {

    private LoginView loginView;
    private LoginInteractor interactor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        interactor = new LoginInteractorImpl(this);
    }

    @Override
    public void signIn(String username, String password) {
        loginView.disableInputs();
        loginView.showProgressBar();

        interactor.signIn(username,password);
    }

    @Override
    public void loginSuccess() {
        loginView.goHome();

        loginView.hideProgressBar();
    }

    @Override
    public void loginError(String error) {
        loginView.enableInputs();
        loginView.hideProgressBar();
        loginView.loginError(error);
    }
}
