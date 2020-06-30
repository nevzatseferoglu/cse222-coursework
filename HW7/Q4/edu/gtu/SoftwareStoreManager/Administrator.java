package edu.gtu.SoftwareStoreManager;
import java.util.Scanner;

/**
 * Administrator class that can manage the store.
 */
public class Administrator implements AdministratorDomain {

    /**
     * General Storage.
     */
    SystemStorage systemStorage;


    /**
     * Constructor
     * @param systemStorage Storage which holds the crucial data which can be manipulated by the administrator.
     */
    public Administrator( SystemStorage systemStorage ) {
        this.systemStorage = systemStorage;
    }


    /**
     * Add specific amount of software to the system.
     * @param givenSoftware Added software
     * @return if software does not exist , it is added to the system and return true ,
     * otherwise software that match with the given software amount is increased.
     */
    @Override
    public boolean add( Software givenSoftware ) {
        Software queriedSoftware = systemStorage.getSoftwareTree().find( givenSoftware );

        if( queriedSoftware == null ) {
            systemStorage.getSoftwareTree().add( givenSoftware );
            systemStorage.getSoftwareList().add( givenSoftware );
            return true;
        } else {
            queriedSoftware.increaseQuantity( givenSoftware.getQuantity() );
            queriedSoftware.setPrice( givenSoftware.getPrice() );
            return false;
        }
    }

    /**
     * Delete the all software information from the system.
     * @param givenSoftware Removed software
     * @return Remove given software from the system and return true , otherwise
     * return false.
     */
    @Override
    public boolean delete( Software givenSoftware ) {

        Software queriedSoftware = systemStorage.getSoftwareTree().find( givenSoftware );

        if (queriedSoftware != null) {
            systemStorage.getSoftwareTree().delete( queriedSoftware );
            systemStorage.getSoftwareList().remove( queriedSoftware );
            return true;
        }

        return false;
    }


    /**
     * Update information of the existent software in the system
     * @param givenSoftware software
     * @return updated software otherwise , return given software as a parameter.
     */
    @Override
    public Software update(Software givenSoftware)  {

        if (givenSoftware == null) {
            return null;
        }

        Software product = systemStorage.getSoftwareTree().find( givenSoftware );

        if ( product != null ) {

            boolean menuLoop = true;
            while (menuLoop) {

                System.out.println("(1) Edit name");
                System.out.println("(2) Edit version code");
                System.out.println("(3) Sell that product ( only 1 element ) ");
                System.out.println("(4) Edit quantity");
                System.out.println("(5) Edit price");
                System.out.println("(6) Quit");

                System.out.print("Choice : ");
                Scanner scan = new Scanner(System.in);
                String choice = scan.nextLine();

                while (!choice.equals("1")
                        && !choice.equals("2")
                        && !choice.equals("3")
                        && !choice.equals("4")
                        && !choice.equals("5")
                        && !choice.equals("6")) {

                    System.out.println("Invalid input.");
                    System.out.print("Choice : ");
                    choice = scan.nextLine();
                }

                switch (choice) {

                    case "1":
                        System.out.print("Enter new name : ");
                        choice = scan.nextLine();
                        product.setName( choice );
                        break;

                    case "2":
                        System.out.print("Enter new version code : ");
                        choice = scan.nextLine();
                        product.setVersion( choice );

                        break;

                    case "3":
                        if( product.getQuantity() > 0 ) {
                            product.decreaseQuantity(1);
                            System.out.println("An item which matches selected product has been sold.");
                        } else {
                            System.out.println("There is no enough item to sold.");
                        }
                        break;

                    case "4":

                        int quantity = 0;

                        boolean loop = true;

                        while ( loop ) {
                            System.out.print("Enter the new quantity of the software : ");
                            String quantityString  = scan.nextLine();

                            try {

                                quantity = Integer.parseInt( quantityString );
                                loop = false;

                            } catch (NumberFormatException ne) {
                                System.out.println("Invalid input for quantity .");
                            }
                        }

                        System.out.println("Quantity has been updated.");
                        product.setQuantity( quantity );

                        break;

                    case "5":

                        double price = 0 ;
                        boolean loop2 = true;

                        while ( loop2 ) {
                            System.out.print("Enter new price as Turkish-Lira: ");
                            String priceString  = scan.nextLine();
                            System.out.println("");
                            try {

                                price = Double.parseDouble( priceString );
                                loop2 = false;

                            } catch (NumberFormatException ne) {
                                System.out.println("Invalid input for price .");
                            }
                        }

                        System.out.println("Price has been updated.");
                        product.setPrice( price );
                        break;

                    case "6":
                        System.out.println("Quiting...");
                        menuLoop = false;
                        break;

                    default:
                        assert true : "Something goes wrong.";

                }
            }

            delete( givenSoftware );
            add( product );

            return product;
        }
        else {
            return givenSoftware;
        }

    }
}
