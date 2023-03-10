package Kata.Six;

public class PhoneNumber {
    public static String createPhoneNumber(int[] numbers) {
        StringBuilder str = new StringBuilder("(");

        for(int i = 0; i < 3; i++){
            str.append(numbers[i]);
        }

        str.append(") ");

        for(int i = 3; i < 6; i++){
            str.append(numbers[i]);
        }

        str.append("-");

        for(int i = 6; i < numbers.length; i++){
            str.append(numbers[i]);
        }

        return str.toString();
    }
}
