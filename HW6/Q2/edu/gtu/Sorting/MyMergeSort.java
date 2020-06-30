package edu.gtu.Sorting;

import java.util.LinkedList;
import java.time.Duration;
import java.time.Instant;

public class MyMergeSort {

    private static int comparisionAmount;
    private static int swapAmount;
    private static long runTime;
    private static long expectedRuntime;

    /**
     * Sort the given input list with merge sort.
     * @param input List
     * @param <E> Item that implements comparable interface.
     */
    public static < E extends Comparable<? super E>> void sort( LinkedList<E> input ) {

        Instant start = Instant.now();

        if (input.size() != 1) {
            LinkedList<E> left = new LinkedList<>();
            LinkedList<E> right = new LinkedList<>();

            boolean logicalSwitch = true;

            while (!input.isEmpty()) {
                if (logicalSwitch) {
                    left.add(input.pop());
                } else {
                    right.add(input.pop());
                }
                logicalSwitch = !logicalSwitch;
            }

            sort(left);
            sort(right);

            input.addAll(merge(left, right));
        }

        Instant end = Instant.now();

        runTime = Duration.between( start , end ).toMillis();
        swapAmount = 0;
        comparisionAmount = 0;
        expectedRuntime = 0;
    }

    /** Merge two sequences.
     pre : leftSequence and rightSequence are sorted.
     post : left and righ are merged and returned as new sorted List.
     @param left The destination
     @param right The left input
     */
    private static < E extends Comparable<? super E> > LinkedList<E> merge( LinkedList<E> left, final LinkedList<E> right) {

        final LinkedList<E> merged = new LinkedList<>();

        while (!left.isEmpty() && !right.isEmpty()) {

            if (left.peek().compareTo(right.peek()) <= 0) {
                merged.add(left.pop());
            } else {
                merged.add(right.pop());
            }

        }

        merged.addAll(left);
        merged.addAll(right);

        return merged;
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
