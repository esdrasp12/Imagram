package com.esdraspavon.imagram.login.presenter;

/**
 * Created by Esdras on 26/3/2018.
 */

public interface LoginPresenter {

        //Interactor
    void signIn(String username, String password);
    void loginSuccess();
    void loginError(String error);
}
