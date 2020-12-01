 package com.example.gmach4u;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button login;
Button register;
FirebaseDatabase mDatabase ;
DatabaseReference dbRootRef;



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

        mDatabase = FirebaseDatabase.getInstance();
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