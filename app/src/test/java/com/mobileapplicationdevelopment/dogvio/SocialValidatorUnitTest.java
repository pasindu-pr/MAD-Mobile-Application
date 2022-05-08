package com.mobileapplicationdevelopment.dogvio;

import com.mobileapplicationdevelopment.dogvio.utils.Validator;

import org.junit.Test;
import org.junit.Assert;
import static com.google.common.truth.Truth.assertThat;

public class SocialValidatorUnitTest {

    @Test
//    Should return false if input string contains numeric characters
    public void testIsNumeric() {
        Validator validator = new Validator();
        boolean result = validator.isNumeric("456");
        assertThat(result).isTrue();
    }

    @Test
//    Should return false if contact number is not in valid format
    public void isValidContactNumber() {
        Validator validator = new Validator();
        boolean result = validator.isValidContactNumber("0774856952");
        assertThat(result).isTrue();
    }

    @Test
    //    Should return false if date is not in valid format
    public void isValidDateShouldReturnFalse() {
        Validator validator = new Validator();
        boolean result = validator.isValidDate("202056421");
        assertThat(result).isFalse();
    }


    @Test
    //    Should return false if word contains numbers
    public void isValidWord(){
        Validator validator = new Validator();
        boolean result = validator.isAlpha("202056421");
        assertThat(result).isFalse();
    }
}
