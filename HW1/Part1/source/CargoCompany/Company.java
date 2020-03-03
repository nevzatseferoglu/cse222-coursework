package CargoCompany;

import CargoCompany.CompanyArray.GTUSet;

/**
 * <p> Main company class that represent company. </p>
 * <p> There is some has a relation in it. </p>
 */
public class Company {

    private String companyName;
    private GTUSet<Employee> employees;
    private GTUSet<Branch> branches;
    private GTUSet<Shipment> shipments;

    /**
     * Add employee to the system.
     * @param employee new employee that will be added has new unique id number.
     */
    public void addEmployee(Employee employee ) {
        if( searchBranchWithID( employee.getCurrentBranch().getBranchID()) ) {
            employees.insert(employee);
        }
    }

    /**
     * Remove employee that has unique employee-id from the system.
     * @param employee removed employee itself.
     */
    public void removeEmployee( Employee employee ) {
        employees.erase(employee);
    }

    /**
     * Remove employee that has unique employee-id from the system.
     * @param employeeID removed employee's id.
     */
    public void removeEmployee( String employeeID ) {

        for( int i = 0; i < employees.size() ; ++i )
            if( employeeID.equals( employees.getArrayIndex(i).getEmployeeID()) )
                employees.erase(employees.getArrayIndex(i));
    }

    /**
     * Change the branch of current employee.
     * @param employee current employee-id
     * @param branch branch that will be a new branch of given employee.
     */
    void changeBranchOfEmployee(Employee employee , Branch branch ) {
        changeBranchOfEmployee(employee.getEmployeeID() , branch.getBranchID() );
    }

    /**
     * Change the branch of current employee.
     * @param employeeID current employee-id
     * @param branchID branch-id that will be a new branch-id of given employee.
     */
    void changeBranchOfEmployee(String employeeID , String branchID ) {
        if( !(searchEmployeeWithID(employeeID) || searchBranchWithID(branchID)) )
            System.out.println("Invalid branchID or employeeID");
        else
        {
            for(int i = 0 ; i < employees.size() ; ++i)
                if(employees.getArrayIndex(i).getEmployeeID().equals(employeeID))
                    employees.getArrayIndex(i).setOrChangeBranch(returnBranchWithID(branchID));
        }

    }

    /**
     * Add new branch to the system.
     * @param branch new branch
     */
    public void addBranch( Branch branch ) {
        branches.insert(branch);
    }

    /**
     * Remove existing branch with it representation.
     * @param branch removed branch.
     */
    public void removeBranch( Branch branch ) {

            for( int i = 0 ; i < employees.size() ; ++i )
                if( employees.getArrayIndex(i).getCurrentBranch().equals(branch) ) {
                    employees.erase( employees.getArrayIndex(i) );
                    --i;
                }

            for( int i = 0 ; i < shipments.size() ; ++i )
                if( shipments.getArrayIndex(i).getCurrentBranch().equals(branch) ) {
                    shipments.erase( shipments.getArrayIndex(i) );
                    --i;
                }

        branches.erase(branch);
    }

    /**
     * Remove existing branch  with its branch-id.
     * @param branchID removed branch-id.
     */
    public void removeBranch( String branchID ) {

        if( branchID.equals("1") )
            System.out.println("Headquarter cannot be removed !");
        else
        {
            for( int i = 0; i < branches.size() ; ++i )
                if( branchID.equals( branches.getArrayIndex(i).getBranchID() ) )
                    removeBranch(branches.getArrayIndex(i));
        }
    }

    /**
     * Add new customer to the system.
     * @param shipment customer's shipment.
     */
    void addCustomer( Shipment shipment ) {
        shipments.insert(shipment);
    }

    /**
     * Print the employee to the screen.
     * @param employeeID print employee info as an output.
     */
    void employeeInfo(String employeeID) {
        System.out.println( returnEmployeeWithID(employeeID) );
    }

    /**
     * Remove customer from the system.
     * @param shipment customer's shipment.
     */
    void removeCustomer( Shipment shipment ) {
        shipments.erase(shipment);
    }

    /**
     * Remove customer from the system.
     * @param trackingNumber tracking-number of customer's shipment.
     */
    void removeCustomer( String trackingNumber ) {
        for( int i = 0; i < shipments.size() ; ++i )
            if( trackingNumber.equals( shipments.getArrayIndex(i).getTrackingNumber() ) )
                shipments.erase(shipments.getArrayIndex(i));
    }

    /**
     * Search employee with its unique id
     * @param employeeID unique employee-id
     * @return true if there is match-up otherwise false.
     */
    public boolean searchEmployeeWithID( String employeeID ) {
        for( int i = 0 ; i < employees.size() ; ++i )
            if( employees.getArrayIndex(i).getEmployeeID().equals(employeeID) )
                return true;
        return false;
    }

    /**
     * Return employee with employee-id.
     * @param employeeID unique employee-id.
     * @return Employee that matches given employee-id.
     */
    public Employee returnEmployeeWithID( String employeeID ) {
        for( int i = 0 ; i < employees.size() ; ++i )
            if( employees.getArrayIndex(i).getEmployeeID().equals(employeeID) )
                return employees.getArrayIndex(i);
        return null;
    }

    /**
     * Search branch with its unique id
     * @param branchID unique employee-id
     * @return true if there is match-up otherwise false.
     */
    public boolean searchBranchWithID( String branchID ) {
        for( int i = 0 ; i < branches.size() ; ++i )
            if( branches.getArrayIndex(i).getBranchID().equals(branchID) )
                return true;
        return false;
    }

    /**
     * Return branch with branch-id.
     * @param branchID unique branch-id.
     * @return Branch that matches given branch-id.
     */
    public Branch returnBranchWithID( String branchID ) {
        for( int i = 0 ; i < branches.size() ; ++i )
            if( branches.getArrayIndex(i).getBranchID().equals(branchID) )
                return branches.getArrayIndex(i);
        return new Branch("!" ,"!",this);
    }

    /**
     * Search branch with its branch-name
     * @param branchName unique branch-name
     * @return true if there is match-up otherwise false.
     */
    boolean searchBranchWithName( String branchName ) {
        for( int i = 0 ; i < branches.size() ; ++i )
            if( branches.getArrayIndex(i).getBranchName().equals(branchName) )
                return true;
        return false;
    }

    /**
     * Return branch with branch-name.
     * @param branchName unique branch-name.
     * @return Branch that matches given branch-name.
     */
    Branch returnBranchWithName( String branchName ) {
        for( int i = 0 ; i < branches.size() ; ++i )
            if( branches.getArrayIndex(i).getBranchName().equals(branchName) )
                return branches.getArrayIndex(i);
        return new Branch("!" ,"!",this);
    }

    /**
     * Search shipment with its tracking-number.
     * @param trackingNumber unique shipment tracking-number.
     * @return true if there is match-up otherwise false.
     */
    public boolean searchShipmentWithTrackingNumber( String trackingNumber ) {
        for(int i = 0 ; i < shipments.size() ; ++i )
            if( shipments.getArrayIndex(i).getTrackingNumber().equals(trackingNumber))
                return true;
        return false;
    }

    /**
     * Return shipment with its tracking-number.
     * @param trackingNumber unique shipment tracking-number.
     * @return Shipment that match given tracking-number other wise return null.
     */
    public Shipment returnShipmentWithTrackingNumber( String trackingNumber ) {
        for( int i = 0 ; i < shipments.size() ; ++i )
            if( shipments.getArrayIndex(i).getTrackingNumber().equals(trackingNumber) )
                return shipments.getArrayIndex(i);

        return null;
    }

    /**
     * Print the current branch shipment info to the screen.
     * @param branch unique branch.
     */
    void shipmentInfoWithBranch( Branch branch ) {
        GTUSet<Shipment> temporary = new GTUSet<>();

        for( int i = 0 ; i < shipments.size() ; ++i )
            if( shipments.getArrayIndex(i).getCurrentBranch().equals(branch) )
                temporary.insert(shipments.getArrayIndex(i));

        System.out.println(temporary.toString());

        temporary = null;
    }

    /**
     * Print the current branch shipment info to the screen.
     * @param branchID unique branch-id.
     */
    void shipmentInfoWithBranchID( String branchID ) {
        GTUSet<Shipment> temporary = new GTUSet<>();

        for( int i = 0 ; i < shipments.size() ; ++i )
            if( shipments.getArrayIndex(i).getCurrentBranch().getBranchID().equals(branchID) )
                temporary.insert(shipments.getArrayIndex(i));

        System.out.println(temporary.toString());

        temporary = null;
    }

    /**
     * Company Constructor that will create company
     * @param companyName name of the company.
     */
    public Company( String companyName ) {
        this.companyName = companyName;
        employees = new GTUSet<>();
        branches = new GTUSet<>();
        shipments = new GTUSet<>();
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
        System.out.println(employees.toString());
    }

    /**
     * List all branches in the company.
     */
    public void listBranches() {
        System.out.println(branches.toString());
    }

    /**
     * Print and list the -in-transit shipments as an output.
     */
    void listShipmentWhichIsInTransit() {
        GTUSet<Shipment> tempInTransitShipment = new GTUSet<>();
        for( int i = 0 ; i < shipments.size() ; ++i )
            if(shipments.getArrayIndex(i).getCurrentStatus() == ShipmentStatus.IN_TRANSIT )
                tempInTransitShipment.insert(shipments.getArrayIndex(i));

        System.out.println(tempInTransitShipment.toString());
    }

    /**
     * Print the shipment-info as an output.
     * @param trackingNumber Shipment's tracking-number.
     */
    public void shipmentInfo( String trackingNumber ) {
        System.out.println( this.returnShipmentWithTrackingNumber(trackingNumber) );
    }

    /**
     * <p> Informing customer interface with shipment tracking-number. </p>
     * <p> Print the result as an output. </p>
     */
    public void shipmentInfoForCustomer( String trackingNumber ) {
        this.returnShipmentWithTrackingNumber(trackingNumber).shipmentInfoForCustomer();
    }

    /**
     * Overrided clone() method , call object clone().Create new clone of current employee.
     * @return Object Object type that can be downcast to Comapny.
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
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
     * @return true if all properties of the companies are equivalent  otherwise false;
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
