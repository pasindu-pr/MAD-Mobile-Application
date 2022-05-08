package com.mobileapplicationdevelopment.dogvio.utils;

public class Validator {
    public boolean isAlpha(String str){
        return str.matches("[a-zA-Z]+");
    }

    public boolean isNumeric(String str) {
        return str.matches("[0-9]+");
    }

    public boolean isValidDate(String date){
        return  date.matches("^\\d{4}\\/(0[1-9]|1[0-2])\\/(0[1-9]|[12][0-9]|3[01])$");
    }


    public boolean isValidContactNumber(String contactNumber){
        return contactNumber.matches("^(\\+\\d{1,2}\\s?)?1?\\-?\\.?\\s?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$");
    }
}
