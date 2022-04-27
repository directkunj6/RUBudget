package com.example.rubudget;

public class ReadWriteUserDetails {
    public String Fullname, Email, PhoneNumber;
    public long Tokens;

    public ReadWriteUserDetails(String textFullName, String textEmail, String textPhoneNumber, long Number_of_tokens ){
        this.Fullname = textFullName;
        this.Email = textEmail;
        this.PhoneNumber = textPhoneNumber;
        this.Tokens = Number_of_tokens;
    }




}


