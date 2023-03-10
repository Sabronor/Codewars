package Kata.Four;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * We need to sum big numbers, and we require your help.
 *
 * Write a function that returns the sum of two numbers. The input numbers are strings and the function must return a string.
 *
 * Example
 * add("123", "321"); -> "444"
 * add("11", "99");   -> "110"
 * Notes
 * - The input numbers are big.
 * - The input is a string of only digits
 * - The numbers are positives
 */
public class AddingBigNumbers {
    public static String add(String a, String b){
        Deque<Integer> larger = a.length() > b.length() ? getStack(a) : getStack(b);
        Deque<Integer> smaller = a.length() > b.length() ? getStack(b) : getStack(a);

        Deque<Integer> result = new LinkedList<>();

        while (!smaller.isEmpty()){
            result.push(smaller.pop() + larger.pop());
        }

        while (!larger.isEmpty()) result.push(larger.pop());

        Integer[] integers = result.toArray(new Integer[0]);

        for(int i = integers.length - 1; i >= 0; i--){
            if(integers[i] >= 10 && i != 0){
                integers[i - 1] += integers[i] / 10;
                integers[i] %= 10;
            }
        }

        String ret = Arrays.stream(integers).map(String::valueOf).collect(Collectors.joining());
        while (ret.charAt(0) == '0') ret = ret.substring(1);

        return ret;
    }

    private static Deque<Integer> getStack(String string){
        Deque<Integer> returnDeque = new LinkedList<>();
        Arrays.stream(string.split("")).map(Integer::parseInt).forEach(returnDeque::push);

        return returnDeque;
    }
}
