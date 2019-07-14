package examples.shop;

public class RomanNumerals {
    public static String convert(int n){
        if(n == 1)
            return "I";
        else if(n == 2)
            return "II";
        else if(n == 3)
            return "III";
        else if(n == 4)
            return convert(1) + convert(5);
        else if(n == 5)
            return "V";
        else if(n > 5)
            return convert(5) + convert(n - 5);

        return "";

    }
}
