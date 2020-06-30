package CargoCompany;

/**
 * Default employee interface.
 */
public interface EmployeeWorkspace {
    /**
     * List shipments that belongs to current branch as output.
     */
    void listCurrentBranchShipments();

    /**
     * Shipment info as an output.
     * @param trackingNumber shipment's tracking-number that will print.
     */
    void shipmentInfo( String trackingNumber );

    /**
     * List all the employee in the company.
     */
    void listEmployee();

    /**
     * <p> Return the current position of employee as enum type. </p>
     * <p> Polymorphic function that will be implemented in non-interface class </p>
     */
    EmployeePositions getPosition();
}
