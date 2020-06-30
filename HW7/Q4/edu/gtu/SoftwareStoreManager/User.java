package edu.gtu.SoftwareStoreManager;

/**
 * User class that can browse the store.
 */
public class User implements UserDomain {

    /**
     * General Storage.
     */
    SystemStorage systemStorage;

    /**
     * Initialize an user.
     * @param systemStorage Storage which holds the crucial data.
     */
    User( SystemStorage systemStorage ) {
        this.systemStorage = systemStorage;
    }

    /**
     * Search software according to given name.
     * @param name name ( included version )
     */
    @Override
    public void searchByName( String name ) {

        if( name == null ) {
            System.out.println("Invalid input for searching by name.");
            return;
        }

        Software searchedSoftware = new Software("a","b",0,0.0);
        searchedSoftware.setLabelName(name);

        searchedSoftware = systemStorage.getSoftwareTree().find( searchedSoftware );

        if( searchedSoftware != null ) {
            System.out.println(searchedSoftware);
        } else {
            System.out.println("There is no software with matched given name.");
        }
    }

}
