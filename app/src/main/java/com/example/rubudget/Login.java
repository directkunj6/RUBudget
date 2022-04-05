package com.example.rubudget;

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

public class Login extends AppCompatActivity {

    EditText  mEmail, mPassword;
    Button mLoginBtn;
    FirebaseAuth fAuth;
    TextView mRegisterBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mEmail = findViewById(R.id.email2);
        mPassword = findViewById(R.id.password2);
        mLoginBtn = findViewById(R.id.loginBtn);
        mRegisterBtn = findViewById(R.id.RegisterBtn);

        fAuth = FirebaseAuth.getInstance();


        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = mEmail.getText().toString().trim();
                String Password = mPassword.getText().toString().trim();

                if(TextUtils.isEmpty(Email)){
                    mEmail.setError("Email is Required");
                    return;
                }

                if(TextUtils.isEmpty(Password)){
                    mPassword.setError("Password is Required");
                    return;
                }


                fAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Login.this,"Login is succesfull", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Home.class));
                        }

                    }
                });

            }
        });

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Register.class));
            }
        });
    }
}