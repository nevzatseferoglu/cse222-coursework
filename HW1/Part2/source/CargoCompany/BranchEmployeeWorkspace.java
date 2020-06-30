package CargoCompany;

/**
 * Default branch employee interface.
 */
public interface BranchEmployeeWorkspace {

    /**
     * Add new customer to the system.
     * @param shipment customer's shipment.
     */
    void addCustomer( Shipment shipment );

    /**
     * Remove customer from the system.
     * @param shipment customer's shipment.
     */
    void removeCustomer( Shipment shipment );

    /**
     * Remove customer from the system.
     * @param trackingNumber tracking-number of customer's shipment.
     */
    void removeCustomer( String trackingNumber );


    /**
     * Set the current status of shipment.
     * @param currentTrackingNumber current tracking-number.
     * @param newStatus new status of the shipment.
     */
    void setCurrentStatusOfShipment( String currentTrackingNumber , ShipmentStatus newStatus);

    /**
     * Set the current branch of the shipment.
     * @param currentTrackingNumber current tracking-number.
     * @param currentBranch new branch of the shipment.
     */
    void setCurrentBranchOfShipment(String currentTrackingNumber , Branch currentBranch);

    /**
     * Set the current tracking-number of the shipment.
     * @param currentTrackingNumber current tracking-number.
     * @param newTrackingNumber new tracking-number of the shipment.
     */
    void setTrackingNumberOfShipment(String currentTrackingNumber , String newTrackingNumber);

    /**
     * Set the current description of the shipment.
     * @param currentTrackingNumber current description.
     * @param description new description of the shipment.
     */
    void setDescriptionOfShipment(String currentTrackingNumber ,String description);

    /**
     * Set the current sender-person of the shipment.
     * @param currentTrackingNumber current sender-person.
     * @param senderPerson new sender-person of the shipment as Customer type.
     */
    void setSenderPersonOfShipment( String currentTrackingNumber , Customer senderPerson);

    /**
     * Set the current receiver-person of the shipment.
     * @param currentTrackingNumber current receiver-person.
     * @param receiverPerson new receiver-person of the shipment as Person type.
     */
    void setReceiverPersonOfShipment(String currentTrackingNumber ,Person receiverPerson);

}
