package Programmeren2.Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import Programmeren2.Logic.Validation.MaiLValidation;

public class EmailTests {
    @Test
    public void TestEmailIsNotValid(){
        //Arrange
        MaiLValidation maiLValidation = new MaiLValidation();

        //Act
        boolean isMailValid = maiLValidation.validateMailAddress("mailAddress");

        //Assert
        assertEquals(false, isMailValid);
    }

    @Test
    public void TestEmailIsValid(){
        //Arrange
        MaiLValidation maiLValidation = new MaiLValidation();

        //Act
        boolean isMailValid = maiLValidation.validateMailAddress("Peter.HooijDonk@Gmail.com");

        //Assert
        assertEquals(true, isMailValid);
    }
}
