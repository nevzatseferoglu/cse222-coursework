package edu.gtu.Sorting;

import java.time.Duration;
import java.time.Instant;

public class InsertionSort {

    private static int comparisionAmount;
    private static int swapAmount;
    private static long runTime;
    private static long expectedRuntime;

    /** Sort the table using insertion sort algorithm.
     pre : table contains Comparable objects.
     post : table is sorted.
     @param table The array to be sorted
     */
    public static <E extends Comparable< ? super E> > void sort( E[] table ) {

        Instant start = Instant.now();

        for (int nextPos = 1; nextPos < table.length; nextPos++) {
            insert(table, nextPos);
        }

        Instant end = Instant.now();

        runTime = Duration.between( start , end ).toMillis();
        swapAmount = 0;
        comparisionAmount = 0;
        expectedRuntime = 0;
    }


    /** Insert the element at nextPos where it belongs
     in the array.
     pre : table[0 . . . nextPos ‐ 1] is sorted.
     post: table[0 . . . nextPos] is sorted.
     @param table The array being sorted
     @param nextPos The position of the element to insert
     */
    private static <E extends Comparable< ? super E >> void insert(E[] table,
                                                         int nextPos) {
        E nextVal = table[nextPos];

        while ( (nextPos > 0) && nextVal.compareTo(table[ nextPos - 1 ]) < 0 ) {
            table[nextPos] = table[nextPos - 1] ;
            nextPos--;
        }

        table[nextPos] = nextVal;
    }

    /**
     * Clear the status
     */
    public static void clearStat( ) {
        comparisionAmount = 0;
        swapAmount = 0;
        runTime = 0;
        expectedRuntime = 0;
    }

    /**
     * Get comparision amount
     * @return comparision amount
     */
    public static int getComparisionAmount() {
        return comparisionAmount;
    }

    /**
     * Get swap amount
     * @return swap amount
     */
    public static int getSwapAmount() {
        return swapAmount;
    }

    /**
     * Get runtime
     * @return runtime
     */
    public static long getRunTime() {
        return runTime;
    }

    /**
     * Get expected runtime
     * @return expected runtime.
     */
    public static long getExpectedRuntime() {
        return expectedRuntime;
    }

}
