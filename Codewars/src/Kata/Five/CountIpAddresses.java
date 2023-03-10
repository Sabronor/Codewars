package Kata.Five;

/**
 * Implement a function that receives two IPv4 addresses, and returns the number of addresses between them
 * (including the first one, excluding the last one).
 *
 * All inputs will be valid IPv4 addresses in the form of strings. The last address will always be greater
 * than the first one.
 *
 * Examples
 * * With input "10.0.0.0", "10.0.0.50"  => return   50
 * * With input "10.0.0.0", "10.0.1.0"   => return  256
 * * With input "20.0.0.10", "20.0.1.0"  => return  246
 */
public class CountIpAddresses {
    public static long ipsBetween(String start, String end) {
        return calcAddress(end) - calcAddress(start);
    }

    private static long calcAddress(String address){
        String[] nums = address.split("\\.");
        long x = 0;


        for(int i = 3, n = 0; n < nums.length; i--, n++)
            x += Integer.parseInt(nums[n]) * Math.pow(256, i);


        return x;
    }
}
