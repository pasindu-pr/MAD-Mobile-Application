package com.mobileapplicationdevelopment.dogvio;

public class PackagePrice {
    protected float getpackagePriceOne(Float val1 , Float val2){ //calculation for package one
        Float ans = (val1*val2*3);
        return ans;
    }
    protected float getpackagePriceTwo(Float val1 , Float val2){//calculation for package two
        Float ans = (val1*val2*10);
        return ans;
    }
    protected float getpackagePriceThree(Float val1 , Float val2){//calculation for package three
        Float ans = (val1*val2*15);
        return ans;
    }
    protected float getpackagePriceFour(Float val1 , Float val2){//calculation for package four
        Float ans = (val1*val2*20);
        return ans;
    }
}
