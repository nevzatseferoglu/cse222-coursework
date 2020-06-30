package CargoCompany;

/**
 * Concrete Person class that represents person with little perspective.
 */
public class Person {
    private String forename;
    private String surname;

    /**
     * Person Constructor for creating Person.
     * @param forename Forename of the person as String.
     * @param surname Surname of the person as String.
     */
    public Person( String forename , String surname ) {
        this.forename = new String(forename);
        this.surname = new String(surname);
    }

    /**
     * Person Constructor for creating Person.
     * @param customerInfo whole String representation of the person that will be parsing automatically.
     */
    public Person( String customerInfo ) {

        if( !customerInfo.contains(" ") ) {
            setOrChangeForename(customerInfo);
            setOrChangeSurname("");
        }
        else
        {
            String[] gottenData = customerInfo.split(" ", 0);
            for(int i = 0; i < gottenData.length ; ++i )
                if( i + 1 != gottenData.length )
                {
                    if( forename != null )
                        forename += " " + gottenData[ i ];
                    else
                        forename = new String( gottenData[ i ] ) ;
                }
                else
                    surname = new String( gottenData[ i ]);

            gottenData = null;
        }

    }

    /**
     * Set forename of the person.
     * @param forename Person forename that will be set.
     */
    public void setOrChangeForename(String forename) {
        this.forename = new String(forename);
    }

    /**
     * Get forename of the person.
     * @return forename Person forename.
     */
    public String getForename() {
        return forename;
    }

    /**
     * Set surname of the person.
     * @param surname Person forename that will be set.
     */
    public void setOrChangeSurname(String surname) {
        this.surname = new String(surname);
    }

    /**
     * Get surname of the person.
     * @return surname Person forename.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Overrided toString() method.
     * @return Representation of person as String.
     */
    @Override
    public String toString() {
        return forename + ' ' + surname ;
    }

    /**
     * Overrided clone() method.Create clone person.
     * @return Object that can be downcast to person.
     */
    @Override
    public Object clone() {
        return new Person(getForename(),getForename());
    }

    /**
     * Overrided equals() method.Create clone person.
     * Check the equivalence of the persons.
     * @return true if both forename and surname equal otherwise return false.
     */
    @Override
    public boolean equals(Object obj) {
        if( obj == null )
            return false;

        if( !(obj instanceof Person) )
            return false;

        return ((Person) obj).forename.equals(this.forename) && ((Person) obj).surname.equals(this.surname);
    }
}
