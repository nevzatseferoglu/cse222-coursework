package edu.gtu.Sorting;


import java.time.Duration;
import java.time.Instant;

public class BubbleSort {

    private static int comparisionAmount;
    private static int swapAmount;
    private static long runTime;
    private static long expectedRuntime;


    /**
     * Sort the given array.
     * @param table Given array
     * @param <E> item that implements Comparable interface.
     */
    public static <E extends Comparable< ? super E>> void sort( E[] table ) {

        Instant start = Instant.now();

        int pass = 1;

        boolean exchanges = false;
        do {
            exchanges = false;

            for( int i = 0 ;i < table.length - pass ; ++i ) {
                if( table[i].compareTo(table[i+1]) > 0 ) {

                    E temp = table[i];
                    table[i] = table[i + 1];
                    table[i + 1] = temp;

                    exchanges = true;
                }
            }
            pass++;
        } while ( exchanges );

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
