package Kata.Six;

/**
 * Write a simple parser that will parse and run Deadfish.
 *
 * Deadfish has 4 commands, each 1 character long:
 *
 * i increments the value (initially 0)
 * d decrements the value
 * s squares the value
 * o outputs the value into the return array
 * Invalid characters should be ignored.
 *
 * Deadfish.parse("iiisdoso") =- new int[] {8, 64};
 */
public class DeadFish {
    public static int[] parse(String str) {
        int[] nums = new int[str.length() - str.replaceAll("o", "").length()];

        for(int i = 0, num = 0, count = 0; i < str.length(); i++){
            switch(str.split("")[i]){
                case "i" -> num++;
                case "s" -> num *= num;
                case "o" -> nums[count++] = num;
                case "d" -> num--;
            }
        }

        return nums;

    }
}
