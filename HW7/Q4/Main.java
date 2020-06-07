import edu.gtu.SoftwareStoreManager.StoreSystem;


/* General password : "gtu" */
public class Main {

    public static void main( String[] argv ) {
        StoreSystem gtuStore = new StoreSystem( new BinarySearchTree<>() );
        gtuStore.runTheSystem();
    }
    
}
