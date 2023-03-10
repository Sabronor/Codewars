package Kata.Four;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A format for expressing an ordered list of integers is to use a comma separated list of either
 *
 * individual integers
 * or a range of integers denoted by the starting integer separated from the end integer in the range by a dash, '-'.
 * The range includes all integers in the interval including both endpoints. It is not considered a range unless it spans
 * at least 3 numbers. For example "12,13,15-17"
 * Complete the solution so that it takes a list of integers in increasing order and returns a correctly formatted string
 * in the range format.
 *
 * Example:
 * Solution.rangeExtraction(new int[] {-10, -9, -8, -6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20})
 * # returns "-10--8,-6,-3-1,3-5,7-11,14,15,17-20"
 */
public class RangeExtraction {
    public static String rangeExtraction(int[] massive) {
        List<Integer> temp = new ArrayList<>();
        List<String> strings = new ArrayList<>();

        for (int i = 0 ; ; i++) {
            if (temp.isEmpty()) temp.add(massive[i]);
            else if (i < massive.length && temp.get(temp.size() - 1) + 1 == massive[i]) temp.add(massive[i]);
            else {
                strings.add(temp.size() > 2? String.format("%d-%d", temp.get(0), temp.get(temp.size() - 1)): temp.stream().map(String::valueOf).collect(Collectors.joining(",")));
                temp.clear();

                if(i == massive.length) break;

                temp.add(massive[i]);
            }
        }

        return String.join(",", strings);
    }
}
