package com.example.rubudget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class Needs extends AppCompatActivity {

    SeekBar mMortgageSeekBar, mGroceriesSeekBar, mUtilitiesSeekBar, mInusranceSeekBar, mHealthandFitnessSeekBar, mTransportationSeekBar, mDebtSeekBar, mMiscSeekBar;
    TextView mHousing, mGroceries, mUtilities, mInsurance, mHealthandFitness, mTransportation, mDebt, mMisc;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_needs);

        mMortgageSeekBar = findViewById(R.id.mortgageSeekBar);
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

        mMortgageSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mHousing.setText("Housing " + String.valueOf(i));
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
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}