package CargoCompany;

/**
 * Branch Class of Company
 * There is so many branch properties in it.
 * Implements Cloneable interface.
 */
public class Branch implements Cloneable{

    private String branchID;
    private String branchName;
    private Company currentCompany;

    /**
     * Branch's company information.
     * @return Current Company of the branch.
     */
    protected Company getCurrentCompany() {
        return currentCompany;
    }

    /**
     * Set the branch-id.
     * @param branchID new branch-id of the branch.
     */
    void setBranchID(String branchID) {
        this.branchID = branchID;
    }

    /**
     * Set the branch-name.
     * @param branchName new branch-name of the branch.
     */
    void setBranchName(String branchName) {
        this.branchName = branchName;
    }

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
     * Get the branch-id.
     * @return branch-id as String.
     */
    public String getBranchID() {
        return branchID;
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
     * Overrided clone method , create clone of current branch.
     * @return Object , which can be downcast to Branch type.
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Branch( getBranchID() , getBranchName() , getCurrentCompany() );
    }

    /**
     * Overrided toString method , create string representation of the branch.
     * @return branch representation as String.
     */
    @Override
    public String toString() {
        return String.format(   "Branch ID      = %s%n" +
                                "Branch Name    = %s%n", this.getBranchID() , getBranchName() );
    }
}
