package edu.gtu.AgeData;

/**
 * AgeData class interface.
 * @param <E> Generic type.
 */
public interface AgeDataInterface<E> extends Comparable<E> {

    /**
     * Set age of current object.
     * @param age age
     */
    void setAge( int age);

    /**
     * A getter method of age.
     * @return age
     */
    int getAge();

    /**
     * Set the number of the people of current object.
     * @param numberOfPeople number that will be set.
     */
    void setNumberOfPeople( int numberOfPeople );

    /**
     * Get number of people in object.
     * @return number of people
     */
    int getNumberOfPeople();

}
