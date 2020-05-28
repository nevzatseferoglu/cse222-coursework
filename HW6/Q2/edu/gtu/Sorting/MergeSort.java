package edu.gtu.Sorting;

import java.time.Duration;
import java.time.Instant;

public class MergeSort {


    private static int comparisionAmount;
    private static int swapAmount;
    private static long runTime;
    private static long expectedRuntime;

    /** Sort the array using the merge sort algorithm.
     pre: table contains Comparable objects.
     post: table is sorted.
     @param table The array to be sorted
     */
    @SuppressWarnings("unchecked")
    public static <E extends Comparable<? super E>> void sort(E[] table) {
        Instant start = Instant.now();

        // A table with one element is sorted already.
        if (table.length > 1) {

            // Split table into halves.
            int halfSize = table.length / 2;
            E[] leftTable = (E[]) new Comparable[halfSize];
            E[] rightTable = (E[]) new Comparable[table.length - halfSize];


            System.arraycopy(table, 0, leftTable, 0, halfSize);
            System.arraycopy(table, halfSize, rightTable, 0,
                    table.length - halfSize);

            // Sort the halves.
            sort(leftTable);
            sort(rightTable);

            // Merge the halves.
            merge(table, leftTable, rightTable);

            Instant end = Instant.now();

            runTime = Duration.between( start , end ).toMillis();
            swapAmount = 0;
            comparisionAmount = 0;
            expectedRuntime = 0;
        }
    }

    /** Merge two sequences.
     pre : leftSequence and rightSequence are sorted.
     post : outputSequence is the merged result and is sorted.
     @param outputSequence The destination
     @param leftSequence The left input
     @param rightSequence The right input
     */
    private static <T extends Comparable<? super T>> void merge(T[] outputSequence,
                                                        T[] leftSequence,
                                                        T[] rightSequence) {
        int i = 0;
        // Index into the left input sequence.
        int j = 0;

        // Index into the right input sequence.
        int k = 0;

        // Index into the output sequence.
        // While there is data in both input sequences

        while (i < leftSequence.length && j < rightSequence.length) {

            // Find the smaller and
            // insert it into the output sequence.

            if (leftSequence[i].compareTo(rightSequence[j]) < 0) {
                outputSequence[k++] = leftSequence[i++];
            } else {
                outputSequence[k++] = rightSequence[j++];
            }
        }

        // assert: one of the sequences has more items to copy.
        // Copy remaining input from left sequence into the output.

        while (i < leftSequence.length) {
            outputSequence[k++] = leftSequence[i++];
            ++swapAmount;
        }

        // Copy remaining input from right sequence into output.

        while (j < rightSequence.length) {
            outputSequence[k++] = rightSequence[j++];
            ++swapAmount;
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
