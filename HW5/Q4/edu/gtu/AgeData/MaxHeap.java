package edu.gtu.AgeData;


import edu.gtu.Heap.MaxHeapUtil;
import java.util.Comparator;

/**
 * MaxHeap class that collects the data related to AgeData.
 * @param <E> type.
 */
public class MaxHeap< E extends AgeDataInterface<E> > extends MaxHeapUtil<E> {

    /**
     * Initiate a MaxHeap with given comparator.
     */
    @SuppressWarnings("unchecked")
    public MaxHeap( ) {
        super( (Comparator<E>) new NumberOfPeopleComparator() );
    }

    /**
     * Add a specific age to heap.
     * <p> If heap has that certain age , increased the number of people of corresponding element.</p>
     * @param item item
     */
    @Override
    public void add( E item ) {

        try {
            E tempNode = find( item );

            if( item == null ) {
                throw new Exception();
            }

            if( tempNode == null ) {
                super.add( item );
            }
            else {
                tempNode.setNumberOfPeople( tempNode.getNumberOfPeople() + 1 );
                updateHeap();
            }
        }
        catch ( Exception ex ) {
            System.out.println("void add(E item) , item cannot be null");
            System.exit( 1 );
        }
    }

    /**
     * Remove the given item from the heap.
     * @param item item
     * @return true if removed otherwise return false.
     */
    @Override
    public boolean remove(E item) {
        try {

            if (item == null) {
                throw new Exception("Null element cannot be removed");
            }

            E tempItem = find( item );

            if (tempItem == null) {
                return false;
            } else if (tempItem.getNumberOfPeople() > 1) {

                tempItem.setNumberOfPeople(tempItem.getNumberOfPeople() - 1);
                updateHeap();

                return true;

            } else if (tempItem.getNumberOfPeople() == 1) {

                return super.remove(tempItem);
            }

        } catch (Exception ex) {
            System.out.println( "remove( AgeData ) , " + ex.getMessage() );
            System.exit(1);
        }
        return false;
    }

    /**
     * Return the number of the people which are younger than given certain age.
     * @param age age
     * @return the number of the people which are younger than given certain age.
     */
    public int youngerThan( int age ) {
        return youngerThan( age , 0 );
    }

    /**
     * Helper method of youngerThan(int)
     * @param age age
     * @param index index
     * @return the number of the people which are younger than given certain age.
     */
    private int youngerThan(  int age , int index ) {

        if( index == theData.size() ) {
            return 0;
        }

        if( theData.get( index ).getAge() < age ) {
            return theData.get( index ).getNumberOfPeople() + youngerThan( age , index + 1 );
        }

        return youngerThan( age , index + 1);
    }

    /**
     * Return the number of the people which are older than given certain age.
     * @param age age
     * @return the number of the people which are older than given certain age.
     */
    public int olderThan( int age ) {
        return olderThan( age , 0 );
    }

    /**
     * Helper method of olderThan(int)
     * @param age age
     * @param index index
     * @return the number of the people which are older than given certain age.
     */
    private int olderThan(  int age , int index ) {

        if( index == theData.size() ) {
            return 0;
        }

        if( theData.get( index ).getAge() > age ) {
            return theData.get( index ).getNumberOfPeople() + olderThan( age , index + 1 );
        }

        return olderThan( age , index + 1);
    }

    /**
     * String representation of MaxHeap.
     * @return String representation of class.
     */
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (E theDatum : theData) {
            sb.append(theDatum).append(" ").append('\n');
        }
        return sb.toString();

    }
}
