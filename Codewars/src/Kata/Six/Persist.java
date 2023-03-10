package Kata.Six;

/**
 * Write a function, persistence, that takes in a positive parameter num
 * and returns its multiplicative persistence, which is the number of times
 * you must multiply the digits in num until you reach a single digit.
 */
public class Persist {
    public static int persistence(long x){
        for(int i = 0; ; i++){
            if(x < 10) return i;

            x = solution(x);
        }
    }

    public static int solution(long x){
        if(x < 10) return (int) x;
        else return (int) (x % 10) * solution(x / 10);
    }
}
