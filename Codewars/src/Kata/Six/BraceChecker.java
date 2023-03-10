package Kata.Six;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Write a function that takes a string of braces, and determines if the order of the braces is valid.
 * It should return true if the string is valid, and false if it's invalid.
 *
 * This Kata is similar to the Valid Parentheses Kata, but introduces new characters: brackets [], and curly braces {}.
 * Thanks to @arnedag for the idea!
 *
 * All input strings will be nonempty, and will only consist of parentheses, brackets and curly braces: ()[]{}.
 *
 * What is considered Valid?
 * A string of braces is considered valid if all braces are matched with the correct brace.
 *
 * Examples
 * "(){}[]"   =>  True
 * "([{}])"   =>  True
 * "(}"       =>  False
 * "[(])"     =>  False
 * "[({})](]" =>  False
 */
public class BraceChecker {
    public boolean isValid(String str) {
        HashMap<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');

        Deque<Character> stack = new LinkedList<>();
        for(char c : str.toCharArray()){
            if(brackets.containsValue(c)){
                stack.push(c);
            }else if(brackets.containsKey(c)){
                if(stack.isEmpty() || stack.pop() != brackets.get(c)) return false;
            }
        }

        return stack.isEmpty();
    }
}
