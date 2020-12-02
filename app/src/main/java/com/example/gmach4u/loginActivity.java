package com.example.gmach4u;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class loginActivity extends AppCompatActivity implements View.OnClickListener {
    Button login,clientRegist,supplierRegist;
    FirebaseDatabase mDatabase ;
    DatabaseReference dbRootRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login=(Button)findViewById(R.id.login);
        login.setOnClickListener(this);

        clientRegist=(Button)findViewById(R.id.clientRegist);
        clientRegist.setOnClickListener(this);

        supplierRegist=(Button)findViewById(R.id.supplierRegist);
        supplierRegist.setOnClickListener(this);

        mDatabase = FirebaseDatabase.getInstance();
    }

    @Override
    public void onClick(View v) {
        if(login==v){
            openLoginClient();
        }
        if(clientRegist==v){
            openClientRegister();
        }
        if(supplierRegist==v){
            openSupplierRegister();
        }

    }
    public void openLoginClient(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void openClientRegister(){
        Intent intent = new Intent(this, ClientRegister.class);
        startActivity(intent);
    }
    public void openSupplierRegister(){
        Intent intent = new Intent(this, SupplierRegister.class);
        startActivity(intent);
    }
}