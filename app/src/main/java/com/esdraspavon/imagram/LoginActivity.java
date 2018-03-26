package com.esdraspavon.imagram;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.esdraspavon.imagram.view.ContainerActivity;
import com.esdraspavon.imagram.view.CreateAccountActivity;

public class LoginActivity extends AppCompatActivity {

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
    }
    public void goCreateAccount(View view){
        //Intent es cuando queremos unir dos componentes en una aplicacion
        //En este caso dos activity
        //El primer parametro es donde estoy ubicado
        //El segundo parametro es a donde quiero ir
        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);
    }
    public void goHome(View view){
        Intent intent = new Intent(this, ContainerActivity.class);
        startActivity(intent);
    }
}

