package edu.gtu.util.deque;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 * Deque which implements deque interface of java collection hierarchy.
 * @param <E>
 */
public class GtuDeque<E> extends AbstractCollection<E> implements Deque<E> {

    int size;
    Node<E> head;
    Node<E> tail;
    Node<E> removedNodesHead;

    /**
     * Create a new node.
     * @param prev previous node reference.
     * @param e item that will be stored in the node.
     * @param next next node reference.
     * @return created node which is created according to given parameter.
     */
    private Node<E> createNewNode( Node<E> prev , E e , Node<E> next ) {

        if( removedNodesHead == null ) {
            return new Node<>( prev , e , next );
        }

        Node<E> nextRemovedHead = removedNodesHead.next;

        Node<E> newNode = removedNodesHead;
        newNode.prev = prev;
        newNode.next = next;
        newNode.item = e;

        if( nextRemovedHead != null ) {
            nextRemovedHead.prev = null;
        }

        removedNodesHead = nextRemovedHead;

        return newNode;
    }

    /**
     * Add an unnecessary node to garbage node list.
     * @param node that is no needed.
     */
    private void addRemovedList( Node<E> node ) {

        node.next = null;

        if( removedNodesHead == null ) {
            node.prev = null;
            removedNodesHead = node;
        }
        else {
            Node<E> tempHead = removedNodesHead;
            for(  ; tempHead.next != null ; tempHead =tempHead.next );

            tempHead.next = node;
            node.prev = tempHead;
        }
    }

    /**
     * Concrete iterator class.
     */
    private class GtuIterator implements Iterator<E> {

        private Node<E> nextNode;
        private Node<E> lastReturnedNode;

        /**
         * No parameter constructor.
         */
        private GtuIterator() {
            nextNode = head;
        }

        /**
         * Returns true if the iteration has more elements.
         * @return true if the iteration has more elements.
         */
        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        /**
         * Returns the next element in the iteration.
         * @return the next element in the iteration.
         * @throws NoSuchElementException - if the iteration has no more elements.
         */
        @Override
        public E next() {

            if( !hasNext() ) {
                throw new NoSuchElementException();
            }

            lastReturnedNode = nextNode;
            nextNode = nextNode.next;

            return lastReturnedNode.item;
        }

        /**
         * Removes from the underlying collection the last element returned by this iterator. This method can be called only once per call to next().
         * @throws IllegalStateException - if the next method has not yet been called, or the remove method has already been called after the last call to the next method.
         */
        @Override
        public void remove() {
            if( lastReturnedNode == null ) {
                throw new IllegalStateException();
            }
            pullOfNode(lastReturnedNode);
            lastReturnedNode = null;
        }
    }

    /**
     * Concrete iterator class which works like reverse of iterator.
     */
    private class GtuDescendingIterator implements Iterator<E> {

        private Node<E> nextNode;
        private Node<E> lastReturnedNode;

        /**
         * No parameter constructor.
         */
        private GtuDescendingIterator() {
            nextNode = tail;
        }

        /**
         * Returns true if the iteration has more elements in reverse direction.
         * @return true if the iteration has more elements in reverse direction.
         */
        @Override
        public boolean hasNext() {
            return nextNode != null;

        }

        /**
         * Returns the next element in the iteration , but it will move in reverse direction.
         * @return the next element in the iteration , but it will move in reverse direction.
         * @throws NoSuchElementException - if the iteration has no more elements in reverse direction.
         */
        @Override
        public E next() {

            if( !hasNext() ) {
                throw new NoSuchElementException();
            }

            lastReturnedNode = nextNode;
            nextNode = nextNode.prev;

            return lastReturnedNode.item;
        }

        /**
         * Removes from the underlying collection the last element returned by this iterator. This method can be called only once per call to next().
         * @throws IllegalStateException - if the next method has not yet been called, or the remove method has already been called after the last call to the next method.
         */
        @Override
        public void remove() {
            if( lastReturnedNode == null ) {
                throw new IllegalStateException();
            }
            pullOfNode(lastReturnedNode);
            lastReturnedNode = null;
        }
    }

    /**
     * Node that is used in the lists of implementation.
     * @param <E> generic type that will be used as type of item of node.
     */
    private static class Node<E> {

        E item;
        Node<E> next;
        Node<E> prev;

        /**
         * Initiate a node with given argument.
         * @param prev previous node reference.
         * @param element item that will be stored in the node.
         * @param next next node reference.
         */
        Node( Node<E> prev, E element, Node<E> next ) {

            this.item = element;
            this.next = next;
            this.prev = prev;
        }

    }

    /**
     *  Insert an element to head reference of internal list.
     * @param e element that will be inserted to head of the internal list.
     */
    private void insertHead( E e ) {
        Node<E> tempHead = head;
        Node<E> newNode = createNewNode( null , e , tempHead );

        head = newNode;

        if( tempHead == null ) {
            tail = newNode ;
        }
        else {
            tempHead.prev = newNode;
        }

        ++size;
    }

    /**
     *  Insert an element to tail reference of internal list.
     * @param e element that will be inserted to tail of the internal list.
     */
    private void insertTail( E e ) {

        Node<E> tempTail = tail;
        Node<E> newNode = createNewNode( tempTail , e , null );

        tail = newNode;

        if( tempTail == null ) {
            head = newNode;
        }
        else {
            tempTail.next = newNode;
        }

        ++size;
    }

    /**
     * Unlink nodes that come before from given node from the list.
     * @param node that will be used as reference node.
     * @return unlinked node element.
     */
    private E pullFromFirst( Node<E> node ) {

        E tempElement = node.item;
        Node<E> tempNodeNext = node.next;

        node.item = null;
        node.next = null;

        head = tempNodeNext;

        if( tempNodeNext == null ) {
            tail = null;
        }
        else {
            tempNodeNext.prev = null;
        }


        --size;

        addRemovedList(node);

        return tempElement;
    }

    /**
     * Unlink nodes that come after from given node from the list.
     * @param node that will be used as reference node.
     * @return unlinked node element.
     */
    private E pullFromLast( Node<E> node ){

        E tempElement = node.item;
        Node<E> tempNodePrev = node.prev;

        node.item = null;
        node.prev = null;

        tail = tempNodePrev;

        if( tempNodePrev == null ) {
            head = null;
        }
        else {
            tempNodePrev.next = null;
        }

        --size;

        addRemovedList(node);
        return tempElement;
    }

    /**
     * Unlink the first node that matches with given node.
     * @param node that will be unlinked from the list.
     * @return unlinked node element.
     */
    E pullOfNode( Node<E> node ) {

        E tempElement = node.item;
        Node<E> next = node.next;
        Node<E> prev = node.prev;

        if( prev == null ) {
            head = next;
        }
        else {
            prev.next = next;
            node.prev = null;
        }

        if( next == null ) {
            tail = prev;
        }
        else {
            next.prev = prev;
            node.next = null;
        }

        node.item = null;
        --size;

        addRemovedList(node);

        return tempElement;
    }

    /**
     *
     */
    public int garbageListSize() {
        int count = 0;
        for( Node<E> tempHead = removedNodesHead; tempHead != null ; tempHead = tempHead.next) {
            ++count;
        }
        return count;
    }

    /**
     * No parameter constructor.
     */
    public GtuDeque() {
    }

    /**
     * Constructs a deque containing the elements of the specified
     * collection, in the order they are returned by the collection's
     * iterator.
     * @param  collection the collection whose elements are to be placed into this deque.
     * @throws NullPointerException if the specified collection is null.
     */
    public GtuDeque( Collection<? extends E> collection ) {
        this();
        addAll((collection));
    }

    /**
     * Inserts the specified element at the front of this deque if it is possible to do so immediately without violating capacity restrictions.
     * When using a capacity-restricted deque, it is generally preferable to use method offerFirst(E).
     * @param e the element to add.
     */
    @Override
    public void addFirst(E e) {
        insertHead(e);
    }

    /**
     * Inserts the specified element at the end of this deque if it is possible to do so immediately without violating capacity restrictions.
     * When using a capacity-restricted deque, it is generally preferable to use method offerLast(E).
     * This method is equivalent to add(E).
     * @param e the element to add.
     */
    @Override
    public void addLast(E e) {
        insertTail(e);
    }

    /**
     * Inserts the specified element into the queue represented by this deque (in other words, at the tail of this deque) if it is possible to do so immediately without violating capacity restrictions, returning true upon success and throwing an IllegalStateException if no space is currently available.
     * When using a capacity-restricted deque, it is generally preferable to use offer.
     * @param e - the element to add.
     * @return true (as specified by Collection.add(E))
     */
    @Override
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    /**
     * Inserts the specified element at the front of this deque unless it would violate capacity restrictions.
     * When using a capacity-restricted deque, this method is generally preferable to the addFirst(E) method, which can fail to insert an element only by throwing an exception.
     * @param e the element to add.
     * @return     true if the element was added to this deque, else false.
     */
    @Override
    public boolean offerFirst(E e) {
        addFirst( e );
        return true;
    }

    /**
     * Inserts the specified element at the end of this deque unless it would violate capacity restrictions.
     * When using a capacity-restricted deque, this method is generally preferable to the addLast(E) method, which can fail to insert an element only by throwing an exception.
     * @param e the element to add.
     * @return true if the element was added to this deque, else false.
     */
    @Override
    public boolean offerLast(E e) {
        addLast( e );
        return true;
    }

    /**
     * Retrieves and removes the first element of this deque. This method differs from pollFirst only in that it throws an exception if this deque is empty.
     * @return the head of this deque.
     * @throws NoSuchElementException - if this deque is empty.
     */
    @Override
    public E removeFirst() {
        Node<E> h = head;

        if(h == null) {
            throw new NoSuchElementException();
        }

        return pullFromFirst(h);
    }

    /**
     * Retrieves and removes the last element of this deque. This method differs from pollLast only in that it throws an exception if this deque is empty.
     * @return the tail of this deque.
     */
    @Override
    public E removeLast() {
        Node<E> t = tail;

        if( t == null ) {
            throw new NoSuchElementException();
        }

        return pullFromLast(t);
    }

    /**
     * Retrieves and removes the first element of this deque, or returns null if this deque is empty.
     * @return the head of this deque, or null if this deque is empty.
     */
    @Override
    public E pollFirst() {
        return poll();
    }

    /**
     * Retrieves and removes the last element of this deque, or returns null if this deque is empty.
     * @return the tail of this deque, or null if this deque is empty.
     */
    @Override
    public E pollLast() {
        Node<E> t = tail;
        return ( t == null ) ? null : pullFromLast( t );
    }

    /**
     * Retrieves, but does not remove, the first element of this deque. This method differs from peekFirst only in that it throws an exception if this deque is empty.
     * @return the head of this deque.
     */
    @Override
    public E getFirst() {
        Node<E> h = head;

        if( h == null ) {
            throw new NoSuchElementException();
        }

        return h.item;
    }

    /**
     * Retrieves, but does not remove, the last element of this deque. This method differs from peekLast only in that it throws an exception if this deque is empty.
     * @return the tail of this deque.
     * @throws NoSuchElementException - if this deque is empty.
     */
    @Override
    public E getLast() {
        Node<E> t = tail;

        if( t == null ) {
            throw new NoSuchElementException();
        }

        return t.item;
    }

    /**
     * Retrieves, but does not remove, the first element of this deque, or returns null if this deque is empty.
     * @return the head of this deque, or null if this deque is empty.
     */
    @Override
    public E peekFirst() {
        return peek();
    }

    /**
     * Retrieves, but does not remove, the last element of this deque, or returns null if this deque is empty.
     * @return the tail of this deque, or null if this deque is empty.
     */
    @Override
    public E peekLast() {

        Node<E> t = tail;
        return ( t == null ) ? null : t.item;
    }

    /**
     * Removes the first occurrence of the specified element from this deque. If the deque does not contain the element, it is unchanged. More formally, removes the first element e such that (o==null ? e==null : o.equals(e)) (if such an element exists).
     * Returns true if this deque contained the specified element (or equivalently, if this deque changed as a result of the call).
     * @param o - element to be removed from this deque, if present.
     * @return true if an element was removed as a result of this call.
     */
    @Override
    public boolean removeFirstOccurrence(Object o) {
        return remove( o );
    }

    /**
     * Removes the last occurrence of the specified element from this deque. If the deque does not contain the element, it is unchanged. More formally, removes the last element e such that (o==null ? e==null : o.equals(e)) (if such an element exists).
     * Returns true if this deque contained the specified element (or equivalently, if this deque changed as a result of the call).
     * @param o - element to be removed from this deque, if present.
     * @return true if an element was removed as a result of this call.
     */
    @Override
    public boolean removeLastOccurrence(Object o) {

        if (o == null) {
            for (Node<E> node = tail; node != null; node = node.prev) {
                if (node.item == null) {
                    pullOfNode(node);
                    return true;
                }
            }
        }
        else {
            for (Node<E> node = tail; node != null; node = node.prev) {
                if (o.equals(node.item)) {
                    pullOfNode(node);
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Inserts the specified element into the queue represented by this deque (in other words, at the tail of this deque) if it is possible to do so immediately without violating capacity restrictions, returning true upon success and false if no space is currently available.
     * When using a capacity-restricted deque, this method is generally preferable to the add(E) method, which can fail to insert an element only by throwing an exception.
     * @param e - the element to add.
     * @return     true if the element was added to this deque, else false.
     */
    @Override
    public boolean offer(E e) {
        return add( e );
    }

    /**
     * Retrieves and removes the head of the queue represented by this deque (in other words, the first element of this deque).
     * This method differs from poll only in that it throws an exception if this deque is empty.
     * @return the head of the queue represented by this deque.
     * @throws NoSuchElementException - if this deque is empty.
     */
    @Override
    public E remove() {
        return removeFirst();
    }

    /**
     * Retrieves and removes the head of the queue represented by this deque (in other words, the first element of this deque), or returns null if this deque is empty.
     * @return the first element of this deque, or null if this deque is empty.
     */
    @Override
    public E poll() {
        Node<E> h = head;
        return ( h == null ) ? null : pullOfNode( h );
    }

    /**
     * Retrieves, but does not remove, the head of the queue represented by this deque (in other words, the first element of this deque).
     * This method differs from peek only in that it throws an exception if this deque is empty.
     * @return the head of the queue represented by this deque.
     * @throws NoSuchElementException - if this deque is empty.
     */
    @Override
    public E element() {
        return getFirst();
    }

    /**
     * Retrieves, but does not remove, the head of the queue represented by this deque (in other words, the first element of this deque), or returns null if this deque is empty.
     * @return the head of the queue represented by this deque, or null if this deque is empty.
     */
    @Override
    public E peek() {
        Node<E> h = head;
        return ( h == null ) ? null : h.item;
    }

    /**
     * Pushes an element onto the stack represented by this deque (in other words, at the head of this deque) if it is possible to do so immediately without violating capacity restrictions, returning true upon success and throwing an IllegalStateException if no space is currently available.
     * @param e - the element to push.
     */
    @Override
    public void push(E e) {
        addFirst( e );
    }

    /**
     * Pops an element from the stack represented by this deque. In other words, removes and returns the first element of this deque.
     * @return the element at the front of this deque (which is the top of the stack represented by this deque).
     * @throws NoSuchElementException - if this deque is empty.
     */
    @Override
    public E pop() {
        return removeFirst();
    }

    /**
     * Returns the number of elements in this deque.
     * @return the number of elements in this deque.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an iterator over the elements in this deque in reverse sequential order. The elements will be returned in order from last (tail) to first (head).
     * @return an iterator over the elements in this deque in reverse sequence.
     */
    @Override
    public Iterator<E> descendingIterator() {
        return new GtuDescendingIterator();
    }

    /**
     * Returns an iterator over the elements in this deque in proper sequence. The elements will be returned in order from first (head) to last (tail).
     * @return an iterator over the elements in this deque in proper sequence.
     */
    @Override
    public Iterator<E> iterator() {
        return new GtuIterator();
    }

}
