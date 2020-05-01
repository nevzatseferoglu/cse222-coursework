package edu.gtu.Heap;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Concrete class of heap data structure.
 * @param <E> type
 */
public class MaxHeapUtil<E extends Comparable<E> > implements MaxHeapInterface<E> {

    /**
     * List of data.
     */
    protected ArrayList<E> theData;

    /**
     * Comparator.
     */
    Comparator<E> comparator = null;

    /**
     * Return left child index;
     * @param parentIndex parent index
     * @return left child index;
     */
    protected int getLeftChildIndex( int parentIndex ) {
        return 2 * parentIndex + 1;
    }

    /**
     * Return right child index;
     * @param parentIndex parent index
     * @return right child index;
     */
    protected int getRightChildIndex( int parentIndex ) {
        return 2 * parentIndex + 2;
    }

    /**
     * Return parent index.
     * @param childIndex child index.
     * @return parent index;
     */
    protected int getParentIndex( int childIndex ) {
        return ( childIndex - 1 ) / 2;
    }

    /**
     * Determine the certain index element has left child.
     * @param index index
     * @return true it has otherwise return false.
     */
    protected boolean hasLeftChild( int index ) {
        return getLeftChildIndex( index ) < theData.size();
    }

    /**
     * Determine the certain index element has right child.
     * @param index index
     * @return true it has otherwise return false.
     */
    protected boolean hasRightChild( int index ) {
        return getRightChildIndex( index ) < theData.size();
    }

    /**
     * Determine the certain index element has parent child.
     * @param index index
     * @return true it has otherwise return false.
     */
    protected boolean hasParent( int index ) {
        return getParentIndex( index ) >= 0;
    }

    /**
     * Return left child.
     * @param index index
     * @return left child.
     */
    protected E leftChild( int index ) {
        return theData.get( getLeftChildIndex( index ) );
    }

    /**
     * Return right child.
     * @param index index
     * @return right child.
     */
    protected E rightChild( int index ) {
        return theData.get( getRightChildIndex( index ) );
    }

    /**
     * Return parent.
     * @param index index
     * @return parent.
     */
    protected E parent( int index ) {
        return theData.get( getParentIndex( index ) );
    }

    /**
     * Compare the two different element in the heap according to comparator.
     * @param left left
     * @param right right
     * @return compare method result if it does not exist return the result compareTo method of element.
     */
    protected int compare( E left  , E right ) {

        if( comparator != null ) {
            return comparator.compare( left ,right );
        } else {
            return left.compareTo( right );
        }

    }

    /**
     * Swap the elements.
     * @param i first index.
     * @param j second index.
     */
    protected void swap( int i , int  j ) {

        if ( i < 0 || j < 0 || (i > theData.size() - 1)
                || (j > theData.size() - 1) ) {
            throw new IndexOutOfBoundsException();
        }

        E tempData = theData.get(i);
        theData.set( i , theData.get(j) );
        theData.set( j , tempData );

    }

    /**
     * Heapify throughout up in tree design.
     */
    protected void heapifyUp() {

        int index = theData.size() - 1;

        while ( hasParent( index ) && ( compare( parent( index ) , theData.get( index ) ) < 0 ) ) {
            swap( getParentIndex( index ) , index );
            index = getParentIndex( index );
        }

    }

    /**
     * Heapify throughout down in tree design.
     */
    protected void heapifyDown() {
        heapifyDown( 0 );
    }

    /**
     * Heapify down helper method.
     * @param index index
     */
    protected void heapifyDown( int index ) {

        while ( hasLeftChild( index ) ) {
            int smallerChildIndex = getLeftChildIndex( index );

            if( hasRightChild( index ) && ( compare(rightChild( index ), leftChild( index )) > 0 )  ) {
                smallerChildIndex = getRightChildIndex( index );
            }

            if( compare( theData.get( index ), theData.get( smallerChildIndex )) > 0 ) {
                break;
            } else {
                swap( index , smallerChildIndex );
            }

            index = smallerChildIndex;
        }
    }

    /**
     * Update the current status of Heap.
     */
    protected void updateHeap() {
        MaxHeapUtil<E> newHeap;

        if( comparator != null ) {
            newHeap = new MaxHeapUtil<>( comparator );
            for (E theDatum : theData) {
                newHeap.add( theDatum );
            }

            theData = newHeap.theData;
        }
    }

    /**
     * No parameter constructor.
     */
    public MaxHeapUtil() {
        theData = new ArrayList<E>();
    }

    /**
     * Initiate a heap with given comparator.
     * @param comp Comparator.
     */
    public MaxHeapUtil( Comparator<E> comp ) {
        this();
        comparator = comp;
    }

    /**
     * Return the first element of the heap.
     * @return first element of the heap.
     */
    @Override
    public E peek() {
        if( theData.size() == 0 ) {
            throw new IllegalStateException();
        }

        return theData.get( 0 );
    }

    /**
     * Pull out the first element of the heap.
     * @return first element of the heap.
     */
    @Override
    public E poll() {
        if( theData.size() == 0 ) {
            throw new IllegalStateException();
        }

        E item = theData.get( 0 );
        theData.set( 0 , theData.get( theData.size() - 1 ));
        theData.remove( theData.size() - 1 );
        heapifyDown();

        return item;
    }

    /**
     * Find a specific element and return it.
     * @param item item
     * @return element itself if it is not found return null.
     */
    @Override
    public E find( E  item ) {

        for (E theDatum : theData) {
            if ( theDatum.compareTo( item ) == 0 ) {
                return theDatum;
            }
        }

        return null;
    }

    /**
     * Add the element to the heap.
     * @param item item
     */
    @Override
    public void add( E item ) {
        theData.add( item );
        heapifyUp();
    }

    /**
     * Remove a specific element from the heap.
     * @param item item
     * @return true if removed otherwise false.
     */
    @Override
    public boolean remove(E item) {
        
        if( theData.size() == 0 ) {
            throw new IllegalStateException();
        }
        
        int index = theData.indexOf( find( item ) );
        
        if( index == -1 ) {
            return false;
        }

        swap( index , theData.size() - 1 );
        theData.remove( theData.size() - 1 );
        heapifyDown( index );

        return true;
    }

    /**
     * String representation of heap.
     * @return String representation of heap.
     */
    @Override
    public String toString() {
        return theData.toString();
    }


}
