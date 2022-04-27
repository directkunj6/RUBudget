package com.example.rubudget;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Needs extends AppCompatActivity {

    SeekBar mMortgageSeekBar, mGroceriesSeekBar, mUtilitiesSeekBar, mInusranceSeekBar, mHealthandFitnessSeekBar, mTransportationSeekBar, mDebtSeekBar, mMiscSeekBar;
    TextView mHousing, mGroceries, mUtilities, mInsurance, mHealthandFitness, mTransportation, mDebt, mMisc;
    DatabaseReference mDatabase;
    Button  mSave_User_Needs_Information;

    public long HousingValue, GroceriesValue, UtilitiesValue, InsuranceValue, HealthandFitnessValue, TransportationValue, DebtValue, MiscValue;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_needs);

        mMortgageSeekBar = findViewById(R.id.housingSeekBar);
        mGroceriesSeekBar = findViewById(R.id.groceriesSeekBar);
        mUtilitiesSeekBar = findViewById(R.id.utilitiesSeekBar);
        mInusranceSeekBar = findViewById(R.id.insuranceSeekBar);
        mHealthandFitnessSeekBar = findViewById(R.id.healthSeekBar);
        mTransportationSeekBar = findViewById(R.id.transportationSeekBar);
        mDebtSeekBar = findViewById(R.id.debtSeekBar);
        mMiscSeekBar = findViewById(R.id.miscSeekBar);

        mHousing = findViewById(R.id.housing);
        mGroceries = findViewById(R.id.groceries);
        mUtilities = findViewById(R.id.utilities);
        mInsurance = findViewById(R.id.insurance);
        mHealthandFitness = findViewById(R.id.health);
        mTransportation = findViewById(R.id.transportation);
        mDebt = findViewById(R.id.debt);
        mMisc = findViewById(R.id.misc);

        mSave_User_Needs_Information = findViewById(R.id.User_Needs_Information);


        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Registered Users").child(userId).child("Needs");



        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                HousingValue = snapshot.child("Housing").getValue(Long.class);
                GroceriesValue = snapshot.child("Groceries").getValue(Long.class);
                UtilitiesValue = snapshot.child("Utilities").getValue(Long.class);
                InsuranceValue = snapshot.child("Insurance").getValue(Long.class);
                HealthandFitnessValue = snapshot.child("HealthandFitness").getValue(Long.class);
                TransportationValue = snapshot.child("Transportation").getValue(Long.class);
                DebtValue = snapshot.child("Debt").getValue(Long.class);
                MiscValue = snapshot.child("Misc").getValue(Long.class);


                mMortgageSeekBar.setProgress((int) HousingValue);
                mGroceriesSeekBar.setProgress((int) GroceriesValue);
                mUtilitiesSeekBar.setProgress((int) UtilitiesValue);
                mInusranceSeekBar.setProgress((int) InsuranceValue);
                mHealthandFitnessSeekBar.setProgress((int) HealthandFitnessValue);
                mTransportationSeekBar.setProgress((int) TransportationValue);
                mDebtSeekBar.setProgress((int) DebtValue);
                mMiscSeekBar.setProgress((int) MiscValue);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });





        mMortgageSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mHousing.setText("Housing " + i);
                //textHousing = mHousing.getText().toString().substring(8).trim();
                HousingValue = Long.valueOf(i);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });

        mGroceriesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mGroceries.setText("Groceries " + String.valueOf(i));
                //textGroceries = mGroceries.getText().toString().trim();
                GroceriesValue = Long.valueOf(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mUtilitiesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mUtilities.setText("Utilities " + String.valueOf(i));
                //textUtilities = mUtilities.getText().toString().trim();
                UtilitiesValue = Long.valueOf(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mInusranceSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mInsurance.setText("Insurance " + String.valueOf(i));
                //textInsurance = mInsurance.getText().toString().trim();
                InsuranceValue = Long.valueOf(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mHealthandFitnessSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mHealthandFitness.setText("Health and Fitness " + String.valueOf(i));
                //textHealthandFitness = mHealthandFitness.getText().toString().trim();
                HealthandFitnessValue = Long.valueOf(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mTransportationSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mTransportation.setText("Transportation " + String.valueOf(i));
                //textTransportation = mTransportation.getText().toString().trim();
                TransportationValue = Long.valueOf(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mDebtSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mDebt.setText("Debt " + String.valueOf(i));
                //textDebt = mDebt.getText().toString().trim();
                DebtValue = Long.valueOf(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mMiscSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mMisc.setText("Miscellaneous " + String.valueOf(i));
                //textMisc = mMisc.getText().toString().trim();
                MiscValue = Long.valueOf(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mSave_User_Needs_Information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
                mDatabase = FirebaseDatabase.getInstance().getReference().child("Registered Users");
                ReadWriteUserNeeds readWriteUserNeeds = new ReadWriteUserNeeds(HousingValue,GroceriesValue, UtilitiesValue,InsuranceValue,HealthandFitnessValue, TransportationValue,DebtValue,MiscValue);
                mDatabase.child(userId).child("Needs").setValue(readWriteUserNeeds);
                Toast.makeText(getApplicationContext(), "Values have been saved!",
                        Toast.LENGTH_LONG).show();

            }
        });

    }
}