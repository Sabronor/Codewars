package Kata.Seven;


/**
 * Implement a function that adds two numbers together and returns their sum in binary.
 * The conversion can be done before, or after the addition.
 * The binary number returned should be a string.
 */
public class Binary {
    public static String binaryAddition(int a, int b){
        return Integer.toString(a + b, 2);
    }
}
