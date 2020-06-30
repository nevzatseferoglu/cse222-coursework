package CargoCompany;

import java.util.ArrayList;

/**
 * <p> Company class that represent company properties. </p>
 * <p> Dependency note : Implementation uses ArrayList collections which in java.util </p>
 */
public class Company {

    private String companyName;
    private ArrayList<Employee> employees;
    private ArrayList<Branch> branches;
    private ArrayList<Shipment> shipments;

    /**
     * Company Constructor that will create company
     * @param companyName name of the company.
     */
    public Company( String companyName ) {
        this.companyName = companyName;
        employees = new ArrayList<>();
        branches = new ArrayList<>();
        shipments = new ArrayList<>();
    }

    /**
     * Set employee ArrayList
     * @param employees Employee ArrayList that will be set.
     */
    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    /**
     * Get employee ArrayList
     * @return Current employee ArrayList.
     */
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    /**
     * Set branch ArrayList
     * @param branches Current branch ArrayList that will be set.
     */
    public void setBranches(ArrayList<Branch> branches) {
        this.branches = branches;
    }

    /**
     * Get branch ArrayList
     * @return Current branch ArrayList.
     */
    public ArrayList<Branch> getBranches() {
        return branches;
    }

    /**
     * Set shipment ArrayList
     * @param shipments Current shipment ArrayList that will be set.
     */
    public void setShipments(ArrayList<Shipment> shipments) {
        this.shipments = shipments;
    }

    /**
     * Get shipment ArrayList
     * @return Current shipment ArrayList.
     */
    public ArrayList<Shipment> getShipments() {
        return shipments;
    }


    /**
     * Get current company name.
     * @return name of the company as String.
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Set current company name.
     * @param  companyName new trademark of the company.
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * List all employees in the company.
     */
    public void listEmployee() {
        System.out.println( employees );
    }

    /**
     * Print the shipment-info as an output.
     * @param trackingNumber Shipment's tracking-number.
     */
    public void shipmentInfo( String trackingNumber ) {
        for( Shipment shipment : shipments )
            if( shipment.getTrackingNumber().equals(trackingNumber) )
                System.out.println(shipment);
    }

    /**
     * Search employee with employee-id.
     * @param employeeID employee-id
     * @return Return true if ID matches up otherwise return false.
     */
    public boolean searchEmployeeWithID( String employeeID ) {
        for( Employee employee : employees ) {
            if( employee.getEmployeeID().equals(employeeID) )
                return true;
        }

        return false;
    }

    /**
     * Search branch with branch-id.
     * @param branchID branch-id
     * @return Return true if ID matches up otherwise return false.
     */
    public boolean searchBranchWithID( String branchID ) {
        for( Branch branch : branches )
            if( branch.getBranchID().equals(branchID) )
                return true;
        return false;
    }

    /**
     * Search shipment with tracking-number.
     * @param trackingNumber employee-id
     * @return Return true if ID matches up otherwise return false.
     */
    public boolean searchShipmentWithTrackingNumber( String trackingNumber ) {
        for( Shipment shipment : shipments )
            if( shipment.getTrackingNumber().equals(trackingNumber) )
                return true;
        return false;
    }

    /**
     * <p> Informing customer interface with shipment tracking-number. </p>
     * <p> Print the result as an output. </p>
     */
    public void shipmentInfoForCustomer( String trackingNumber ) {
        for( Shipment shipment : shipments )
            if( shipment.getTrackingNumber().equals(trackingNumber) )
                shipment.shipmentInfoForCustomer();
    }

    /**
     * Overrided toString() method.
     * String representation of current company.
     * @return Company as an String output.
     */
    @Override
    public String toString() {
        String infoCompany = "";
        infoCompany += String.format( "Company  Trademark : %s%n" +
                "Sum of Branch      : %d%n" +
                "Sum of Employee    : %d%n" +
                "Sum of Shipment    : %d%n",getCompanyName() ,branches.size() ,employees.size(),shipments.size());
        return infoCompany;
    }

    /**
     * Overrided equals() method.
     * @return true if all properties of the companies are equivalent otherwise false;
     */
    @Override
    public boolean equals(Object obj) {
        if ( obj == this )
            return true;
        if( obj == null )
            return false;
        if( !(obj instanceof Company) )
            return false;

        return ((Company) obj).branches.equals(this.branches) && ((Company) obj).employees.equals(this.employees)
                && ((Company) obj).shipments.equals(this.shipments);
    }
}
