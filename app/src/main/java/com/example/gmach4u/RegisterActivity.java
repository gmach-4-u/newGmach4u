package com.example.gmach4u;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    Button submit;
    TextView phone, password, name, email;

    FirebaseDatabase RootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        submit = (Button) findViewById(R.id.submit);
        phone = (TextView)findViewById(R.id.phone);
        email = (TextView) findViewById(R.id.email);
        password = (TextView) findViewById(R.id.password);
        name = (TextView)findViewById(R.id.name);

        submit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==submit) {
            RootNode = FirebaseDatabase.getInstance();
            reference = RootNode.getReference("Users");


            String Name = name.getText().toString();
            String Email = email.getText().toString();
            String Phone = phone.getText().toString();
            String Password = password.getText().toString();



            userHelper user = new userHelper(Name, Password, Email, Phone);
            user.phone=reference.push().getKey();

            user.setEmail(Email);
            user.setName(Name);
            user.setPassword(Password);
            user.setPhone(Phone);

            reference.child(Phone).setValue(user);

            Intent intent = new Intent(this,loginActivity.class);
            startActivity(intent);
        }
    }
}