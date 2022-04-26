package com.example.rubudget;

public class ReadWriteUserNeeds {
    public long Housing, Groceries, Utilities, Insurance, HealthandFitness, Transportation, Debt, Misc;

    public ReadWriteUserNeeds(long textHousing, long textGroceries, long textUtilities,long textInsurance,long textHealthandFitness,long textTransportation,long textDebt,long textMisc){
        this.Housing = textHousing;
        this.Groceries = textGroceries;
        this.Utilities = textUtilities;
        this.Insurance = textInsurance;
        this.HealthandFitness = textHealthandFitness;
        this.Transportation = textTransportation;
        this.Debt = textDebt;
        this.Misc = textMisc;
    }

}
