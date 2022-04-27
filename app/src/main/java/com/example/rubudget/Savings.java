package com.example.rubudget;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.format.DateFormat;
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

import java.util.Date;

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


                mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        Date date = new Date();
                        int today = Integer.parseInt(DateFormat.format("dd",   date).toString());
                        long lastCheck = snapshot.child(userId).child("Saving Date").getValue(Long.class);

                        if(lastCheck == 0 || today > lastCheck){

                            lastCheck = (long) today;
                            String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
                            mDatabase = FirebaseDatabase.getInstance().getReference().child("Registered Users").child(userId);
                            mDatabase.child("Saving Date").setValue(lastCheck);

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


                ReadWriteUserSavings readWriteUserSavings = new ReadWriteUserSavings(SavingsValue);
                mDatabase.child(userId).child("Savings").setValue(readWriteUserSavings);
                Toast.makeText(getApplicationContext(), "Values have been saved!",
                        Toast.LENGTH_LONG).show();
            }
        });

    }

}
