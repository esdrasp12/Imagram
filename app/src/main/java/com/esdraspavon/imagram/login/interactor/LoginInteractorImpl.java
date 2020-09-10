package com.esdraspavon.imagram.login.interactor;

import com.esdraspavon.imagram.login.presenter.LoginPresenter;
import com.esdraspavon.imagram.login.repository.LoginRepository;
import com.esdraspavon.imagram.login.repository.LoginRepositoryImpl;

/**
 * Created by Esdras on 26/3/2018.
 */

public class LoginInteractorImpl implements LoginInteractor {

    private LoginPresenter presenter;
    private LoginRepository repository;

    public LoginInteractorImpl(LoginPresenter presenter) {
        this.presenter = presenter;
        repository = new LoginRepositoryImpl(presenter);

    }

    @Override
    public void signIn(String username, String password) {
        repository.signIn(username,password);
    }
}
