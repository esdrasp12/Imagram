package com.esdraspavon.imagram.login.view;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.esdraspavon.imagram.R;
import com.esdraspavon.imagram.login.presenter.LoginPresenter;
import com.esdraspavon.imagram.login.presenter.LoginPresenterImpl;
import com.esdraspavon.imagram.view.ContainerActivity;
import com.esdraspavon.imagram.view.CreateAccountActivity;

public class LoginActivity extends AppCompatActivity implements LoginView{

    private TextInputEditText username, password;
    private Button login;
    private ProgressBar progressBarLogin;
    private LoginPresenter presenter;
    private TextView createHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageView logo = (ImageView) findViewById(R.id.logo);
        logo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://platzigram.com/"));
                startActivity(intent);
            }
        });
        username    =(TextInputEditText) findViewById(R.id.username);
        password    =(TextInputEditText) findViewById(R.id.password);
        login       =(Button) findViewById(R.id.login);
        progressBarLogin = (ProgressBar) findViewById(R.id.progressbarLogin);
        hideProgressBar();
        presenter = new LoginPresenterImpl(this);
        createHere = (TextView) findViewById(R.id.createHere);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if (username.equals(""))
                presenter.signIn(username.getText().toString(),password.getText().toString());
            }
        });
        createHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goCreateAccount();
            }
        });

    }

    @Override
    public void enableInputs() {
    username.setEnabled(true);
    password.setEnabled(true);
    login.setEnabled(true);
    }

    @Override
    public void disableInputs() {
        username.setEnabled(false);
        password.setEnabled(false);
        login.setEnabled(false);
    }

    @Override
    public void showProgressBar() {
        progressBarLogin.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgressBar() {
        progressBarLogin.setVisibility(View.GONE);

    }

    @Override
    public void loginError(String error) {
        Toast.makeText(this, getString(R.string.login_error)+error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goCreateAccount() {

            //Intent es cuando queremos unir dos componentes en una aplicacion
            //En este caso dos activity
            //El primer parametro es donde estoy ubicado
            //El segundo parametro es a donde quiero ir
            Intent intent = new Intent(this, CreateAccountActivity.class);
            startActivity(intent);


    }

    @Override
    public void goHome(){
            Intent intent = new Intent(this, ContainerActivity.class);
            startActivity(intent);

    }
}

