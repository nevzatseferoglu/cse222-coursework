package CargoCompany;

/**
 * <p> Transportation Employee class that represents of the branch employee position. </p>
 * <p> Implements TransportationEmployeeWorkspace interface. </p>
 * <p> Extends Employee abstract class. </p>
 */
public class TransportationPersonnel extends Employee implements TransportationPersonnelWorkspace {

    /**
     * Transportation Personnel constructor.
     * @param currentCompany Company of employee.
     * @param currentBranch  Branch of employee.
     * @param employeeID     Transportation Employee id.
     * @param forename       Transportation Employee forename.
     * @param surname        Transportation Employee surname.
     */
    public TransportationPersonnel(Company currentCompany ,
                           Branch currentBranch ,
                           String employeeID ,
                           String forename ,
                           String surname) {
        super(currentCompany ,currentBranch ,employeeID,forename,surname);
    }

    /**
     * List all the shipment that are in-transit status.
     */
    public void listShipmentWhichIsInTransit() {
        for( Shipment shipment : getCurrentCompany().getShipments() )
            if( shipment.getCurrentStatus() == ShipmentStatus.IN_TRANSIT )
                System.out.println( shipment );
    }

    /**
     * <p> Set the current status of the shipment. </p>
     * <p> There are some restriction that are indicated in report.</p>
     */
    public void setCurrentStatusOfShipment( String currentTrackingNumber , ShipmentStatus newStatus) {
        for( Shipment shipment : getCurrentCompany().getShipments() )
            if( shipment.getCurrentStatus() == ShipmentStatus.IN_TRANSIT
                    || shipment.getCurrentStatus() == ShipmentStatus.DELIVERED ) {

                switch ( newStatus ) {
                    case IN_TRANSIT:
                        shipment.setCurrentStatus(ShipmentStatus.IN_TRANSIT);
                        break;
                    case DELIVERED:
                        shipment.setCurrentStatus(ShipmentStatus.DELIVERED);
                        break;
                    default:
                        System.out.println("Invalid Access !");
                        break;
                }
            }
    }

    /**
     * List all the shipment that are in-transit status.
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
        return EmployeePositions.TRANSPORTATION_PERSONNEL;
    }
}
