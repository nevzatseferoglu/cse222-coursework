package edu.gtu.Heap;

/**
 * edu.gtu package Heap data structure interface.
 * @param <E> type
 */
public interface MaxHeapInterface<E> {

    /**
     * Add the element to the heap.
     * @param item item
     */
    void add( E item );

    /**
     * Remove a specific element from the heap.
     * @param item item
     * @return true if removed otherwise false.
     */
    boolean remove( E item );

    /**
     * Find a specific element and return it.
     * @param item item
     * @return element itself if it is not found return null.
     */
    E find( E  item );

    /**
     * Return the first element of the heap.
     * @return first element of the heap.
     */
    E peek();

    /**
     * Pull out the first element of the heap.
     * @return first element of the heap.
     */
    E poll();

}
