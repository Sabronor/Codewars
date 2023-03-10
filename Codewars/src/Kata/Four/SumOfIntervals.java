package Kata.Four;

/**
 * Write a function called sumIntervals/sum_intervals that accepts an array of intervals, and returns the sum of all the
 * interval lengths. Overlapping intervals should only be counted once.
 *
 * Intervals
 * Intervals are represented by a pair of integers in the form of an array. The first value of the interval will always be
 * less than the second value. Interval example: [1, 5] is an interval from 1 to 5. The length of this interval is 4.
 *
 * Overlapping Intervals
 * List containing overlapping intervals:
 *
 * [
 *    [1, 4],
 *    [7, 10],
 *    [3, 5]
 * ]
 * The sum of the lengths of these intervals is 7. Since [1, 4] and [3, 5] overlap, we can treat the interval as [1, 5], which
 * has a length of 4.
 *
 * Examples:
 * sumIntervals( [
 *    [1, 2],
 *    [6, 10],
 *    [11, 15]
 * ] ) => 9
 *
 * sumIntervals( [
 *    [1, 4],
 *    [7, 10],
 *    [3, 5]
 * ] ) => 7
 *
 * sumIntervals( [
 *    [1, 5],
 *    [10, 20],
 *    [1, 6],
 *    [16, 19],
 *    [5, 11]
 * ] ) => 19
 *
 * sumIntervals( [
 *    [0, 20],
 *    [-100000000, 10],
 *    [30, 40]
 * ] ) => 100000030
 * Tests with large intervals
 * Your algorithm should be able to handle large intervals. All tested intervals are subsets of the range
 * [-1000000000, 1000000000].
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class SumOfIntervals {
    public static int sumIntervals(int[][] intervals){
        //Удаляются копии и сортируется по начальным точкам интервала
        List<int[]> temp = Arrays.stream(intervals)
                .distinct()
                .sorted(Comparator.comparingInt(a -> a[0]))
                .collect(Collectors.toList());


        //Объединяются пересекющиеся интервалы
        for(int i = 0; i < temp.size() - 1; i++){

            while ( !(temp.size() == i + 1) && (temp.get(i)[1] >= temp.get(i + 1)[0]) )
                temp.add(i, calculateNewInterval(temp.remove(i), temp.remove(i)));

        }

        return IntStream.of( temp.stream().mapToInt(a -> a[1] - a[0]).toArray() ).sum();
    }

    //Создание интервала из двух пересекающихся
    public static int[] calculateNewInterval(int[] first, int[] second){
        first[1] = Math.max(first[1], second[1]);
        return first;
    }
}
