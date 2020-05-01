package edu.gtu.AgaData;

/**
 * Manipulating the AgeData object with Binary Tree implementation.
 * @param <E> type
 */
public class AgeSearchTree<E extends AgeDataInterface<E> > extends BinarySearchTree<E> {

    /**
     * No parameter constructor.
     */
    public AgeSearchTree() {
        super();
    }


    /**
     * Add a specific person to AgeSearchTree
     * @param item item
     * @return true if there is no person with that age , otherwise add but return false.
     */
    @Override
    public boolean add(E item) {
        try {
            E tempNode = find( root , item );

            if( item == null ) {
                throw new Exception();
            }

            if( tempNode == null ) {
                super.add( item );
                return true;
            }
            else {
                tempNode.setNumberOfPeople( tempNode.getNumberOfPeople() + 1 );
                return false;
            }
        }
        catch ( Exception ex ) {
            System.out.println("boolean add(E item) , item cannot be null");
            System.exit( 1 );
        }

        return false;
    }

    /**
     * Remove given target from the tree.
     * @param target Element that will be removed.
     * @return true if removed otherwise false.
     */
    @Override
    public boolean remove(E target) {
        try {
            E tempNode = find(root, target);

            if (target == null) {
                throw new Exception();
            }

            if (tempNode == null) {
                return false;

            } else if (tempNode.getNumberOfPeople() > 1) {

                tempNode.setNumberOfPeople(tempNode.getNumberOfPeople() - 1);
                return true;

            } else if (tempNode.getNumberOfPeople() == 1) {
                super.remove(tempNode);
                return true;
            }

        } catch (Exception ex) {
            System.out.println("boolean remove(E target) , target cannot be null");
            System.exit(1);
        }
        return false;
    }

    /**
     * Find the specific element from the tree and return it.
     * @param target The Comparable object being sought.
     * @return if found otherwise return null.
     */
    @Override
    public E find(E target) {
        return super.find( target );
    }

    /**
     * Return number of people who are younger than given certain age.
     * @param age age
     * @return number of people who are younger than given certain age.
     */
    public int youngerThan( int age ) {
        return youngerThan( root , age );
    }

    /**
     * Return number of people who are younger than given certain age and starting root.
     * <p> Tail recursion </p>
     * @param localRoot Starting node for seeking.
     * @param age age
     * @return number of people who are younger than given certain age.
     */
    private int youngerThan( Node<E> localRoot , int age ) {

        if( localRoot == null ) {
            return 0;
        }

        if( localRoot.data.getAge() < age ) {
            return localRoot.data.getNumberOfPeople()
                    + youngerThan( localRoot.left , age) + youngerThan( localRoot.right , age );
        }

        return youngerThan( localRoot.left , age );
    }

    /**
     * Return number of people who are older than given certain age.
     * @param age age
     * @return number of people who are older than given certain age.
     */
    public int olderThan( int age ) {
        return olderThan( root , age );
    }

    /**
     * Return number of people who are older than given certain age and starting root.
     * <p> Tail recursion </p>
     * @param localRoot Starting node for seeking.
     * @param age age
     * @return number of people who are older than given certain age.
     */
    private int olderThan( Node<E> localRoot , int age ) {

        if( localRoot == null ) {
            return 0;
        }

        if( localRoot.data.getAge() > age ) {
            return localRoot.data.getNumberOfPeople()
                    + olderThan( localRoot.right , age) + olderThan( localRoot.left , age );
        }

        return olderThan( localRoot.right , age );
    }

    /**
     * String representation of tree.
     * @return String representation of tree.
     */
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        preOrderTraverse( root , sb );
        return sb.toString();

    }

    /**
     * <p> Preorder traversed tree. </p>
     * <p> While traversing first visit the node and continue to traversing later.</p>
     * @param localRoot Starting root for traversing over the tree.
     * @param sb The StringBuilder to save the output
     */
    @Override
    protected void preOrderTraverse(Node<E> localRoot, StringBuilder sb) {

        if( localRoot == null ) {
            sb.append("null").append('\n');
        }
        else {
            sb.append( localRoot.data.getAge() )
                    .append(" - ")
                    .append(localRoot.data.getNumberOfPeople())
                    .append('\n');

            preOrderTraverse( localRoot.left , sb );
            preOrderTraverse( localRoot.right , sb );
        }
    }
}
