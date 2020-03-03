package CargoCompany;

/**
 * <p> Branch Employee class that represents of the branch employee position. </p>
 * <p> Implements BranchEmployeeWorkspace interface. </p>
 * <p> Extends Employee abstract class. </p>
 */
public class BranchEmployee extends Employee implements BranchEmployeeWorkspace {

    /**
     * Branch Employee constructor.
     * @param currentCompany Company of employee.
     * @param currentBranch  Branch of employee.
     * @param employeeID     Branch Employee id.
     * @param forename       Branch Employee forename.
     * @param surname        Branch Employee surname.
     */
    public BranchEmployee(Company currentCompany ,
                         Branch currentBranch ,
                         String employeeID ,
                         String forename ,
                         String surname) {
        super(currentCompany ,currentBranch ,employeeID,forename,surname);
    }

    /**
     * Add new customer to the system.
     * @param shipment customer's shipment.
     */
    public void addCustomer( Shipment shipment ) {
        if( !getCurrentCompany().getShipments().contains(shipment) )
            getCurrentCompany().getShipments().add(shipment);
    }

    /**
     * Remove customer from the system.
     * @param shipment customer's shipment.
     */
    public void removeCustomer( Shipment shipment ){
        removeCustomer(shipment.getTrackingNumber());
    }

    /**
     * Remove customer from the system.
     * @param trackingNumber tracking-number of customer's shipment.
     */
    public void removeCustomer( String trackingNumber ){
        for( Shipment shipment : getCurrentCompany().getShipments() )
            if( shipment.getTrackingNumber().equals(trackingNumber) )
                removeCustomer(shipment);
    }

    /**
     * Set the current status of shipment.
     * @param currentTrackingNumber current tracking-number.
     * @param newStatus new status of the shipment.
     */
    public void setCurrentStatusOfShipment( String currentTrackingNumber , ShipmentStatus newStatus){
        returnShipmentWithTrackingNumber(currentTrackingNumber).setCurrentStatus(newStatus);
    }

    /**
     * Set the current branch of the shipment.
     * @param currentTrackingNumber current tracking-number.
     * @param currentBranch new branch of the shipment.
     */
    public void setCurrentBranchOfShipment(String currentTrackingNumber , Branch currentBranch){
        returnShipmentWithTrackingNumber(currentTrackingNumber).setCurrentBranch(currentBranch);
    }

    /**
     * Set the current tracking-number of the shipment.
     * @param currentTrackingNumber current tracking-number.
     * @param newTrackingNumber new tracking-number of the shipment.
     */
    public void setTrackingNumberOfShipment(String currentTrackingNumber , String newTrackingNumber){
        returnShipmentWithTrackingNumber(currentTrackingNumber).setTrackingNumber(newTrackingNumber);
    }

    /**
     * Set the current description of the shipment.
     * @param currentTrackingNumber current description.
     * @param description new description of the shipment.
     */
    public void setDescriptionOfShipment(String currentTrackingNumber ,String description){
        returnShipmentWithTrackingNumber(currentTrackingNumber).setDescription(description);
    }

    /**
     * Set the current sender-person of the shipment.
     * @param currentTrackingNumber current sender-person.
     * @param senderPerson new sender-person of the shipment as Customer type.
     */
    public void setSenderPersonOfShipment( String currentTrackingNumber , Customer senderPerson){
        returnShipmentWithTrackingNumber(currentTrackingNumber).setSenderPerson(senderPerson);
    }

    /**
     * Set the current receiver-person of the shipment.
     * @param currentTrackingNumber current receiver-person.
     * @param receiverPerson new receiver-person of the shipment as Person type.
     */
    public void setReceiverPersonOfShipment(String currentTrackingNumber ,Person receiverPerson){
        returnShipmentWithTrackingNumber(currentTrackingNumber).setReceiverPerson(receiverPerson);
    }

    /**
     * Return shipment with tracking-number.
     * @param trackingNumber Shipment's tracking-number.
     * @return Shipment that match up given tracking-number.
     */
    public Shipment returnShipmentWithTrackingNumber(String trackingNumber ) {
        for( Shipment shipment : getCurrentCompany().getShipments() )
            if( shipment.getTrackingNumber().equals(trackingNumber) )
                return shipment;

        return null;
    }

    /**
     * <p> Return current position of the employee. </p>
     * <p> Polymorphic function. </p>
     * @return Current position as en enum.
     */
    @Override
    public EmployeePositions getPosition() {
         return EmployeePositions.BRANCH_EMPLOYEE;
    }

}
