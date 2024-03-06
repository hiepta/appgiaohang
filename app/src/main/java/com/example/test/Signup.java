package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    TextView UserNameSignUp;
    TextView PasswordSignUp;
    TextView ConfirmPasswordSignUp;
    Button SignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        UserNameSignUp = findViewById(R.id.UserNameSignUp);
        PasswordSignUp = findViewById(R.id.PasswordSignUp);
        ConfirmPasswordSignUp = findViewById(R.id.ConfirmPasswordSignUp);
        SignUp = findViewById(R.id.SignUp);
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(UserNameSignUp.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Bạn chưa nhập username",Toast.LENGTH_LONG).show();
                }
                else if(PasswordSignUp.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Bạn chưa nhập password",Toast.LENGTH_LONG).show();
                }
                else if(ConfirmPasswordSignUp.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Bạn chưa nhập confirm password",Toast.LENGTH_LONG).show();
                }
                else if(!PasswordSignUp.equals(ConfirmPasswordSignUp)) {
                    Intent myIntent = new Intent(Signup.this,Slogan.class);
                    startActivity(myIntent);
                }else{
                    Toast.makeText(getApplicationContext(),"Đăng nhập thất bại",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}