package com.example.rubudget;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Savings extends AppCompatActivity {

    SeekBar mSavingsSeekBar;
    TextView mSavingsInvestments;
    DatabaseReference mDatabase;
    Button mSave_User_Savings_Information;
    public long SavingsValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savings);
        mSavingsSeekBar=findViewById(R.id.savingsSeekBar);
        mSavingsInvestments=findViewById(R.id.savingsInvestments);

        mSave_User_Savings_Information = findViewById(R.id.user_Savings_Information);

        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Registered Users").child(userId).child("Savings");

        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               SavingsValue=snapshot.child("Savings").getValue(Long.class);
               mSavingsSeekBar.setProgress((int) SavingsValue);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mSavingsSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mSavingsInvestments.setText("Savings & Investments " + String.valueOf(i));
                SavingsValue=Long.valueOf(i);
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
                ReadWriteUserSavings readWriteUserSavings = new ReadWriteUserSavings(SavingsValue);
                mDatabase.child(userId).child("Savings").setValue(readWriteUserSavings);
                Toast.makeText(getApplicationContext(), "Values have been saved!",
                        Toast.LENGTH_LONG).show();
            }
        });

    }
}