package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signin extends AppCompatActivity {
    Button btnSignIn;
    TextView txtEmail;
    TextView txtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email, password;
                email = txtEmail.getText().toString().trim();
                password = txtPassword.getText().toString().trim();
                FirebaseAuth firebaseAuth_signin = FirebaseAuth.getInstance();
                firebaseAuth_signin.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {;
                                if (task.isSuccessful()) {
                                    Intent intent = new Intent(Signin.this, Manhinhchinh.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(Signin.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}