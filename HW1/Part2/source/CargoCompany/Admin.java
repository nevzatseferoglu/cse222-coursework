package CargoCompany;
/**
 * <p> Admin class that represents of the admin position. </p>
 * <p> Implements AdminWorkspace interface. </p>
 * <p> Extends Employee abstract class. </p>
 * */
public class Admin extends Employee implements AdminWorkspace{

    /**
     * Admin constructor.
     * @param currentCompany Company of employee.
     * @param currentBranch  Branch of employee.
     * @param employeeID     Admin id.
     * @param forename       Admin forename.
     * @param surname        Admin surname.
     */
    public Admin(Company currentCompany ,
          Branch currentBranch ,
          String employeeID ,
          String forename ,
          String surname) {
        super(currentCompany ,currentBranch ,employeeID,forename,surname);
    }

    /**
     * Add employee to the system.
     * @param employee new employee that will be added has new unique id number.
     */
    public void addEmployee(Employee employee ) {
        if( !getCurrentCompany().getEmployees().contains(employee) )
            getCurrentCompany().getEmployees().add(employee);
    }

    /**
     * Remove employee that has unique employee-id from the system.
     * @param employee removed employee itself.
     */
    public void removeEmployee( Employee employee ) {
        if( getCurrentCompany().getEmployees().contains(employee) )
            getCurrentCompany().getEmployees().add(employee);
    }

    /**
     * Remove employee that has unique employee-id from the system.
     * @param employeeID removed employee's id.
     */
    public void removeEmployee( String employeeID ) {
        for( Employee employee : getCurrentCompany().getEmployees() )
            if( employee.getEmployeeID().equals( employeeID ) )
                removeEmployee(employee);
    }

    /**
     * Change the branch of current employee.
     * @param employee current employee-id
     * @param branch branch that will be a new branch of given employee.
     */
    public void changeBranchOfEmployee(Employee employee , Branch branch ) {
        changeBranchOfEmployee(employee.getEmployeeID(),branch.getBranchID());
    }

    /**
     * Change the branch of current employee.
     * @param employeeID current employee-id
     * @param branchID branch-id that will be a new branch-id of given employee.
     */
    public void changeBranchOfEmployee(String employeeID , String branchID ) {
        for (Employee employee : getCurrentCompany().getEmployees())
            if ( employee.getEmployeeID().equals(employeeID) ) {

                for( Branch branch : getCurrentCompany().getBranches() )
                    if( branch.getBranchID().equals( branchID ) )
                        employee.setCurrentBranch(branch);

            }
    }

    /**
     * Print the employee to the screen.
     * @param employeeID print employee info as an output.
     */
    public void employeeInfo(String employeeID) {
        for(Employee employee : getCurrentCompany().getEmployees() )
            if( employee.getEmployeeID().equals(employeeID) )
                System.out.println(employee);
    }


    /**
     * Add new branch to the system.
     * @param branch new branch
     */
    public void addBranch( Branch branch ) {
        if( !getCurrentCompany().getBranches().contains(branch) )
            getCurrentCompany().getBranches().add(branch);
    }

    /**
     * Remove existing branch with it representation.
     * @param branch removed branch.
     */
    public void removeBranch( Branch branch ) {
        if( getCurrentCompany().getBranches().contains( branch ) )
            removeBranch(branch);
    }

    /**
     * Remove existing branch  with its branch-id.
     * @param branchID removed branch-id.
     */
    public void removeBranch( String branchID ) {
        for( Branch branch : getCurrentCompany().getBranches() )
            if( branch.getBranchID().equals( branchID ) )
                removeBranch(branch);
    }

    /**
     * List all branches in the company.
     */
    public void listBranches() {
        System.out.println(getCurrentCompany().getBranches());
    }

    /**
     * Return branch with branch-id.
     * @param branchID unique branch-id.
     * @return Branch that matches given branch-id.
     */
    public Branch returnBranchWithID( String branchID ) {
        for( Branch branch : getCurrentCompany().getBranches() )
            if( branch.getBranchID().equals(branchID) )
                return branch;
        return null;
    }

    /**
     * Return employee with employee-id.
     * @param employeeID unique employee-id.
     * @return Employee that matches given employee-id.
     */
    public Employee returnEmployeeWithID( String employeeID ) {
        for( Employee employee : getCurrentCompany().getEmployees() )
            if( employee.getEmployeeID().equals(employeeID) )
                return employee;
        return null;
    }


    /**
     * <p> Return current position of the employee. </p>
     * <p> Polymorphic function. </p>
     * @return Current position as en enum.
     */
    @Override
    public EmployeePositions getPosition() {
        return EmployeePositions.ADMIN;
    }
}
