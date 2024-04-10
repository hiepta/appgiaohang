package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup extends AppCompatActivity {
//    TextView UserName;
    TextView EmailSignUp;
    TextView PasswordSignUp;
    Button SignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        EmailSignUp = findViewById(R.id.EmailSignUp);
        PasswordSignUp = findViewById(R.id.PasswordSignUp);
//        UserName = findViewById(R.id.txtUser);
        SignUp = findViewById(R.id.SignUp);
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email, password, user;
                email = EmailSignUp.getText().toString().trim();
                password = PasswordSignUp.getText().toString().trim();
//                user = UserName.getText().toString().trim();
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                firebaseAuth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Intent intent = new Intent(Signup.this,Signin.class);
                                    startActivity(intent);
                                }
                                else{
                                    Toast.makeText(Signup.this,"Đăng kí thất bại",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

    }
}