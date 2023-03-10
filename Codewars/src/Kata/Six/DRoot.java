package Kata.Six;

/**
 * Digital root is the recursive sum of all the digits in a number.
 * Given n, take the sum of the digits of n. If that value has more than one digit,
 * continue reducing in this way until a single-digit number is produced. The input will be a non-negative integer.
 */
public class DRoot {
    public static int digital_root(int n) {
        String number = Integer.toString(n);
        int sum = 0;

        for(char i : number.toCharArray()){
            sum+= Integer.parseInt(Character.toString(i));
        }
        if(sum > 9){
            sum = digital_root(sum);
        }
        return sum;
    }
}
