package com.example.gmach4u;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button enter;
Button join;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enter=(Button)findViewById(R.id.enter);
     //   button2=(Button)findViewById(R.id.button2);
        join=(Button)findViewById(R.id.register);
//        welcome=(TextView)findViewById(R.id.txtwelcome);
        enter.setOnClickListener(this);
      //  button2.setOnClickListener(this);
        join.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(join==v){
            openLoginClient();
        }

    }
    public void openLoginClient(){
        Intent intent = new Intent(this,loginClient.class);
        startActivity(intent);
    }
}