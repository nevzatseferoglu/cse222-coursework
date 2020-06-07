package edu.gtu.SoftwareStoreManager;
import java.util.Scanner;

/**
 * General Store-System class to lunch
 */
public class StoreSystem {

    /**
     * Storage
     */
    SystemStorage storage ;

    /**
     * Example user.
     */
    User exampleUser;

    /**
     * Example administrator.
     */
    Administrator exampleAdministrator;

    /**
     * Input taker.
     */
    Scanner input;

    /**
     * Initialize Store-System with some software.
     */
    public  StoreSystem( SearchTree<Software> givenContainer ) {

        storage = new SystemStorage( givenContainer );
        exampleUser = new User(storage);
        exampleAdministrator = new Administrator( storage );
        input = new Scanner( System.in );


        exampleAdministrator.add( new Software("Adobe Photoshop",
                "6.0",5,20.75) );

        exampleAdministrator.add( new Software("Adobe Photoshop",
                "6.2",4,15.35) );

        exampleAdministrator.add( new Software("Norton",
                "4.5",6,15.60) );

        exampleAdministrator.add( new Software("Norton",
                "5.5",7,20.10) );

        exampleAdministrator.add( new Software("Adobe Flash",
                "3.3",2,13.05) );

        exampleAdministrator.add( new Software("Adobe Flash",
                "3.3",2,13.50) );

    }

    /**
     * Run the overall system.
     */
    public void runTheSystem( ) {

        boolean menuLoop = true;
        while ( menuLoop ) {

            System.out.println("--------------------------------");
            System.out.println("(1) Login as administrator");
            System.out.println("(2) Search software by name");
            System.out.println("(3) List all the software");
            System.out.println("(4) Quit");
            System.out.print("Choice : ");

            String choice = input.nextLine();
            while ( !choice.equals("1") &&
                    !choice.equals("2") &&
                    !choice.equals("3") &&
                    !choice.equals("4")) {

                System.out.println("Invalid input !");
                System.out.print("Choice : ");
                choice = input.nextLine();
            }


            switch ( choice ) {

                case "1":
                    System.out.println("--------------------------------");
                    System.out.print("Enter the password : ");
                    String password = input.nextLine();

                    if( !password.equals( SystemStorage.getGeneralPassword() )) {
                        System.out.println("**Invalid password !");
                    }
                    else {
                        boolean adminMenu = true;
                        while ( adminMenu ) {

                            System.out.println("(1) Add Software");
                            System.out.println("(2) Delete Software");
                            System.out.println("(3) Update book");
                            System.out.println("(4) Quit");
                            System.out.print("Choice : ");

                            String choiceAdmin = input.nextLine();
                            while ( !choiceAdmin.equals("1") &&
                                    !choiceAdmin.equals("2") &&
                                    !choiceAdmin.equals("3") &&
                                    !choiceAdmin.equals("4")) {

                                System.out.println("Invalid input !");
                                System.out.print("Choice : ");
                                choiceAdmin = input.nextLine();
                            }

                            switch ( choiceAdmin ) {

                                case "1":

                                    if( exampleAdministrator.add( softwareAddMenu() ) ){
                                        System.out.println("\n*New software added to store-system\n");
                                    } else {
                                        System.out.println("\n*Equivalent software available in the system.Given software price and quantity\n " +
                                                "updated with newly added software.\n");
                                    }

                                    break;

                                case "2":

                                    if( softwareDeleteMenu() ) {
                                        System.out.println("\n*Software is removed entirely.\n");
                                    } else {
                                        System.out.println("\n*There is no software with given properties.\n");
                                    }

                                    break;

                                case "3":

                                    if( softwareUpdateMenu() == null ) {
                                        System.out.println("\n*There is no software with given properties.\n");
                                    }

                                    break;

                                case "4":
                                    adminMenu = false;
                                    break;

                                default:
                                    assert true : "Something goes wrong :(";
                                    break;
                            }
                        }
                    }

                    break;

                case "2":

                    System.out.print("Enter the name of the software (included version) : ");
                    exampleUser.searchByName( input.nextLine() );

                    break;

                case "3":
                    storage.listSoftware();
                    break;

                case "4":
                    System.out.println("**Quiting...");
                    menuLoop = false;
                    break;

                default:
                    assert true : "Something goes wrong :(";
                    break;
            }


        }

    }

    /**
     * Add menu
     * @return added software.
     */
    private Software softwareAddMenu( ) {

        String name;
        String version;
        int quantity = 0;
        double price = 0;

        System.out.println("");
        System.out.print("Enter software name (not include version) : ");
        name = input.nextLine();

        System.out.print("Enter software version : ");
        version = input.nextLine();

        boolean loop = true;

        while ( loop ) {
            System.out.print("Enter the quantity of the software : ");
            String quantityString  = input.nextLine();

            try {

                quantity = Integer.parseInt( quantityString );
                loop = false;

            } catch (NumberFormatException ne) {
                System.out.println("Invalid input for quantity .");
            }
        }

        boolean loop2 = true;

        while ( loop2 ) {
            System.out.print("Enter the price of the software : ");
            String priceString  = input.nextLine();
            System.out.println("");
            try {

                price = Double.parseDouble( priceString );
                loop2 = false;

            } catch (NumberFormatException ne) {
                System.out.println("Invalid input for price .");
            }
        }


        return new Software( name , version ,quantity , price);

    }

    /**
     * Delete menu
     * @return true if given software remove otherwise return false.
     */
    private boolean softwareDeleteMenu( ) {

        System.out.print("Enter software name (not include version) : ");
        String name = input.nextLine();

        System.out.print("Enter software version : ");
        String version = input.nextLine();

        return exampleAdministrator.delete( new Software( name , version , 0 , 0.0) );
    }

    /**
     * Update menu
     * @return updated software.
     */
    private Software softwareUpdateMenu( ) {

        System.out.println("");
        System.out.print("Enter software name (not include version) : ");
        String name = input.nextLine();

        System.out.print("Enter software version : ");
        String version = input.nextLine();

        return exampleAdministrator.update( new Software( name , version , 0 , 0.0) );
    }

    /**
     * Return sample administrator.
     * @return administrator.
     */
    public Administrator getExampleAdministrator() {
        return exampleAdministrator;
    }

    /**
     * Return sample user.
     * @return user.
     */
    public User getExampleUser() {
        return exampleUser;
    }

}
