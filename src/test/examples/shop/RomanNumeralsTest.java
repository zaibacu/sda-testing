package examples.shop;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanNumeralsTest {
    @Test
    public void one_should_be_I(){
        assertEquals("I", RomanNumerals.convert(1));
    }

    @Test
    public void two_should_be_II(){
        assertEquals("II", RomanNumerals.convert(2));
    }

    @Test
    public void four_should_be_IV(){
        assertEquals("IV", RomanNumerals.convert(4));
    }

    @Test
    public void five_should_be_V(){
        assertEquals("V", RomanNumerals.convert(5));
    }

    @Test
    public void eight_should_be_VIII(){
        assertEquals("VIII", RomanNumerals.convert(8));
    }

    @Test
    public void seven_should_be_VII(){
        assertEquals("VII", RomanNumerals.convert(7));
    }
}
