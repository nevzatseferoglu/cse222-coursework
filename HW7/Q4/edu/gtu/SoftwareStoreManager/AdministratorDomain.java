package edu.gtu.SoftwareStoreManager;

/**
 * Administrator functionality.
 */
public interface AdministratorDomain {

    /**
     * Add a new software to the system.
     * @param s software
     * @return true if there is now software with this name ,otherwise return false.
     */
    boolean add( Software s );

    /**
     * Delete given software.
     * @param s software
     * @return true if deleted otherwise return false.
     */
    boolean delete( Software s );

    /**
     * Update the information about given software.
     * @param s software
     * @return updated software.
     */
    Software update( Software s );
}
