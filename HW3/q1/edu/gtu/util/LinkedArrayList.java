package edu.gtu.util;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;


/**
* This class provides a skeletal implementation of the <tt>Collection</tt>
* and <tt>List</tt> interface, to minimize the effort required to implement
* this interface.
*
* <p> To implement an unmodifiable collection, the programmer needs override
* this class and provide implementations for the some methods that She/He does not
* want to serve to user of collection.
*
* To implement a modifiable collection, the programmer must additionally
* override this class's <tt>add</tt> method (which otherwise throws an
* <tt>UnsupportedOperationException</tt>), and the iterator returned by the
* <tt>iterator</tt> method must additionally implement its <tt>remove</tt>
* method.<p>
*
* The programmer should generally provide a void (no argument) and
* <tt>Collection</tt> constructor, as per the recommendation in the
* <tt>Collection</tt> interface specification.<p>
*
* Each of these methods may be overridden if
* the collection being implemented admits a more efficient implementation.<p>
*
* This class is a member of the
* <a href="https://github.com/nevzatseferoglu">
* GTU Collections Framework</a>.
*
* @author  Nevzat Seferoglu
* @see Collection
* @see List
* @see AbstractList
* @since 1.0
* @version  1.0 (base)
 */
public class LinkedArrayList<E> extends AbstractList<E>
        implements List<E> , Collection<E> {

    /**
     *
     */
    private Node<E> head = null;

    /**
     *
     */
    private int totalElementUsed = 0;


    /**
     * Static inner Node class.
     * @param <E> Generic type as non-primitive.
     */
    private static class Node<E> {

        /**
         * Constant capacity of an array of each node.
         */
        private static final int CONSTANT_CAPACITY = 3;

        /**
         * Used index amount of an array.
         */
        private int used = 0;

        /**
         * Array of object.
         */
        private Object[] elementsArray;

        /**
         * Next reference of node itself.
         */
        private Node<E> next;

        /**
         * Previous reference of node itself.
         */
        private Node<E> previous;

        /**
         * Create a node with already given next and previous references.
         * @param next Next reference of the current node.
         * @param previous Previous reference of the current node.
         */
        private Node( Node<E> next , Node<E> previous ) {

            elementsArray = new Object[ CONSTANT_CAPACITY ];

            this.next = next;
            this.previous = previous;

        }

        /**
         * Create a node with already given next and previous references.
         * @param data Data will be stored in an array which node keeps in it.
         * @param next Next reference of the current node.
         * @param previous Previous reference of the current node.
         */
        private Node( E data , Node<E> next , Node<E> previous ) {
            this(next , previous );

            elementsArray[ used ] = data;
            ++used;

        }

        /**
         * Check the fulness of array.
         * @return if an array used is not equal 0 return false , otherwise return true.
         */
        boolean isFull() {
            return (used) == CONSTANT_CAPACITY;
        }
    }

    /**
     * Constructs a list containing the elements of the specified
     * collection, in the order they are returned by the collection's
     * iterator.
     *
     * @param  collection the collection whose elements are to be placed into this list
     */
    public LinkedArrayList( Collection< ? extends E > collection ) {
        this();
        addAll( collection );
    }

    /**
     * Constructs an empty list.
     */
    public LinkedArrayList() {
        super();
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param i index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException .
     */
    @Override
    public E get(int i) {

        if( i < 0 || i >= size() ) {
            throw new IndexOutOfBoundsException();
        }

        ListIterator<E> iter = listIterator(i);
        return iter.next();
    }

    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return totalElementUsed;
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException .
     */
    @Override
    public E set(int index, E element) {

        if( index < 0 || index >= size() ) {
            throw new IndexOutOfBoundsException();
        }

        ListIterator<E> iter = listIterator(index);
        E returnElement = iter.next();
        iter.set(element);

        return returnElement;
    }

    /**
     * Removes the element at the specified position in this list.  Shifts any
     * subsequent elements to the left (subtracts one from their indices).
     * Returns the element that was removed from the list.
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException .
     */
    @Override
    public E remove(int index) {

        if( index < 0 || index >= size() ) {
            throw new IndexOutOfBoundsException();
        }

        ListIterator<E> iter = listIterator(index);

        E returnElement = iter.next();
        iter.remove();

        return returnElement;

    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any
     * subsequent elements to the right (adds one to their indices).
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException .
     */
    @Override
    public void add(int index, E element) {

        if( index < 0 || index > size() ) {
            throw new IndexOutOfBoundsException();
        }

        ListIterator<E> iter = listIterator(index);
        iter.add(element);
    }

    /**
     * Returns a list-iterator of the elements in this list (in proper
     * sequence), starting at the specified position in the list.
     * Obeys the general contract of {@code List.listIterator(int)}.<p>
     * The list-iterator is <i>fail-fast</i>: if the list is structurally
     * modified at any time after the Iterator is created, in any way except
     * through the list-iterator's own {@code remove} or {@code add}
     * methods, the list-iterator will throw a
     * {@code ConcurrentModificationException}.  Thus, in the face of
     * concurrent modification, the iterator fails quickly and cleanly, rather
     * than risking arbitrary, non-deterministic behavior at an undetermined
     * time in the future.
     * @param index index of the first element to be returned from the
     * list-iterator (by a call to {@code next})
     * @return a ListIterator of the elements in this list (in proper
     *         sequence), starting at the specified position in the list
     * @throws IndexOutOfBoundsException .
     * @see List
     * @see ListIterator
     */
    @Override
    public ListIterator<E> listIterator(int index) {
        return new GtuListIterator(index);
    }

    /**
    * Root iterator that starting with beginning ,
    * use ListIterator that newly implemented in this collection.
    */
    @Override
    public Iterator<E> iterator() {
        return listIterator(0);
    }

    /**
     * Representation of list element its node configuration as well.
     * @return Representation as a String.
     */
    @Override
    public String toString() {

        StringBuilder string = new StringBuilder();
        ListIterator<E> iter = listIterator(0);

        string.append("List Layout : ");
        for( ; iter.hasNext() ;) {
            string.append( iter.next());
            if( iter.hasNext() ) {
                string.append(",");
            }
        }

        string.append("\nNode Layout : ");
        for( Node<E> tempNode = head ;  tempNode != null ; tempNode = tempNode.next ) {
            string.append("(");
            for( int  i = 0 ; i < tempNode.used ; ++i ) {
                string.append(tempNode.elementsArray[i]);
                if( i+1 != tempNode.used)
                    string.append(",");
            }
            string.append(")");

            if( tempNode.next != null )
                string.append(" | ");
        }

        return string.toString();
    }


    /**
     * Newly implemented ListIterator class.
     */
    @SuppressWarnings("unchecked")
    private class GtuListIterator implements ListIterator<E> {

        /**
         * Current Node of Iterator.
         */
        private Node<E> currentNode;

        /**
         * Current element index as an int.
         */
        private int currentElementIndex;

        /**
         * Last return node.
         */
        private Node<E> lastNodeReturned;

        /**
         * Last returned element index as an int.
         */
        private int lastReturnedElementIndex;

        /**
         * Given index value.
         */
        private int index = 0;

        /**
         * Control Flag.
         */
        private boolean previousMoveFlag = false;

        /**
         * Update the current state of iterator.
         * @param i Index as an int.
         */
        private void updateCurrentState( int i ) {


            if( head != null ) {
                Node<E> tempNode = head;
                int tempGivenIndex = i;

                for( ; tempGivenIndex > tempNode.used ;   ) {
                    tempGivenIndex -= tempNode.used;
                    tempNode = tempNode.next;
                }

                index = i;
                currentNode = tempNode;
                currentElementIndex = tempGivenIndex;
            }
            else {
                currentNode = null;
                currentElementIndex = 0;
            }

        }

        /**
         * Iterator constructor.
         * @param i Starting point of the iterator.
         */
        private GtuListIterator( int i ) {

            if( i < 0 || i > totalElementUsed ) {
                throw new IndexOutOfBoundsException("Invalid Index" + i);
            }

            updateCurrentState( i );

            lastNodeReturned = null;
            lastReturnedElementIndex = 0;
        }

        /**
         * Returns true if this list iterator has more
         * elements when traversing the list in the forward direction.
         * @return True if the list iterator has more elements when traversing the list in the forward direction.
         */
        @Override
        public boolean hasNext() {
            return index < totalElementUsed;
        }

        /**
         * Returns the next element in the list and advances the cursor position.
         * @return the next element in the list.
         * @throws NoSuchElementException - if the iteration has no next element
         */
        @Override
        public E next() {

            updateCurrentState(index);

            if( !hasNext() ) {
                throw new NoSuchElementException();
            }

            if (currentElementIndex >= currentNode.used) {
                currentNode = currentNode.next;
                currentElementIndex = 0;
            }

            lastNodeReturned = currentNode;
            lastReturnedElementIndex = currentElementIndex;
            ++index;

            return (E) currentNode.elementsArray[currentElementIndex];

        }

        /**
         * Returns true if this list iterator has more
         * elements when traversing the list in the reverse direction.
         * @return True if the list iterator has more elements when traversing the list in the reverse direction.
         */
        @Override
        public boolean hasPrevious() {
            return index > 0;
        }

        /**
         * Returns the previous element in the list and moves the cursor position backwards.
         * @return The previous element in the list.
         * @throws NoSuchElementException - if the iteration has no previous element
         */
        @Override
        public E previous() {

            updateCurrentState(index);
            previousMoveFlag = true;

            if( !hasPrevious() ) {
                throw new NoSuchElementException();
            }

            if( currentElementIndex >= currentNode.used ) {
                currentElementIndex = currentNode.used - 1;
            }
            else {
                currentElementIndex -= 1;
            }

            lastNodeReturned = currentNode;
            lastReturnedElementIndex = currentElementIndex;
            --index;

            return (E) currentNode.elementsArray[ currentElementIndex ];

        }

        /**
         * Returns the previous element in the list and moves the cursor position backwards.
         * @return The index of the element that would be returned by a subsequent call to next, or list size if the list iterator is at the end of the list.
         */
        @Override
        public int nextIndex() {
            if( !hasNext() ) {
                return totalElementUsed;
            }
            else {
                return index;
            }
        }

        /**
         * Returns the index of the element that would be returned by a subsequent call to next().
         * @return The index of the element that would be returned by a subsequent call to next, or list size if the list iterator is at the end of the list.
         */
        @Override
        public int previousIndex() {
            if( !hasPrevious() ) {
                return -1;
            }
            else {
                return  index - 1;
            }
        }

        /**
         * Removes from the list the last element that was returned by next() or previous() (optional operation).
         * @throws IllegalStateException - if neither next nor previous have been called, or remove or add have been
         * called after the last call to next or previous
         */
        @Override
        public void remove() {

            updateCurrentState(index);
            if( lastNodeReturned == null ) {
                throw new IllegalStateException();
            }

            if( lastNodeReturned.used == 1 ) {

                Node<E> previousNode = lastNodeReturned.previous;
                Node<E> nextNode = lastNodeReturned.next;

                if( previousNode != null ) {
                    previousNode.next = nextNode;
                }

                if( nextNode != null ) {
                    nextNode.previous = previousNode;
                    if( previousNode == null ) {
                        head = nextNode;
                    }
                }

                if( nextNode == null && previousNode == null ) {
                    head = null;
                }

            }
            else {
                for( int i = lastReturnedElementIndex ; i < lastNodeReturned.used - 1 ; ++i ) {
                    lastNodeReturned.elementsArray[ i ] = lastNodeReturned.elementsArray[ i + 1 ];
                }
                --lastNodeReturned.used;
            }

            if( previousMoveFlag != true ) {
                --index;
            }
            else {
                previousMoveFlag = false;
            }

            --totalElementUsed;
            lastNodeReturned = null;
        }

        /**
         * Replaces the last element returned by next() or previous() with the specified element (optional operation).
         * @param e The element to insert.
         * @throws IllegalStateException - if neither next nor previous have been called, or remove or add have been
         * called after the last call to next or previous.
         */
        @Override
        public void set(E e) {

            if( lastNodeReturned == null ) {
                throw new IllegalStateException();
            }

            Node<E> node = head;
            for(  ; node != lastNodeReturned ; node = node.next );

            node.elementsArray[lastReturnedElementIndex] = e;

        }

        /**
         * Inserts the specified element into the list (optional operation).
         * @param e The element to insert.
         */
        @Override
        public void add(E e) {

            updateCurrentState(index);

            if( currentNode == null ) {
                currentNode = new Node<>( e , null , null );
                head = currentNode;
            }
            else {
                if( !currentNode.isFull() ) {

                    for( int i = currentNode.used - 1 ; i >= currentElementIndex ; --i ) {
                        currentNode.elementsArray[ i + 1 ] = currentNode.elementsArray[ i ];
                    }
                    currentNode.elementsArray[currentElementIndex] = e;
                    ++currentNode.used;
                }
                else {

                    if( currentElementIndex == currentNode.used ) {

                        if( currentNode.next != null && !currentNode.next.isFull() ) {

                            for( int i = currentNode.next.used - 1 ; i >= 0 ; --i ) {
                                currentNode.next.elementsArray[ i + 1 ] = currentNode.next.elementsArray[ i ];
                            }
                            currentNode.next.elementsArray[0] = e;
                            ++currentNode.next.used;
                        }
                        else if(currentNode.next != null && currentNode.next.isFull() ){

                            Node<E> newNextNode = new Node<>( e , null , currentNode );
                            currentNode.next.previous = newNextNode;
                            newNextNode.next = currentNode.next;
                            currentNode.next = newNextNode;

                        }
                        else {
                            currentNode.next = new Node<>( e , null , currentNode );
                        }

                    }
                    else {

                        Node<E> newNextNode = new Node<>( (E)currentNode.elementsArray[ currentNode.used - 1 ]
                                , null ,currentNode );

                        if( currentNode.next != null ) {
                            currentNode.next.previous = newNextNode;
                            newNextNode.next = currentNode.next;
                        }
                        currentNode.next = newNextNode;

                        --currentNode.used;
                        for( int i = currentNode.used - 1 ; i >= currentElementIndex ; --i ) {
                            currentNode.elementsArray[ i + 1 ] = currentNode.elementsArray[ i ];
                        }
                        currentNode.elementsArray[currentElementIndex] = e;
                        ++currentNode.used;
                    }
                }
            }

            lastNodeReturned = null;
            ++totalElementUsed;
            ++index;
        }
    }
}
