package com.esdraspavon.imagram.login.repository;

import com.esdraspavon.imagram.login.presenter.LoginPresenter;

/**
 * Created by Esdras on 26/3/2018.
 */

public class LoginRepositoryImpl implements LoginRepository{

    private LoginPresenter presenter;

    public LoginRepositoryImpl(LoginPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void signIn(String username, String password) {

        boolean success=true;
        if (success){
            presenter.loginSuccess();
        }else {
            presenter.loginError("Ocurrió un error");
        }
    }
}
