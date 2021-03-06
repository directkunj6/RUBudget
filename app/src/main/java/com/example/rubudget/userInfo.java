package com.example.rubudget;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class userInfo extends AppCompatActivity {

        Button mSave_User_Income_Information;
        String textIncomeInfo;
        DatabaseReference mDatabase;
        EditText mIncomeText;
        Long incomeInfo;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_user_info);

            mIncomeText= findViewById(R.id.monthlyIncome);
            mSave_User_Income_Information = findViewById(R.id.user_Income_Information);

            String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
            mDatabase = FirebaseDatabase.getInstance().getReference().child("Registered Users").child(userId);

            mDatabase.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    long income = snapshot.child("Income").getValue(Long.class);
                   String IncomeText = String.valueOf(income);
                   mIncomeText.setText(IncomeText);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
            mSave_User_Income_Information.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    textIncomeInfo= mIncomeText.getText().toString().trim();
                    incomeInfo= Long.valueOf(textIncomeInfo);
                    String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
                    mDatabase = FirebaseDatabase.getInstance().getReference().child("Registered Users");
                    mDatabase.child(userId).child("Income").setValue(incomeInfo);
                }
            });
        }
    }
