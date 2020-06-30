package edu.gtu.AgaData;

/**
 * AgeData class for handling age-based population.
 */
public class AgeData implements AgeDataInterface<AgeData> {

    /**
     * Age
     */
    private int age;

    /**
     * Number of people old current age.
     */
    private int numberOfThing;

    /**
     * Constructor that initiates a person with specific age.
     * @param age age
     */
    public AgeData( int age ) {

        this.age = age;
        numberOfThing = 1;
    }

    /**
     * Set the age of data.
     * @param age age
     */
    @Override
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Get the age of data.
     * @return age
     */
    @Override
    public int getAge() {
        return age;
    }

    /**
     * Set the number of people in data.
     * @param numberOfThing number of people
     */
    @Override
    public void setNumberOfPeople(int numberOfThing) {
        this.numberOfThing = numberOfThing;
    }

    /**
     * Get the number of people in data.
     * @return number of people.
     */
    @Override
    public int getNumberOfPeople() {
        return numberOfThing;
    }

    /**
     * Comparable interface method.
     * @param ageData age
     * @return Depends on values that compared with each other.
     */
    @Override
    public int compareTo(AgeData ageData) {
        try {

            if( ageData == null ) {
                throw new Exception();
            }

            return Integer.compare( this.getAge() , ageData.getAge() );

        }
        catch ( Exception ex ) {
            System.out.println("compareTo(AgeData) , given object cannot be null.");
            System.exit( 1 );
        }


        return this.getAge() - ageData.getAge();
    }

    /**
     * String representation of AgeData class.
     * @return String representation of AgeData class
     */
    @Override
    public String toString() {
        return getAge() + " - " + getNumberOfPeople();
    }
}