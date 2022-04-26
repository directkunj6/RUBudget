package com.example.rubudget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Savings extends AppCompatActivity {

    SeekBar mSavingsSeekBar;
    TextView mSavingsInvestments;
    String textSavingsInvestments;
    DatabaseReference mDatabase;
    Button mSave_User_Savings_Information;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savings);
        mSavingsSeekBar=findViewById(R.id.savingsSeekBar);
        mSavingsInvestments=findViewById(R.id.savingsInvestments);

        mSave_User_Savings_Information = findViewById(R.id.user_Savings_Information);

        mSavingsSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mSavingsInvestments.setText("Savings & Investments " + String.valueOf(i));
                textSavingsInvestments = mSavingsInvestments.getText().toString().trim();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });
        mSave_User_Savings_Information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
                mDatabase = FirebaseDatabase.getInstance().getReference().child("Registered Users");
                ReadWriteUserSavings readWriteUserSavings = new ReadWriteUserSavings(textSavingsInvestments);
                mDatabase.child(userId).child("Savings").setValue(readWriteUserSavings);
            }
        });

    }
}