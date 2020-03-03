package CargoCompany;

/**
 * Shipment class that represents shipment of the company.
 */

public class Shipment {

    private ShipmentStatus currentStatus;
    private Branch currentBranch;
    private String trackingNumber;
    private String description;
    private Customer senderPerson;
    private Person receiverPerson;

    /**
     * Shipment class for creating new shipment.
     * @param description   Description of the shipment as String.
     * @param trackingNumber Unique number that will represent the shipment as String.
     * @param currentBranch Branch that will obtain this shipment.
     * @param senderPerson Customer type , sender person.
     * @param receiverPerson Person type , receiver person.
     */
    public Shipment( String description ,
                     String trackingNumber ,
                     Branch currentBranch,
                     Customer senderPerson,
                     Person receiverPerson) {

        this.description = description;
        this.trackingNumber = trackingNumber;
        this.currentBranch = currentBranch;
        this.senderPerson = senderPerson;
        this.receiverPerson =receiverPerson;

        currentStatus = ShipmentStatus.IN_BRANCH;
    }

    /**
     * Set the tracking-number of shipment.
     * @param trackingNumber set the unique tracking-number.
     */
    protected void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    /**
     * Get the tracking-number of shipment.
     * @return Return current shipment's tracking-number itself.
     */
    public String getTrackingNumber() {
        return trackingNumber;
    }

    /**
     * Set the current branch of the shipment.
     * @param currentBranch Branch that will be as current-branch of the shipment.
     */
    protected void setCurrentBranch(Branch currentBranch) {
        this.currentBranch = currentBranch;
    }

    /**
     * Get the current branch of the shipment.
     * @return return current-branch as Branch.
     */
    public Branch getCurrentBranch() {
        return currentBranch;
    }

    /**
     * Set the current status of the shipment.Status type is a enum.
     * @param currentStatus Status that will be as current-status of the shipment.
     */
    protected void setCurrentStatus(ShipmentStatus currentStatus) {
        this.currentStatus = currentStatus;
    }

    /**
     * Get the current status of the shipment.
     * @return return current-status as enum.
     */
    public ShipmentStatus getCurrentStatus() {
        return currentStatus;
    }

    /**
     * Set the current-sender of the shipment.
     * @param  senderPerson Customer type sender person.
     */
    protected void setSenderPerson(Customer senderPerson) {
        this.senderPerson = senderPerson;
    }

    /**
     * Get the current-sender of the shipment.
     * @return Current sender person as Customer.
     */
    public Customer getSenderPerson() { return senderPerson; }

    /**
     * Set the current-receiver of the shipment.
     * @param  receiverPerson Person type sender person.
     */
    protected void setReceiverPerson(Person receiverPerson) {
        this.receiverPerson = receiverPerson;
    }

    /**
     * Get the current-sender of the shipment.
     * @return Current sender person as Person.
     */
    public Person getReceiverPerson() { return receiverPerson; }

    /**
     * Set the current-description of the shipment.
     * @param description Description that will be as shipment description.
     */
    protected void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the current-description of the shipment.
     * @return Current description of the shipment as String.
     */
    public String getDescription() { return description; }

    /**
     * Shipment String representation for customer interface.
     * Print the shipment information to screen for customer.
     */
    protected void shipmentInfoForCustomer() {
        System.out.printf("Sender           :%s%n" +
                "Receiver         :%s%n" +
                "Status           :%s%n",getSenderPerson() , getReceiverPerson() ,getCurrentStatus().name() );
    }

    /**
     * Overrided equals method , check  the tracking-number of shipment in itself.
     * @return true if tracking-number equals otherwise return false.
     */
    @Override
    public boolean equals(Object obj) {
        if( obj == null )
            return false;

        if( !(obj instanceof Shipment) )
            return false;

        return ( (Shipment) obj ).getTrackingNumber().equals( this.getTrackingNumber() );
    }

    /**
     * Overrided toString method , create string representation of the shipment.
     * @return shipment representation as String.
     */
    @Override
    public String toString() {
        return String.format("Tracking Number  :%s%n" +
                        "Description      :%s%n" +
                        "Sender           :%s%n" +
                        "Receiver         :%s%n" +
                        "Status           :%s%n" , getTrackingNumber() ,
                getDescription(),getSenderPerson() , getReceiverPerson() , getCurrentStatus().name() );
    }
}
