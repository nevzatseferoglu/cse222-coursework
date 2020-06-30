package edu.gtu.Sorting;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * List and array generator.
 */
public class ListGenerator {

    private static List<Integer> list;
    private static Integer[] arr;

    /**
     * Generate list with given size and randomness.
     * @param numberOfItem number of item.
     * @param isRandom is random.
     * @return newly created Integer list.
     */
    public static List<Integer> GenerateList(int numberOfItem, Boolean isRandom) {

        if( isRandom ) {
            return createRandomList( numberOfItem );
        } else {
            return createSortedList( numberOfItem );
        }
    }

    /**
     * Generate an array with given property
     * @param numberOfItem number of item
     * @param isRandom is random
     * @return newly created Integer array.
     */
    public static  Integer[] GenerateArray(int numberOfItem, Boolean isRandom) {

        if( isRandom ) {
            return createRandomArray( numberOfItem );
        } else {
            return createSortedArray( numberOfItem );
        }
    }

    /**
     * Create random List
     * @param numberOfItem number of item
     * @return newly created Integer list.
     */
    private static List<Integer> createRandomList( int numberOfItem ) {

        list = new LinkedList<>();

        for( int i = 0 ; i < numberOfItem ; ++i ) {
            list.add( randInt(numberOfItem ));
        }

        return list;
    }

    /**
     * Create sorted list.
     * @param numberOfItem number of item.
     * @return newly created Integer list.
     */
    private static List<Integer> createSortedList( int numberOfItem ) {

        list = new LinkedList<>();

        for( int i = 0 ; i < numberOfItem ; ++i ) {
            list.add( i );
        }

        return list;
    }

    /**
     * Create random array
     * @param numberOfItem number of item
     * @return newly created Integer array.
     */
    private static Integer[] createRandomArray( int numberOfItem ) {

        arr = new Integer[numberOfItem];

        for( int i = 0 ; i < numberOfItem ; ++i ) {
            arr[i] = randInt(numberOfItem );
        }

        return arr;
    }

    /**
     * Create sorted array.
     * @param numberOfItem number of item.
     * @return newly created Integer array.
     */
    private static Integer[] createSortedArray( int numberOfItem ) {

        arr = new Integer[numberOfItem];

        for( int i = 0 ; i < numberOfItem ; ++i ) {
            arr[ i ] = i;
        }

        return arr;
    }


    /**
     * Generate random number with 0 bound and given max upper.
     * @param max max number that will created.
     * @return random number.
     */
    private static int randInt(int max) {

        Random rand = new Random();
        return rand.nextInt(( max ) + 1);

    }
}
