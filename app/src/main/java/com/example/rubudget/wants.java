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

public class wants extends AppCompatActivity {


    SeekBar mRestaurantsSeekBar, mClothingSeekBar, mTravelSeekBar, mEntertainmentSeekBar, mMisc2SeekBar;
    TextView mRestaurants, mClothing, mTravel, mEntertainment, mMisc2;
    String textRestaurants, textClothing, textTravel, textEntertainment, textMisc2;
    DatabaseReference mDatabase;
    Button mSave_User_Wants_Information;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wants);

        mRestaurantsSeekBar=findViewById(R.id.restaurantsSeekBar);
        mClothingSeekBar=findViewById(R.id.clothingSeekBar);
        mTravelSeekBar=findViewById(R.id.travelSeekBar);
        mEntertainmentSeekBar=findViewById(R.id.entertainmentSeekBar);
        mMisc2SeekBar=findViewById(R.id.misc2SeekBar);

        mRestaurants=findViewById(R.id.restaurants);
        mClothing=findViewById(R.id.clothing);
        mTravel=findViewById(R.id.travel);
        mEntertainment=findViewById(R.id.entertainment);
        mMisc2=findViewById(R.id.misc2);

        mSave_User_Wants_Information = findViewById(R.id.User_Wants_Information);

        mRestaurantsSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mRestaurants.setText("Restaurants " + String.valueOf(i));
                textRestaurants = mRestaurants.getText().toString().trim();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });
        mClothingSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mClothing.setText("Clothing " + String.valueOf(i));
                textClothing = mClothing.getText().toString().trim();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });
        mTravelSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mTravel.setText("Travel " + String.valueOf(i));
                textTravel = mTravel.getText().toString().trim();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });
        mEntertainmentSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mEntertainment.setText("Entertainment " + String.valueOf(i));
                textEntertainment = mEntertainment.getText().toString().trim();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });
        mMisc2SeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mMisc2.setText("Miscellaneous " + String.valueOf(i));
                textMisc2 = mMisc2.getText().toString().trim();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mSave_User_Wants_Information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
                mDatabase = FirebaseDatabase.getInstance().getReference().child("Registered Users");
                ReadWriteUserWants readWriteUserWants = new ReadWriteUserWants(textRestaurants, textClothing, textTravel, textEntertainment, textMisc2);
                mDatabase.child(userId).child("Wants").setValue(readWriteUserWants);
            }
        });

    }
}