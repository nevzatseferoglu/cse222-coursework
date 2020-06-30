package edu.gtu.TreeAndList;

public class RedBlackTree<E extends Comparable<E>>
        extends BinarySearchTreeWithRotate<E> {

    private boolean fixupRequired;

    /** Nested class to represent a RedBlack node. */
    private static class RedBlackNode<E> extends BinaryTree.Node<E> {

        // Additional data members
        /** Color indicator. True if red, false if black. */
        private boolean isRed;

        // Constructor
        /** Create a RedBlackNode with the default color of red
         and the given data field.
         @param item The data field
         */
        public RedBlackNode(E item) {
            super( null , item , null );
            isRed = true;
        }

        // Methods
        /** Return a string representation of this object.
        The color (red or black) is appended to the node's contents.
        @return String representation of this object
        */
        @Override
        public String toString() {
            if (isRed) {
                return "Red : " + super.toString();
            } else {
                return "Black: " + super.toString();
            }
        }
    }

    /** Insert an item into the tree. This is the starter method
     of a recursive process.
     @param item - The item to be inserted
     @return true if item inserted, false if item already in the tree.
     */
    public boolean add(E item) {

        if ( root == null ) {

            root = new RedBlackNode<>(item);
            ((RedBlackNode<E>) root).isRed = false;
            /* root is black. */

            return true;
        }
         else {
                root = add((RedBlackNode<E>) root, item);
                ((RedBlackNode<E>) root).isRed = false;
                /* root is always black. */

                return addReturn;
         }
    }

    /** Recursive add method.
     @param localRoot - The root of the subtree
     @param item - The item to be inserted
     @return  updated local root of the subtree
     <p> Post : insertReturn is set false if item is already in the tree </p>
     */
    protected RedBlackNode<E> add(RedBlackNode<E> localRoot, E item) {

        if (localRoot == null) {
            addReturn = true;
            return new RedBlackNode<>(item);
        }

        int compRes = item.compareTo(localRoot.item);

        if ( compRes == 0 ) {

            addReturn = false;
            return localRoot;

        } else if (compRes < 0) {

            if (localRoot.left == null) {
                localRoot.left = new RedBlackNode<>(item);
                addReturn = true;
            } else {
                moveBlackDown(localRoot);
                localRoot.left = add((RedBlackNode<E>) localRoot.left, item);

                if (((RedBlackNode<E>) localRoot.left).isRed) {

                    if (localRoot.left.left != null
                            && ((RedBlackNode<E>) localRoot.left.left).isRed) {

                        ((RedBlackNode<E>) localRoot.left).isRed = false;
                        localRoot.isRed = true;

                        return ((RedBlackNode<E>) rotateRight(localRoot));

                    } else if (localRoot.left.right != null
                            && ((RedBlackNode<E>) localRoot.left.right).isRed) {

                        localRoot.left = rotateLeft(localRoot.left);
                        ((RedBlackNode<E>) localRoot.left).isRed = false;
                        localRoot.isRed = true;

                        return ((RedBlackNode<E>) rotateRight(localRoot));
                    }
                }

            }
            return localRoot;

        } else {

            if (localRoot.right == null) {
                localRoot.right = new RedBlackNode<>(item);
                addReturn = true;
            } else {
                moveBlackDown(localRoot);
                localRoot.right = add((RedBlackNode<E>) localRoot.right, item);
                if (((RedBlackNode<E>) localRoot.right).isRed) {

                    if (localRoot.right.right != null
                            && ((RedBlackNode<E>) localRoot.right.right).isRed) {

                        ((RedBlackNode<E>) localRoot.right).isRed = false;
                        localRoot.isRed = true;

                        return ((RedBlackNode<E>) rotateLeft(localRoot));

                    } else if (localRoot.right.left != null
                            && ((RedBlackNode<E>) localRoot.right.left).isRed) {

                        localRoot.right = rotateRight(localRoot.right);
                        ((RedBlackNode<E>) localRoot.right).isRed = false;
                        localRoot.isRed = true;

                        return ((RedBlackNode<E>) rotateLeft(localRoot));
                    }
                }
            }
            return localRoot;
        }
    }

    /** Method to make the two children of the a sub-tree
     black and the localRoot black.
     @param localRoot The root of the sub-tree
     */
    protected void moveBlackDown( RedBlackNode<E> localRoot ) {

        if( localRoot.left != null && localRoot.right != null ) {
            if( ((RedBlackNode<E>)localRoot.left).isRed && ((RedBlackNode<E>)localRoot.right).isRed ) {

                ((RedBlackNode<E>)localRoot.left).isRed = false;
                ((RedBlackNode<E>)localRoot.right).isRed = false;
                localRoot.isRed = true;
            }
        }
    }


    /** Delete starter method. Removes the given object
     from the binary search tree.
     <p>Post: The object is not in the tree</p>
     @param item - The object to be removed.
     @return The object from the tree that was removed
     or null if the object was not in the tree.
     */
    @Override
    public E delete(E item) {
        fixupRequired = false;
        if (root == null) {
            return null;
        }
        else {
            int compareReturn = item.compareTo(root.item);

            if (compareReturn == 0) {

                E oldValue = root.item;
                root = findReplacement(root);

                if (fixupRequired) {
                    root = fixupLeft(root);
                }

                return oldValue;

            }
            else if (compareReturn < 0) {

                if (root.left == null) {
                    return null;
                }
                else {

                    E oldValue = removeFromLeft(root, item);
                    if (fixupRequired) {
                        root = fixupLeft(root);
                    }
                    return oldValue;

                }

            }
            else {

                if (root.right == null) {
                    return null;
                }
                else {
                    E oldValue = removeFromRight(root, item);
                    if (fixupRequired) {
                        root = fixupRight(root);
                    }
                    return oldValue;
                }

            }
        }
    }

    /** Recursive remove from left sub-tree method.
     Removes the given object from the binary search tree.
     Pre: The values of parent and parent.left are are not null
     The object is less than parent.data
     <p> Post : The object is removed from the tree </p>
     @param parent - Parent of the root of the subtree
     @param item - The object to be removed
     @return The object that was removed or null
     if the item is not in the tree
     */
    private E removeFromLeft(Node < E > parent, E item) {
        if (item.compareTo(parent.left.item) < 0) {
            if (parent.left.left == null) {
                return null;
            }
            else {
                E oldValue = removeFromLeft(parent.left, item);
                if (fixupRequired) {
                    parent.left = fixupLeft(parent.left);
                }
                return oldValue;
            }
        }
        else if (item.compareTo(parent.left.item) > 0) {
            if (parent.left.right == null) {
                return null;
            }
            else {
                E oldValue = removeFromRight(parent.left, item);
                if (fixupRequired) {
                    parent.left = fixupRight(parent.left);
                }
                return oldValue;
            }
        }
        else {
            E oldValue = parent.left.item;
            parent.left = findReplacement(parent.left);
            if (fixupRequired) {
                parent.left = fixupLeft(parent.left);
            }
            return oldValue;
        }
    }

    /** Recursive remove from right sub-tree method.
     Removes the given object from the binary search tree.
     <p> Pre :The values of parent and parent.right are not null </p>
     The object is greater than parent.data
     <p> Post :The object is removed from the tree </p>
     @param parent - Parent of the root of the subtree
     @param item - The object to be removed
     @return The object that was removed or null
     if the item is not in the tree
     */
    private E removeFromRight(Node < E > parent, E item) {
        if (item.compareTo(parent.right.item) < 0) {
            if (parent.right.left == null) {
                return null;
            }
            else {
                E oldValue = removeFromLeft(parent.right, item);
                if (fixupRequired) {
                    parent.right = fixupLeft(parent.right);
                }
                return oldValue;
            }
        }
        else if (item.compareTo(parent.right.item) > 0) {
            if (parent.right.right == null) {
                return null;
            }
            else {
                E oldValue = removeFromRight(parent.right, item);
                if (fixupRequired) {
                    parent.right = fixupRight(parent.right);
                }
                return oldValue;
            }
        }
        else {
            E oldValue = parent.right.item;
            parent.right = findReplacement(parent.right);
            if (fixupRequired) {
                parent.right = fixupLeft(parent.right);
            }
            return oldValue;
        }
    }

    /** Function to find a replacement for a node that is being
     deleted from a binary search tree.  If the node has a null
     child, then the replacement is the other child.  If neither
     are null, then the replacement is the largest value less
     than the item being removed.
     <p> Pre : node is not null </p>
     <p> a node is deleted from the tree </p>
     @param node The node to be deleted or replaced
     @return null if both of node's children are null
     node.left if node.right is null
     node.right if node.left is null
     modified copy of node with its data field changed
     */
    private Node < E > findReplacement(Node < E > node) {
        if (node.left == null) {
            if ( ( (RedBlackNode < E > ) node).isRed) {
                return node.right;
            }
            else if (node.right == null) {
                fixupRequired = true;
                return null;
            }
            else if ( ( (RedBlackNode < E > ) node.right).isRed) {
                ( (RedBlackNode < E > ) node.right).isRed = false;
                return node.right;
            }
            else {
                throw new RuntimeException("Invalid Red-Black Tree Structure");
            }
        }
        else if (node.right == null) {
            if ( ( (RedBlackNode < E > ) node).isRed) {
                return node.left;
            }
            else if ( ( (RedBlackNode < E > ) node.left).isRed) {
                ( (RedBlackNode < E > ) node.left).isRed = false;
                return node.left;
            }
            else {
                throw new RuntimeException("Invalid Red-Black Tree structure");
            }
        }
        else {
            if (node.left.right == null) {
                node.item = node.left.item;
                if ( ( (RedBlackNode < E > ) node.left).isRed) {
                    node.left = node.left.left;
                }
                else if (node.left.left == null) {
                    fixupRequired = true;
                    node.left = null;
                }
                else if ( ( (RedBlackNode < E > ) node.left.left).isRed) {
                    ( (RedBlackNode < E > ) node.left.left).isRed = false;
                    node.left = node.left.left;
                }
                else {
                    throw new
                            RuntimeException("Invalid Red-Black Tree structure");
                }
                return node;
            }
            else {
                node.item = findLargestChild(node.left);
                if (fixupRequired) {
                    node.left = fixupRight(node.left);
                }
                return node;
            }
        }
    }

    /** Find the node such that parent.right.right == null
     <p> Pre : The found node is removed from the tree and replaced
     by its left child (if any) </p>
     @param parent - The possible parent
     @return the value of the found node
     */
    @Override
    protected E findLargestChild(Node < E > parent) {
        if (parent.right.right == null) {
            E returnValue = parent.right.item;
            if ( ( (RedBlackNode < E > ) parent.right).isRed) {
                parent.right = parent.right.left;
            }
            else if (parent.right.left == null) {
                fixupRequired = true;
                parent.right = null;
            }
            else if ( ( (RedBlackNode < E > ) parent.right.left).isRed) {
                ( (RedBlackNode < E > ) parent.right.left).isRed = false;
                parent.right = parent.right.left;
            }
            else {
                throw new RuntimeException("Invalid Red-Black Tree structure");
            }
            return returnValue;
        }
        else {
            E returnValue = findLargestChild(parent.right);
            if (fixupRequired) {
                parent.right = fixupRight(parent.right);
            }
            return returnValue;
        }
    }

    /** Method to restore black balance to a subtree whose right black
     height is currently one less than the left black height.
     @param localRoot - The root of the tree needing fixing
     @return A new local root
     */
    private Node < E > fixupRight(Node < E > localRoot) {
        if (localRoot == null)return localRoot;
        if ( ( (RedBlackNode < E > ) localRoot).isRed) {
            ( (RedBlackNode < E > ) localRoot).isRed = false;
            if (localRoot.left.right != null
                    && ( (RedBlackNode < E > ) localRoot.left.right).isRed) {
                localRoot.left = rotateLeft(localRoot.left);
                fixupRequired = false;
                return rotateRight(localRoot);
            }
            else if (localRoot.left.left != null
                    && ( (RedBlackNode < E > ) localRoot.left.left).isRed) {
                ( (RedBlackNode < E > ) localRoot.left.left).isRed = false;
                ( (RedBlackNode < E > ) localRoot.left).isRed = true;
                fixupRequired = false;
                return rotateRight(localRoot);
            }
            else {
                ( (RedBlackNode < E > ) localRoot.left).isRed = true;
                fixupRequired = false;
                return localRoot;
            }
        }
        else {
            if ( ( (RedBlackNode < E > ) localRoot.left).isRed) {
                ( (RedBlackNode < E > ) localRoot).isRed = true;
                ( (RedBlackNode < E > ) localRoot.left).isRed = false;
                localRoot.left = rotateLeft(localRoot.left);
                Node < E > temp = rotateRight(localRoot);
                return rotateRight(temp);
            }
            else {
                ( (RedBlackNode<E>) localRoot.left).isRed = true;
                return localRoot;
            }
        }
    }

    /** Method to restore black balance to a subtree whose left black
     height is currently one less than the right black height.
     @param localRoot - The root of the tree needing fixing
     @return A new local root
     */
    private Node < E > fixupLeft(Node < E > localRoot) {
        if (localRoot == null) return localRoot;
        if ( ( (RedBlackNode < E > ) localRoot).isRed) {
            ( (RedBlackNode < E > ) localRoot).isRed = false;
            if (localRoot.right.left != null
                    && ( (RedBlackNode < E > ) localRoot.right.left).isRed) {
                localRoot.right = rotateRight(localRoot.right);
                fixupRequired = false;
                return rotateLeft(localRoot);
            }
            else if (localRoot.right.right != null
                    && ( (RedBlackNode < E > ) localRoot.right.right).isRed) {
                ( (RedBlackNode < E > ) localRoot.right.right).isRed = false;
                ( (RedBlackNode < E > ) localRoot.right).isRed = true;
                fixupRequired = false;
                return rotateLeft(localRoot);
            }
            else {
                ( (RedBlackNode < E > ) localRoot.right).isRed = true;
                fixupRequired = false;
                return localRoot;
            }
        }
        else {
            if ( ( (RedBlackNode < E > ) localRoot.right).isRed) {
                ( (RedBlackNode < E > ) localRoot).isRed = true;
                ( (RedBlackNode < E > ) localRoot.right).isRed = false;
                localRoot.right = rotateRight(localRoot.right);
                Node < E > temp = rotateLeft(localRoot);
                return rotateLeft(temp);
            }
            else {
                ( (RedBlackNode < E > ) localRoot.right).isRed = true;
                return localRoot;
            }
        }
    }

}



