package edu.gtu.recursion;

import java.util.NoSuchElementException;

/**
 * Selection sort class that handles sorting array of Integer
 * which is wrapper class of int.
 */
public class p3 {

    /**
     * Determine the index of minimum number.
     * @param arr array that will be searched for an index of minimum number.
     * @param index1 start index of search.
     * @param index2 end index of search.
     * @return index of minimum number.
     */
    private static int minIndex( Integer[] arr , int index1 , int index2 ) {

        if (index1 == index2)
            return index1;

        int tempIndex = minIndex(arr, index1 + 1, index2);

        if( arr[ index1 ] < arr[ tempIndex ] ) {
            return index1;
        }
        else {
            return tempIndex;
        }
    }

    /**
     * Swap the value of given element with indexes.
     * @param arr array which indexes will be swapped.
     * @param index1 first index.
     * @param index2 second index.
     */
    private static void swap(Integer[] arr , int index1 , int index2 ) {

        if( index1 < 0 || index1 >= arr.length || index2 < 0 || index2 >= arr.length ) {
            throw new NoSuchElementException();
        }

        Integer tempInteger = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tempInteger;
    }

    /**
     * Wrapper method called in selectionSort.
     * @param arr array.
     * @param index index.
     */
    private static void sortWithSelectionSort( Integer[] arr , int index ) {

        if( index > arr.length - 1 ) {
            return;
        }
        else {
            swap( arr , index , minIndex( arr , index , arr.length - 1) );
            sortWithSelectionSort( arr , index + 1);
        }

    }

    /**
     * Sort the given Integer array from small to big.
     * @param arr array of Integer.
     */
    public static void selectionSort( Integer[] arr ) {
        sortWithSelectionSort( arr, 0 );
    }

}
