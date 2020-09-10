package com.esdraspavon.imagram.login.view;

import android.view.View;

/**
 * Created by Esdras on 26/3/2018.
 */

public interface LoginView {

    void enableInputs();
    void disableInputs();

    void showProgressBar();
    void hideProgressBar();

    void loginError(String error);

    void goCreateAccount();
    void goHome();
}
