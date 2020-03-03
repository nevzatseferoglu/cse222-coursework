package CargoCompany;

/**
 * <p> Employee Class that represent employee of the company. </p>
 * <p> <i> Implements Cloneable interface. </i> </p>
 * <p> <i> Extends Person. </i> </p>
 */
public class Employee extends Person implements Cloneable{

    private Company currentCompany;
    private Branch currentBranch;
    private String employeeID;
    private EmployeePositions currentPosition;

    /**
     * Set the branch-id of the employee.
     * @param branchID Branch-id that will be set.
     */
    void setBranchID(String branchID) {
        switch ( currentPosition )
        {
            case ADMIN:
                if( !(currentCompany.searchBranchWithID(branchID)) )
                    currentCompany.returnBranchWithID(branchID).setBranchID(branchID);
                else
                    System.out.println("There is another branch with this id number !");
                break;

            case BRANCH_EMPLOYEE:
            case TRANSPORTATION_PERSONNEL:
                System.out.println("Have not permission for setting branch id");
                break;

            default:
                System.out.println("Report : check your" +
                        "declaration and enum definition");
                break;
        }
    }

    /**
     * Set the branch-name of the employee.
     * @param branchName Branch-name that will be set.
     */
    void setBranchName(String branchName) {
        switch ( currentPosition )
        {
            case ADMIN:
                if( !(currentCompany.searchBranchWithName(branchName)) )
                    currentCompany.returnBranchWithName(branchName).setBranchName(branchName);
                else
                    System.out.println("There is another branch with this name !");
                break;

            case BRANCH_EMPLOYEE:
            case TRANSPORTATION_PERSONNEL:
                System.out.println("Have not permission for setting branch name");
                break;

            default:
                System.out.println("Report : check your" +
                        "declaration and enum definition");
                break;
        }
    }

    /**
     * Employee constructor for creating employee.
     * @param currentCompany    Company of the employee.
     * @param currentBranch     Branch of the employee.
     * @param employeeID        Unique employee-id of the employee.
     * @param forename          Employee forename.
     * @param surname           Employee surname.
     * @param currentPosition   Employee Current Position as enum.
     */
    public Employee(Company currentCompany ,Branch currentBranch , String employeeID , String forename , String surname , EmployeePositions currentPosition) {
        super(forename,surname);

        this.currentCompany = currentCompany;
        this.currentBranch = currentBranch;
        this.employeeID = employeeID;
        this.currentPosition = currentPosition;
    }

    /**
     * Get the company of the employee.
     * @return Current company of the employee.
     */
    public Company getCurrentCompany() {
        return currentCompany;
    }

    /**
     * Set the branch of the employee.
     * @param  branch  Branch that will be current branch of employee.
     */
    protected void setOrChangeBranch( Branch branch ) {
        this.currentBranch = branch;
    }

    /**
     * Get the branch of the employee.
     * @return current branch of the employee as branch type.
     */
    public Branch getCurrentBranch() {
        return currentBranch;
    }

    /**
     * get current position of the employee.
     * @return current position as a employee enum type.
     */
    public EmployeePositions getCurrentPosition() {
        return currentPosition;
    }

    /**
     * Set employee-id.
     * @param  employeeID employee-id that will be set as String.
     */
    protected void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    /**
     * Get employee-id.
     * @return current unique employee-id.
     */
    public String getEmployeeID() {
        return employeeID;
    }

    /**
     * Add employee to the system.
     * @param employee new employee that will be added has new unique id number.
     */
    public void addEmployee(Employee employee ) {
        switch ( currentPosition )
        {
            case ADMIN:
                currentCompany.addEmployee(employee);
                break;

            case BRANCH_EMPLOYEE:
            case TRANSPORTATION_PERSONNEL:
                System.out.println("Have not permission for adding employee");
                break;

            default:
                System.out.println("Invalid employee position to addEmployee() , Report : check your" +
                        "declaration and enum definition");
                break;
        }
    }

    /**
     * Print the employee to the screen.
     * @param employeeID print employee info as an output.
     */
    public void employeeInfo(String employeeID) {
        switch ( currentPosition )
        {
            case ADMIN:
                currentCompany.employeeInfo(employeeID);
                break;

            case BRANCH_EMPLOYEE:
            case TRANSPORTATION_PERSONNEL:
                System.out.println("Have not permission !");
                break;

            default:
                System.out.println("Report : check your" +
                        "declaration and enum definition");
                break;
        }
    }

    /**
     * Remove employee that has unique employee-id from the system.
     * @param employee removed employee itself.
     */
    public void removeEmployee( Employee employee ) {
        switch ( currentPosition )
        {
            case ADMIN:
                currentCompany.removeEmployee(employee);
                break;

            case BRANCH_EMPLOYEE:
            case TRANSPORTATION_PERSONNEL:
                System.out.println("Have not permission for removing employee !");
                break;

            default:
                System.out.println("Invalid employee position to removeEmployee() , Report : check your" +
                        "declaration and enum definition");
                break;
        }
    }

    /**
     * Remove employee that has unique employee-id from the system.
     * @param employeeID removed employee's id.
     */
    public void removeEmployee( String employeeID ) {
        switch ( currentPosition )
        {
            case ADMIN:
                currentCompany.removeEmployee(employeeID);
                break;

            case BRANCH_EMPLOYEE:
            case TRANSPORTATION_PERSONNEL:
                System.out.println("Have not permission for removing employee !");
                break;

            default:
                System.out.println("Invalid employee position to removeEmployee() , Report : check your" +
                        "declaration and enum definition");
                break;
        }
    }

    /**
     * Change the branch of current employee.
     * @param employee current employee
     * @param branch branch that will be a new branch of given employee.
     */
    public void changeBranchOfEmployee(Employee employee , Branch branch ) {
        switch ( currentPosition )
        {
            case ADMIN:
                currentCompany.changeBranchOfEmployee(employee,branch);
                break;

            case BRANCH_EMPLOYEE:
            case TRANSPORTATION_PERSONNEL:
                System.out.println("Have not permission for changing branch of the employee");
                break;

            default:
                System.out.println("changeBranchOfEmployee() , Report : check your" +
                        "declaration and enum definition");
                break;
        }
    }

    /**
     * Change the branch of current employee.
     * @param employeeID current employee-id
     * @param branchID branch-id that will be a new branch-id of given employee.
     */
    public void changeBranchOfEmployee(String employeeID , String branchID ) {
        switch ( currentPosition )
        {
            case ADMIN:
                currentCompany.changeBranchOfEmployee(employeeID,branchID);
                break;

            case BRANCH_EMPLOYEE:
            case TRANSPORTATION_PERSONNEL:
                System.out.println("Have not permission for changing branch of the employee");
                break;

            default:
                System.out.println("changeBranchOfEmployee() , Report : check your" +
                        "declaration and enum definition");
                break;
        }
    }

    /**
     * Add new branch to the system.
     * @param branch new branch
     */
    public void addBranch( Branch branch ) {
        switch ( currentPosition )
        {
            case ADMIN:
                currentCompany.addBranch(branch);
                break;

            case BRANCH_EMPLOYEE:
            case TRANSPORTATION_PERSONNEL:
                System.out.println("Have not permission for adding branch");
                break;

            default:
                System.out.println("addBranch() , Report : check your" +
                        "declaration and enum definition");
                break;
        }
    }

    /**
     * Remove existing branch with it representation.
     * @param branch removed branch.
     */
    public void removeBranch( Branch branch ) {
        switch ( currentPosition )
        {
            case ADMIN:
                currentCompany.removeBranch(branch);
                break;

            case BRANCH_EMPLOYEE:
            case TRANSPORTATION_PERSONNEL:
                System.out.println("Have not permission for removing branch");
                break;

            default:
                System.out.println("removeBranch() , Report : check your" +
                        "declaration and enum definition");
                break;
        }
    }

    /**
     * Remove existing branch  with its branch-id.
     * @param branchID removed branch-id.
     */
    public void removeBranch( String branchID ) {
        switch ( currentPosition )
        {
            case ADMIN:
                currentCompany.removeBranch(branchID);
                break;

            case BRANCH_EMPLOYEE:
            case TRANSPORTATION_PERSONNEL:
                System.out.println("Have not permission for removing branch");
                break;

            default:
                System.out.println("removeBranch() , Report : check your" +
                        "declaration and enum definition");
                break;
        }
    }

    /**
     * Add new customer to the system.
     * @param shipment customer's shipment.
     */
    public void addCustomer( Shipment shipment ) {
        switch ( currentPosition )
        {
            case ADMIN:
            case TRANSPORTATION_PERSONNEL:
                System.out.println("Have not permission for adding customer");
                break;

            case BRANCH_EMPLOYEE:
                currentCompany.addCustomer(shipment);
                break;

            default:
                System.out.println("Invalid employee position to addCustomer() , Report : check your" +
                        "declaration and enum definition");
                break;
        }
    }

    /**
     * Remove customer from the system.
     * @param shipment customer's shipment.
     */
    public void removeCustomer( Shipment shipment ) {
        switch ( currentPosition )
        {
            case ADMIN:
            case TRANSPORTATION_PERSONNEL:
                System.out.println("Have not permission for removing customer");
                break;

            case BRANCH_EMPLOYEE:
                currentCompany.removeCustomer(shipment);
                break;

            default:
                System.out.println("Invalid employee position to removeCustomer() , Report : check your" +
                        "declaration and enum definition");
                break;
        }
    }

    /**
     * Remove customer from the system.
     * @param trackingNumber tracking-number of customer's shipment.
     */
    public void removeCustomer( String trackingNumber ) {
        switch ( currentPosition )
        {
            case ADMIN:
            case TRANSPORTATION_PERSONNEL:
                System.out.println("Have not permission for removing customer");
                break;

            case BRANCH_EMPLOYEE:
                currentCompany.removeCustomer(trackingNumber);
                break;

            default:
                System.out.println("Invalid employee position to removeCustomer() , Report : check your" +
                        "declaration and enum definition");
                break;
        }
    }

    /**
     * Set the current status of shipment.
     * @param currentTrackingNumber current tracking-number.
     * @param newStatus new status of the shipment.
     */
    public void setCurrentStatusOfShipment( String currentTrackingNumber , ShipmentStatus newStatus){
        switch ( currentPosition )
        {
            case ADMIN:
                System.out.println("Have not permission !");
                break;

            case BRANCH_EMPLOYEE:
            case TRANSPORTATION_PERSONNEL:
                currentCompany.returnShipmentWithTrackingNumber(currentTrackingNumber).setCurrentStatus(newStatus);
                break;

            default:
                System.out.println(" Report : check your" +
                        "declaration and enum definition");
                break;
        }
    }

    /**
     * Set the current branch of the shipment.
     * @param currentTrackingNumber current tracking-number.
     * @param currentBranch new branch of the shipment.
     */
    public void setCurrentBranchOfShipment(String currentTrackingNumber , Branch currentBranch) {
        switch ( currentPosition )
        {
            case ADMIN:
            case TRANSPORTATION_PERSONNEL:
                System.out.println("Have not permission !");
                break;

            case BRANCH_EMPLOYEE:
                currentCompany.returnShipmentWithTrackingNumber(currentTrackingNumber).setCurrentBranch(currentBranch);
                break;

            default:
                System.out.println(" Report : check your" +
                        "declaration and enum definition");
                break;
        }
    }

    /**
     * Set the current tracking-number of the shipment.
     * @param currentTrackingNumber current tracking-number.
     * @param newTrackingNumber new tracking-number of the shipment.
     */
    public void setTrackingNumberOfShipment(String currentTrackingNumber , String newTrackingNumber) {
        switch ( currentPosition )
        {
            case ADMIN:
            case TRANSPORTATION_PERSONNEL:
                System.out.println("Have not permission !");
                break;

            case BRANCH_EMPLOYEE:
                currentCompany.returnShipmentWithTrackingNumber(currentTrackingNumber).setTrackingNumber(newTrackingNumber);
                break;

            default:
                System.out.println(" Report : check your" +
                        "declaration and enum definition");
                break;
        }
    }

    /**
     * Set the current description of the shipment.
     * @param currentTrackingNumber current description.
     * @param description new description of the shipment.
     */
    public void setDescriptionOfShipment(String currentTrackingNumber ,String description) {
        switch ( currentPosition )
        {
            case ADMIN:
            case TRANSPORTATION_PERSONNEL:
                System.out.println("Have not permission !");
                break;

            case BRANCH_EMPLOYEE:
                currentCompany.returnShipmentWithTrackingNumber(currentTrackingNumber).setDescription(description);
                break;

            default:
                System.out.println(" Report : check your" +
                        "declaration and enum definition");
                break;
        }
    }

    /**
     * Set the current sender-person of the shipment.
     * @param currentTrackingNumber current sender-person.
     * @param senderPerson new sender-person of the shipment as Customer type.
     */
    public void setSenderPersonOfShipment( String currentTrackingNumber , Customer senderPerson) {
        switch ( currentPosition )
        {
            case ADMIN:
            case TRANSPORTATION_PERSONNEL:
                System.out.println("Have not permission !");
                break;

            case BRANCH_EMPLOYEE:
                currentCompany.returnShipmentWithTrackingNumber(currentTrackingNumber).setSenderPerson(senderPerson);
                break;

            default:
                System.out.println(" Report : check your" +
                        "declaration and enum definition");
                break;
        }
    }

    /**
     * Set the current receiver-person of the shipment.
     * @param currentTrackingNumber current receiver-person.
     * @param receiverPerson new receiver-person of the shipment as Person type.
     */
    public void setReceiverPersonOfShipment(String currentTrackingNumber ,Person receiverPerson) {
        switch ( currentPosition )
        {
            case ADMIN:
            case TRANSPORTATION_PERSONNEL:
                System.out.println("Have not permission !");

            case BRANCH_EMPLOYEE:
                currentCompany.returnShipmentWithTrackingNumber(currentTrackingNumber).setReceiverPerson(receiverPerson);
                break;

            default:
                System.out.println(" Report : check your" +
                        "declaration and enum definition");
                break;
        }
    }

    /**
     * List all employees in the company.
     */
    public void listEmployee() {
        switch ( currentPosition )
        {
            case ADMIN:
                currentCompany.listEmployee();
                break;

            case BRANCH_EMPLOYEE:
            case TRANSPORTATION_PERSONNEL:
                System.out.println("Have not permission for listing the company employees");
                break;

            default:
                System.out.println("Invalid employee position to listEmployee() , Report : check your" +
                        "declaration and enum definition");
                break;
        }
    }

    /**
     * List all branches in the company.
     */
    public void listBranches() {
        switch ( currentPosition )
        {
            case ADMIN:
                currentCompany.listBranches();
                break;

            case BRANCH_EMPLOYEE:
            case TRANSPORTATION_PERSONNEL:
                System.out.println("Have not permission for listing the company branches");
                break;

            default:
                System.out.println("Invalid employee position to listBranches() , Report : check your" +
                        "declaration and enum definition");
                break;
        }
    }

    /**
     * Print the shipment-info as an output.
     * @param trackingNumber Shipment's tracking-number.
     */
    public void shipmentInfo( String trackingNumber ) {
        System.out.println( currentCompany.returnShipmentWithTrackingNumber(trackingNumber) );
    }

    /**
     * Print and list the -in-transit shipments as an output.
     */
    public void listShipmentWhichIsInTransit() {
        switch ( currentPosition )
        {
            case ADMIN:
            case BRANCH_EMPLOYEE:
                System.out.println("Have not permission for listing !");
                break;

            case TRANSPORTATION_PERSONNEL:
                currentCompany.listShipmentWhichIsInTransit();
                break;
            default:
                System.out.println("Report : check your" +
                        "declaration and enum definition");
                break;
        }
    }

    /**
     * Print and list the current branch shipments shipments as an output.
     */
    public void listCurrentBranchShipments( ) {
        currentCompany.shipmentInfoWithBranch(currentBranch);
    }

    /**
     * Overrided toString() method.
     * Employee Representation as a String.
     * @return Employee representation as String.
     */
    @Override
    public String toString() {
        return String.format(   "Name             = %s%n" +
                                "Surname          = %s%n" +
                                "Employee ID      = %s%n" +
                                "Branch Name-ID   = %s,%s %n" +
                                "Current Position = %s%n", super.getForename() , super.getSurname() , getEmployeeID() , currentBranch.getBranchName()
                    ,currentBranch.getBranchID(), getCurrentPosition().name() );
    }

    /**
     * Overrided equals() method.
     * @return true if employee id equals otherwise return false;
     */
    @Override
    public boolean equals(Object obj) {
        if( obj  == this )
            return true;

        if( obj == null )
            return false;

        if( !(obj instanceof Employee) )
            return false;

        return ((Employee)obj).getEmployeeID().equals(this.getEmployeeID());
    }

    /**
     * Overrided clone() method.Create new clone of current employee.
     * @return Object Object type that can be downcast to Employee.
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Employee(currentCompany , currentBranch , employeeID , this.getForename() , this.getSurname() , currentPosition );
    }
}
