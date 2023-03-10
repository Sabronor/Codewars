package Kata.Six;

/**
 * In this simple Kata your task is to create a function that turns a string into a Mexican Wave.
 * You will be passed a string and you must return that string in an array where an uppercase
 * letter is a person standing up.
 * Rules
 *  1.  The input string will always be lower case but maybe empty.
 *  2.  If the character in the string is whitespace then pass over it as if it was an empty seat
 *
 * Example
 * wave("hello") => {"Hello", "hEllo", "heLlo", "helLo", "hellO"}
 */

public class MexicanWave {
    public static String[] wave(String str){
        if(str.length() == 0) return new String[0];

        String[] stringsWave = new String[str.replaceAll(" ", "").length()];

        for (int i = 0, n = 0; i < stringsWave.length; i++){
            while(str.split("")[i + n].equals(" ")) n++;
            stringsWave[i] = letterUp(str, i + n);
        }

        return stringsWave;
    }

    public static String letterUp(String str, int index){
        String[] splitString = str.split("");

        splitString[index] = splitString[index].toUpperCase();

        return String.join("", splitString);
    }
}
