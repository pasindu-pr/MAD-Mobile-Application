package com.mobileapplicationdevelopment.dogvio;

public class HealthCare_BMI_Calc {

    protected float maleBmi(float height, float weight){
        Float ans = (height/weight) + 10;
        return ans;
    }

    protected float femaleBmi(float height, float weight){
        Float ans = (height/weight) + 5;
        return ans;
    }

}