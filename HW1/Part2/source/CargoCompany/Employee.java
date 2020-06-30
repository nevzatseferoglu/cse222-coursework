package CargoCompany;

/**
 * <p> <i> Abstract class that extends Person . </i> </p>
 * <p> Abstract class that implements EmployeeWorkspace. </p>
 */
public abstract class Employee extends Person implements EmployeeWorkspace{

    private Company currentCompany;
    private Branch currentBranch;
    private String employeeID;

    /**
     * Employee Constructor.
     * @param currentCompany Company of employee.
     * @param currentBranch  Branch of employee.
     * @param employeeID     Employee id.
     * @param forename       Employee forename.
     * @param surname        Employee surname.
     */
    public Employee(Company currentCompany ,
                    Branch currentBranch ,
                    String employeeID ,
                    String forename ,
                    String surname) {
        super(forename,surname);

        this.currentCompany = currentCompany;
        this.currentBranch = currentBranch;
        this.employeeID = employeeID;
    }

    /**
     * Set current company of employee.
     * @param currentCompany Company of employee.
     */
    protected void setCurrentCompany(Company currentCompany) {
        this.currentCompany = currentCompany;
    }

    /**
     * Get current company of employee.
     * @return Company of employee.
     */
    public Company getCurrentCompany() {
        return currentCompany;
    }

    /**
     * Set a current branch of employee.
     * @param currentBranch Branch of employee.
     */
    protected void setCurrentBranch(Branch currentBranch) {
        this.currentBranch = currentBranch;
    }

    /**
     * Get a current branch of employee.
     * @return Branch of employee.
     */
    public Branch getCurrentBranch() {
        return currentBranch;
    }

    /**
     * Set a current id of employee.
     * @param employeeID ID of employee.
     */
    protected void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    /**
     * Get a current id of employee.
     * @return Branch of employee.
     */
    public String getEmployeeID() {
        return employeeID;
    }

    /**
     * List all the shipments that belongs to current branch.
     */
    @Override
    public void listCurrentBranchShipments() {
        for( Shipment shipment : getCurrentCompany().getShipments() )
            if( shipment.getCurrentBranch().getBranchID().equals( getCurrentBranch().getBranchID() ) )
                System.out.println( shipment );
    }

    /**
     * List all employees in the company.
     */
    @Override
    public void listEmployee() {
        getCurrentCompany().listEmployee();
    }

    /**
     * Print the shipment-info as an output.
     * @param trackingNumber Shipment's tracking-number.
     */
    @Override
    public void shipmentInfo(String trackingNumber) {
        getCurrentCompany().shipmentInfo( trackingNumber );
    }

    /**
     * Overrided toString() method.
     * Employee Representation as a String.
     * @return Employee representation as String.
     */
    @Override
    public String toString() {
        return String.format(   "%n Name              = %s%n" +
                        " Surname           = %s%n" +
                        " Employee ID       = %s%n" +
                        " Branch Name-ID    = %s,%s%n" +
                        " Employee Position = %s%n", super.getForename() , super.getSurname() ,
                getEmployeeID() , this.getCurrentBranch().getBranchName()
                ,this.getCurrentBranch().getBranchID() , this.getPosition().name() );
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

}
