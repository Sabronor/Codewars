package Kata.Seven;

import java.util.Arrays;

/**
 * Check to see if a string has the same amount of 'x's and 'o's.
 * The method must return a boolean and be case insensitive. The string can contain any char.
 */

public class XO {
    public static boolean getXO(String str){
        String[] array = str.split("");

        return  Arrays.stream(array).filter(s -> s.equalsIgnoreCase("x")).count()
                ==
                Arrays.stream(array).filter(s -> s.equalsIgnoreCase("o")).count();
    }
}
