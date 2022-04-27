package com.example.rubudget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    Button mNeedsBtn, mLogoutBtn, mWantsBtn, mSavingsBtn, mSettingsBtn,mTokensBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mNeedsBtn = findViewById(R.id.needs);
        mLogoutBtn = findViewById(R.id.Logout);
        mWantsBtn=findViewById(R.id.wants);
        mSavingsBtn=findViewById((R.id.savings));
        mSettingsBtn=findViewById(R.id.settings);
        mTokensBtn=findViewById(R.id.tokens);
        mLogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Login.class));

            }
        });

        mNeedsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Needs.class));
            }
        });
        mWantsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),wants.class));
            }
        });
        mSavingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Savings.class));
            }
        });
        mSettingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),userInfo.class));
            }
        });
        mTokensBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Tokens.class));
            }
        });

    }
}