package edu.gtu.Sorting;

import java.time.Duration;
import java.time.Instant;

/** Implements the quicksort algorithm. */
public class QuickSort {


    private static int comparisionAmount;
    private static int swapAmount;
    private static long runTime;
    private static long expectedRuntime;


    /**
     * Sort the table using the quicksort algorithm.
     * @param table The array to be sorted
     * @pre table contains Comparable objects.
     * @post table is sorted.
     */
    public static <E extends Comparable<? super E>> void sort(E[] table) {

        Instant start = Instant.now();

        quickSort(table, 0, table.length - 1);

        Instant end = Instant.now();

        runTime = Duration.between( start , end ).toMillis();
    }


    /**
     * Sort a part of the table using the quicksort algorithm.
     *
     * @param table The array to be sorted
     * @param first The index of the low bound
     * @param last  The index of the high bound
     * @post The part of table from first through last is sorted.
     */
    private static <E extends Comparable<? super E>> void quickSort(E[] table,
                                                            int first, int last) {
        if (first < last) { // There is data to be sorted.

            int pivIndex = partition(table, first, last);
            quickSort(table, first, pivIndex - 1);
            quickSort(table, pivIndex + 1, last);
        }

        swapAmount = 0;
        comparisionAmount = 0;
        expectedRuntime = 0;

    }


    /** Partition the table so that values from first to pivIndex
     are less than or equal to the pivot value, and values from
     pivIndex to last are greater than the pivot value.
     @param table The table to be partitioned
     @param first The index of the low bound
     @param last The index of the high bound
     @return The location of the pivot value
     */
    private static <E extends Comparable<? super E>> int partition(E[] table,
                                                           int first, int last) {

        sort3(table, first, last);

        swap(table, first, (first + last) / 2);


        E pivot = table[first];

        int up = first;
        int down = last;

        do {
            while ((up < last) && (pivot.compareTo(table[up]) >= 0)) {
                up++;
            }
            while (pivot.compareTo(table[down]) < 0) {
                down--;
            }
            if (up < down) {
                swap(table, up, down);
            }

            System.out.println();

        } while (up < down);

        swap(table, first, down);

        return down;
    }

    /** Swap the items in table[i] and table[j].
     @param table The array that contains the items
     @param i The index of one item
     @param j The index of the other item
     */
    private static <E extends Comparable<? super E>> void swap(E[] table,
                                                               int i, int j) {
        E temp = table[i];
        table[i] = table[j];
        table[j] = temp;
    }


    /** Sort table[first], table[middle], and table[last].
     @param table The table to be sorted
     @param first Index of the first element
     @param last Index of the last element
     */
    private static <E extends Comparable<? super E>> void sort3(E[] table,
                                                   int first, int last) {
        int middle = (first + last) / 2;

        if (table[middle].compareTo(table[first]) < 0) {
            swap(table, first, middle);
        }

        if (table[last].compareTo(table[middle]) < 0) {
            swap(table, middle, last);
        }

        if (table[middle].compareTo(table[first]) < 0) {
            swap(table, first, middle);
        }

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





