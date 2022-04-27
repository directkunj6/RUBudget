package com.example.rubudget;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;

public class Login extends AppCompatActivity {

    EditText  mEmail, mPassword;
    Button mLoginBtn;
    FirebaseAuth fAuth;
    TextView mRegisterBtn;

    DatabaseReference mDatabase;



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

                            String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
                            mDatabase = FirebaseDatabase.getInstance().getReference().child("Registered Users");


                            mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {

                                    Date date = new Date();
                                    int today = Integer.parseInt(DateFormat.format("dd",   date).toString());
                                    long lastCheck = snapshot.child(userId).child("Login Date").getValue(Long.class);

                                    if(lastCheck == 0 || today > lastCheck){

                                        lastCheck = (long) today;
                                        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
                                        mDatabase = FirebaseDatabase.getInstance().getReference().child("Registered Users").child(userId);
                                        mDatabase.child("Login Date").setValue(lastCheck);

                                        long Tokens = snapshot.child(userId).child("Tokens").getValue(Long.class);
                                        Tokens = Tokens + 5 ;

                                        mDatabase.child("Tokens").setValue(Tokens);
                                        Toast.makeText(getApplicationContext(),"you got 5 tokens!",Toast.LENGTH_SHORT).show();
                                    }

                                    else{
                                        Toast.makeText(getApplicationContext(),"Can't get anymore tokens",Toast.LENGTH_SHORT).show();

                                    }
                                }


                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });

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