package CargoCompany;

/**
 * Default transformation personnel interface.
 */
public interface TransportationPersonnelWorkspace {

    /**
     * List all shipments which are in-transit process.
     */
    void listShipmentWhichIsInTransit();

    /**
     * <p> Set the current status of the shipment. </p>
     * <p> There are some restriction that are indicated in report.</p>
     */
    void setCurrentStatusOfShipment( String currentTrackingNumber , ShipmentStatus newStatus);
}
