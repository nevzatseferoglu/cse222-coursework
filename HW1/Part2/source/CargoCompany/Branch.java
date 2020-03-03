package CargoCompany;

/**
 * <p> Branch Class of Company. </p>
 */
public class Branch {

    private String branchID;
    private String branchName;
    private Company currentCompany;

    /**
     * Branch constructor.
     * @param branchID new branch-id of the branch.
     * @param branchName new branch-name of the branch.
     * @param currentCompany company that will obtain this branch.
     */
    public Branch(String branchID , String branchName , Company currentCompany ) {
        this.branchID = branchID;
        this.branchName = branchName;
        this.currentCompany = currentCompany;
    }

    /**
     * Set the current Company
     * @param currentCompany company that will be a new one.
     */
    protected void setCurrentCompany(Company currentCompany) {
        this.currentCompany = currentCompany;
    }

    /**
     * Branch's company information.
     * @return Current Company of the branch.
     */
    public Company getCurrentCompany() {
        return currentCompany;
    }


    /**
     * Set the branch-id.
     * @param branchID new branch-id of the branch.
     */
    protected void setBranchID(String branchID) {
        this.branchID = branchID;
    }

    /**
     * Get the branch-id.
     * @return branch-id as String.
     */
    public String getBranchID() {
        return branchID;
    }

    /**
     * Set the branch-name.
     * @param branchName new branch-name of the branch.
     */
    protected void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    /**
     * Get the branch-name.
     * @return branch-name as String.
     */
    public String getBranchName() {
        return branchName;
    }

    /**
     * Overrided equals method , check  the branch-id of branches in itself.
     * @return true if branch-id equals otherwise return false.
     */
    @Override
    public boolean equals(Object obj) {
        if( obj == null )
            return false;

        if( !(obj instanceof Branch) )
            return false;

        return ( (Branch) obj ).getBranchID().equals( this.getBranchID() );
    }

    /**
     * Overrided toString method , create string representation of the branch.
     * @return branch representation as String.
     */

    @Override
    public String toString() {
        return String.format(   "%n Branch ID      = %s%n" +
                " Branch Name    = %s%n", this.getBranchID() , getBranchName() );
    }
}
