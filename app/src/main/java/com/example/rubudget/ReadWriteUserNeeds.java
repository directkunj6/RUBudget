package com.example.rubudget;

public class ReadWriteUserNeeds {
    public String Housing, Groceries, Utilities, Insurance, HealthandFitness, Transportation, Debt, Misc;

    public ReadWriteUserNeeds(String textHousing, String textGroceries, String textUtilities,String textInsurance,String textHealthandFitness,String textTransportation,String textDebt,String textMisc){
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
