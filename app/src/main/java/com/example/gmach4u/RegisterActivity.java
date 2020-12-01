package com.example.gmach4u;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthEmailException;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private  EditText userName, userPassword, userEmail;
    private Button regButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setUIViews();



        regButton.setOnClickListener(new View.OnClickListener() {
            FirebaseAuth fireBaseAuth= FirebaseAuth.getInstance();
            @Override
            public void onClick(View v) {
                 if(validate()){
                    String user_email=userEmail.getText().toString().trim();
                    String user_password=userPassword.getText().toString().trim();

                    fireBaseAuth.createUserWithEmailAndPassword(user_email,user_password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {
                                Toast.makeText(RegisterActivity.this, "regist success", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegisterActivity.this,MainActivity.class));
                            } else{
                                Toast.makeText(RegisterActivity.this, "regist not success", Toast.LENGTH_SHORT).show();
                                task.getException();
                            }//end else
                        }//end Oncomplete
                    });//end email and password
                 }//end if
            }//end on click
        });//end click listener



    }//end onCreate




    private void setUIViews(){
        userName= (EditText) findViewById(R.id.fullName);
        userPassword= (EditText) findViewById(R.id.password1);
        userEmail= (EditText) findViewById(R.id.email1);
        regButton=(Button) findViewById(R.id.submit);
    }

    private boolean validate(){
        Boolean result=false;

        String name= userName.getText().toString();
        String password= userPassword.getText().toString();
        String email= userEmail.getText().toString();

        if(name.isEmpty() && password.isEmpty() && email.isEmpty()){
            Toast.makeText(this,"please",Toast.LENGTH_SHORT).show();
        }else{
            result=true;
        }
        return result;
    }
}//end class
