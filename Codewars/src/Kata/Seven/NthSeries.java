package Kata.Seven;

/**
 * Your task is to write a function which returns the sum of following series upto nth term(parameter).
 * Series: 1 + 1/4 + 1/7 + 1/10 + 1/13 + 1/16 +...
 * Rules:
 * You need to round the answer to 2 decimal places and return it as String.
 * If the given value is 0 then it should return 0.00
 * You will only be given Natural Numbers as arguments.
 */

public class NthSeries {
    public static String seriesSum(int n){
        double temp = 1;

        for(int i = 0, divider = 4; i < n - 1; i++, divider += 3){
            temp += 1.0 / divider;
        }

        return String.format("%.2f", temp);
    }
}
