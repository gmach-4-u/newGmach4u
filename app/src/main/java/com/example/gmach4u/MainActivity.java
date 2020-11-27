package com.example.gmach4u;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button login;
Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login=(Button)findViewById(R.id.login);
     //   button2=(Button)findViewById(R.id.button2);
        register=(Button)findViewById(R.id.register);
//        welcome=(TextView)findViewById(R.id.txtwelcome);
        login.setOnClickListener(this);
      //  button2.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(login==v){
            openLoginClient();
        }
        if(register==v){
            openRegister();
        }

    }
    public void openLoginClient(){
        Intent intent = new Intent(this,loginActivity.class);
        startActivity(intent);
    }
    public void openRegister(){
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }
}