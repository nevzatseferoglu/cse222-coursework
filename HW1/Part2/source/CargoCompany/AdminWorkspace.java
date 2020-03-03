package CargoCompany;

/**
 * Default admin interface.
 */
public interface AdminWorkspace {

    /**
     * Add employee to the system.
     * @param employee new employee that will be added has new unique id number.
     */
    void addEmployee(Employee employee );

    /**
     * Remove employee that has unique employee-id from the system.
     * @param employee removed employee itself.
     */
    void removeEmployee( Employee employee );

    /**
     * Remove employee that has unique employee-id from the system.
     * @param employeeID removed employee's id.
     */
    void removeEmployee( String employeeID );

    /**
     * Change the branch of current employee.
     * @param employee current employee-id
     * @param branch branch that will be a new branch of given employee.
     */
    void changeBranchOfEmployee(Employee employee , Branch branch );

    /**
     * Change the branch of current employee.
     * @param employeeID current employee-id
     * @param branchID branch-id that will be a new branch-id of given employee.
     */
    void changeBranchOfEmployee(String employeeID , String branchID );

    /**
     * Print the employee to the screen.
     * @param employeeID print employee info as an output.
     */
    void employeeInfo(String employeeID);


    /**
     * Add new branch to the system.
     * @param branch new branch
     */
    void addBranch( Branch branch );

    /**
     * Remove existing branch with it representation.
     * @param branch removed branch.
     */
    void removeBranch( Branch branch );

    /**
     * Remove existing branch  with its branch-id.
     * @param branchID removed branch-id.
     */
    void removeBranch( String branchID );

    /**
     * List all branches in the company.
     */
    void listBranches();
}
