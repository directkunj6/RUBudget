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

public class wants extends AppCompatActivity {


    SeekBar mRestaurantsSeekBar, mClothingSeekBar, mTravelSeekBar, mEntertainmentSeekBar, mMisc2SeekBar;
    TextView mRestaurants, mClothing, mTravel, mEntertainment, mMisc2;
    DatabaseReference mDatabase;
    Button mSave_User_Wants_Information;

    public long RestaurantsValue, ClothingValue, TravelValue, EntertainmentValue, Misc2Value;

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

        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Registered Users").child(userId).child("Wants");

        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                RestaurantsValue = snapshot.child("Restaurants").getValue(Long.class);
                ClothingValue = snapshot.child("Clothing").getValue(Long.class);
                TravelValue = snapshot.child("Travel").getValue(Long.class);
                EntertainmentValue = snapshot.child("Entertainment").getValue(Long.class);
                Misc2Value = snapshot.child("Misc2").getValue(Long.class);


                mRestaurantsSeekBar.setProgress((int) RestaurantsValue);
                mClothingSeekBar.setProgress((int) ClothingValue);
                mTravelSeekBar.setProgress((int) TravelValue);
                mEntertainmentSeekBar.setProgress((int) EntertainmentValue);
                mMisc2SeekBar.setProgress((int) Misc2Value);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        mRestaurantsSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                    mRestaurants.setText("Restaurants " + i);
                    RestaurantsValue = Long.valueOf(i);

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
                ClothingValue = Long.valueOf(i);
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
                TravelValue=Long.valueOf(i);
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
                EntertainmentValue=Long.valueOf(i);
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
                Misc2Value=Long.valueOf(i);
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
                ReadWriteUserWants readWriteUserWants = new ReadWriteUserWants(RestaurantsValue,TravelValue,ClothingValue,Misc2Value,EntertainmentValue);
                mDatabase.child(userId).child("Wants").setValue(readWriteUserWants);
                Toast.makeText(getApplicationContext(), "Values have been saved!",
                        Toast.LENGTH_LONG).show();
            }
        });

    }
}