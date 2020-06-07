package edu.gtu.TreeAndList;

/**
 * Binary Search Tree Class , extended class has to implement
 * Comparable interface.
 * @param <E> element type that will be stored in tree.
 */
public class BinarySearchTree <E extends Comparable<E>>
                            extends BinaryTree<E>
                            implements SearchTree<E> {

    public BinarySearchTree() {
    }

    private BinarySearchTree( Node<E> localRoot ) {
        super( localRoot );
    }

    /**
     * Return value from the public add method.
     */
    protected boolean addReturn;

    /**
     *Return value from the public delete method.
     */
    protected E deleteReturn;

    /**
     * Size of the BinarySearchTree.
     */
    protected int size;

    /**
     * Check the existence of given target element in tree.
     * @param target item that will be checked.
     * @return true if exists otherwise return false.
     */
    @Override
    public boolean contains(E target) {

        E returnedValue = find( target );
        return returnedValue != null;
    }


    /**  Starter method add.
     * pre : The object to insert must implement the Comparable interface.
     * @param item item the object being inserted.
     * @return true if the object is inserted , false if the object already
     * exist in the tree.
     */
    @Override
    public boolean add(E item) {
        root = add( root , item);

        return  ( addReturn && ((++size) > 0) );
    }

    /**
     * Return current size of the BinarySearchTree.
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * Add a node an item to tree.
     * @param localRoot A starting node for finding appropriate subtree.
     * @param item item that will be inserted to tree.
     * @return added item otherwise return null.
     */
    protected Node<E> add( Node<E> localRoot ,E item ) {

        if( localRoot == null ) {
            addReturn = true;
            return new Node<>( null , item , null );
        }
        else if( item.compareTo( localRoot.item ) == 0 ) {
            addReturn = false;
            return localRoot;
        }
        else if( item.compareTo( localRoot.item ) < 0 ){
            localRoot.left = add( localRoot.left , item );
            return localRoot;
        }
        else {
            localRoot.right = add( localRoot.right , item);
            return localRoot;
        }
    }

    /**
     * Starter method find.
     * pre: The target object must implement
     * the Comparable interface.
     * @param target The COmparable obejct being sought.
     * @return The object , if found , otherwise null.
     */
    @Override
    public E find(E target) {
        return find( root , target );
    }

    /**
     * Recursive find method.
     * @param localRoot localRoot the local subtree's root.
     * @param target The object being sought
     * @return The object , if found , otherwise null.
     */
    protected E find(Node<E> localRoot , E target ) {

        if( localRoot == null ) {
            return null;
        }

        int compResult = target.compareTo( localRoot.item );

        if( compResult == 0 ) {
            return localRoot.item;
        }
        else if( compResult < 0 ) {
            return find( localRoot.left , target );
        }
        else {
            return find( localRoot.right , target );
        }

    }

    /**
     * Delete the given target from the tree.
     * @param target item that will be deleted from the tree.
     * @return deleted item otherwise null.
     */
    @Override
    public E delete(E target) {
        root = delete( root , target );

        if( deleteReturn != null ) {
            --size;
        }

        return deleteReturn;
    }

    /**
     * Delete the the given item , return the corresponding node.
     * @param localRoot A starting node for searching node throughout the tree.
     * @param target item that will be deleted from the tree.
     * @return deleted node otherwise return null.
     */
    private Node<E> delete( Node<E> localRoot , E target ) {

        if( localRoot == null ) {
            return null;
        }

        int compResult = target.compareTo( localRoot.item );

        if( compResult < 0 ) {
            localRoot.left = delete( localRoot.left , target );
            return localRoot;
        }
        else if( compResult > 0 ) {
            localRoot.right = delete( localRoot.right , target );
            return localRoot;
        }
        else {
            deleteReturn = localRoot.item;

            if( localRoot.left == null ) {
                return localRoot.right;
            }
            else if( localRoot.right == null ) {
                return localRoot.left;
            }
            else {
                if( localRoot.left.right == null ) {
                    localRoot.item = localRoot.left.item;
                    localRoot.left = localRoot.left.left;
                }
                else {
                    localRoot.item = findLargestChild( localRoot.left);
                }
                return localRoot;
            }
        }
    }


    /** Return the left subtree.
     @return The left subtree or null if either the root or
     the left subtree is null
     */
    @Override
    protected BinarySearchTree<E> getLeftSubtree() {

        if( root != null && root.left != null ) {
            return new BinarySearchTree<>( root.left );
        }
        else {
            return null;
        }

    }

    /** Return the right subtree.
     @return The right subtree or null if either the root or
     the right subtree is null
     */
    @Override
    protected BinarySearchTree<E> getRightSubtree() {

        if( root != null && root.right != null ) {
            return new BinarySearchTree<>( root.right );
        }
        else {
            return null;
        }

    }

    /**
     * Find the node that is the inorder predecessor and replace it
     * with its left child( if any)
     * post : The inorder predecessor is removed form the tree.
     * @param parent The parent of possible inorder
     *               predecessor(ip)
     * @return The item in the ip
     */
    E findLargestChild(Node<E> parent) {

        if( parent.right.right == null ) {
            E returnedValue = parent.right.item;
            parent.right = parent.right.left;
            return returnedValue;
        }
        else {
            return findLargestChild( parent.right);
        }

    }

    /**
     * Remove given target element from the tree.
     * @param target Element that will be removed.
     * @return true if element removed otherwise return false.
     */
    @Override
    public boolean remove(E target) {
        return delete(target) != null;
    }
}
