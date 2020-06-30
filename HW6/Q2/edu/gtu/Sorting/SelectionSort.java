package edu.gtu.Sorting;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class SelectionSort {

    private static int comparisionAmount;
    private static int swapAmount;
    private static long runTime;
    private static long expectedRuntime;

    /** Sort the array using selection sort algorithm.
     @pre table contains Comparable objects.
     @post table is sorted.
     @param table The array to be sorted
     */
    public static <E extends Comparable< ? super E>> void sort( E[] table) {

        Instant start = Instant.now();

        int n = table.length;

        for( int fill = 0 ; fill < n -1 ; ++fill ) {
            int posMin = fill;

            for( int next = fill + 1 ; next < n ; ++next ) {
                if( table[next].compareTo(table[posMin]) < 0 ) {
                    posMin = next;
                }
            }

            E temp = table[fill];
            table[fill] = table[posMin];
            table[posMin] = temp;
        }

        Instant end = Instant.now();

        runTime = Duration.between( start , end ).toMillis();
        swapAmount = 0;
        comparisionAmount = 0;
        expectedRuntime = 0;

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

