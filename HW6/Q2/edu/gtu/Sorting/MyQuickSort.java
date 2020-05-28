package edu.gtu.Sorting;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class MyQuickSort {

    private static int comparisionAmount;
    private static int swapAmount;
    private static long runTime;
    private static long expectedRuntime;

    /**
     * Sort the given list with quick sort.
     * @param list given list.
     * @param <E> Type of item that implements Comparable interface.
     */
    public static < E extends Comparable<E> > void sort( List<E> list ) {

        Instant start = Instant.now();

        sort(list, 0, list.size() - 1);

        Instant end = Instant.now();

        runTime = Duration.between( start , end ).toMillis();

        swapAmount = 0;
        comparisionAmount = 0;
        expectedRuntime = 0;
    }

    /**
     *
     * @param list List
     * @param lo low index
     * @param hi high index
     * @param <E> Type of item that implements Comparable interface.
     */
    private static < E extends Comparable<E> > void sort( List<E> list , int lo, int hi ) {


        if (hi <= lo) {
            return;
        }

        if ( list.get(hi).compareTo(list.get(lo)) < 0 ) {
            swap( list, lo, hi );
        }

        int lt = lo + 1, gt = hi - 1;
        int i = lo + 1;


        while ( i <= gt ) {

            if ( list.get(i).compareTo(list.get(lo)) < 0 ) {
                swap(list, lt++, i++);
            }
            else if  ( list.get(hi).compareTo(list.get(i)) < 0 ) {
                swap(list, i, gt--);
            }
            else {
                i++;
            }

        }

        swap( list, lo, --lt );
        swap( list, hi, ++gt );

        sort( list, lo, lt-1 );

        if ( list.get(lt).compareTo(list.get(gt)) < 0 ) {
            sort(list, lt+1, gt-1);
        }

        sort( list, gt+1, hi );

    }

    /**
     * Swap the indexes
     * @param list List
     * @param i index
     * @param j index
     * @param <E> Type of item that implements Comparable interface.
     */
    private static <E extends Comparable<E> > void swap( List<E> list , int i, int j ) {
        E temp = list.get(i);
        list.set(i , list.get(j));
        list.set(j , temp);
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
     * GEt swap amount
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

