package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Signin extends AppCompatActivity {
    Button btnSignIn;
    TextView txtUserName;
    TextView txtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        txtUserName = findViewById(R.id.txtUserName);
        txtPassword = findViewById(R.id.txtPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtUserName.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Bạn chưa nhập username",Toast.LENGTH_LONG).show();
                }
                else if(txtPassword.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Bạn chưa nhập password",Toast.LENGTH_LONG).show();
                }else{
                    Intent manhinhchinh = new Intent(Signin.this,Slogan.class);
                    startActivity(manhinhchinh);
                }
            }
        });
    }
}