package Kata.Five;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * The rgb function is incomplete. Complete it so that passing in RGB decimal values will result in a hexadecimal
 * representation being returned. Valid decimal values for RGB are 0 - 255. Any values that fall out of that range must
 * be rounded to the closest valid value.
 *
 * Note: Your answer should always be 6 characters long, the shorthand with 3 will not work here.
 *
 * The following are examples of expected output values:
 */
public class RgbToHex {
    public static String rgb(int r, int g, int b) {
        return Arrays.stream(new int[] {r, g, b})
                .mapToObj(num -> Integer.toHexString( Math.max( Math.min(num, 255), 0) ).toUpperCase())
                .map(hex -> hex.length() == 2? hex : "0" + hex)
                .collect(Collectors.joining());
    }
}
