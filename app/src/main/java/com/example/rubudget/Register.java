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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    EditText mFullName, mEmail, mPassword, mPhoneNumber;
    Button mRegisterBtn;
    TextView mLoginHereBtn;
    FirebaseAuth fAuth;

    DatabaseReference UserRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFullName = findViewById(R.id.fullName);
        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        mPhoneNumber = findViewById(R.id.phoneNumber);
        mRegisterBtn = findViewById(R.id.registerBtn);
        mLoginHereBtn = findViewById(R.id.LoginScreenBtn);

        fAuth = FirebaseAuth.getInstance();


        //if(fAuth.getCurrentUser() != null){
            //startActivity(new Intent(getApplicationContext(),MainActivity.class));
            //finish();

        //}

        mLoginHereBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = mEmail.getText().toString().trim();
                String Password = mPassword.getText().toString().trim();
                String FullName = mFullName.getText().toString().trim();
                String PhoneNumber = mPhoneNumber.getText().toString().trim();

                if(TextUtils.isEmpty(Email)){
                    mEmail.setError("Email is Required");
                    return;
                }

                if(TextUtils.isEmpty(Password)){
                    mPassword.setError("Password is Required");
                    return;
                }

                if(Password.length() < 8){
                    mPassword.setError("Password must be at least  8 or more characters long");
                    return;
                }

                fAuth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser firebaseUser = fAuth.getCurrentUser();

                            ReadWriteUserDetails writeUserDetails = new ReadWriteUserDetails(FullName, Email, PhoneNumber);

                            UserRef = FirebaseDatabase.getInstance().getReference("Registered Users");
                            UserRef.child(firebaseUser.getUid()).setValue(writeUserDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if (task.isSuccessful()){
                                        Toast.makeText(Register.this,"User is Created", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(getApplicationContext(),Home.class));

                                    }

                                    else {
                                        Toast.makeText(Register.this,"Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }


                                }
                            });

                            startActivity(new Intent(getApplicationContext(),Home.class));
                        }else {
                            Toast.makeText(Register.this,"Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });





            }
        });


    }
}