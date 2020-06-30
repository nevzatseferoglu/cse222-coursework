package edu.gtu.SoftwareStoreManager;

/**
 * User domain interface.
 */
public interface UserDomain {

    /**
     * Search by name.
     * @param name name of the software ( included version ).
     */
    void searchByName( String name );

}
