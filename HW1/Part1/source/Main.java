import CargoCompany.*;
import java.util.Scanner;

public class Main {

    public static void main( String... argv ) {

        try
        {
            System.out.print("Enter the Company Name : ");
            Scanner inputFromUser = new Scanner(System.in);
            Company mainCompany = new Company( inputFromUser.nextLine() );

            System.out.println("Company Headquarter Branch created by default !");
            System.out.println("Attention --> Headquarter ID = 1 by default !");
            System.out.println("");
            System.out.println("All Ids are unique by itself , there cannot be same ids for same type !");

            /*--------Branch-Assignation------------*/
            Branch Headquarter = new Branch("1" , "Headquarter" , mainCompany);
            mainCompany.addBranch(Headquarter);
            /*--------Branch-Assignation-End------------*/

            /*--------Admin-Assignation------------*/
            System.out.println("Adding Admin to Company.. ");

            System.out.print("Type Admin Name : ");
            String adminName = inputFromUser.nextLine();

            System.out.print("Type Admin Surname : ");
            String adminSurname = inputFromUser.nextLine();

            System.out.print("Type Admin ID : ");
            String adminID = inputFromUser.nextLine();

            mainCompany.addEmployee(new Employee(mainCompany , Headquarter ,adminID , adminName ,
                    adminSurname ,EmployeePositions.ADMIN));
            /*--------Admin-Assignation-End------------*/


            boolean quitProgram = false;
            while ( !quitProgram ) {

                System.out.println( " --------------------------------------------- ");
                System.out.println( " (1) Login with ID ");
                System.out.println( " (2) Customer Interface ");
                System.out.println( " (3) Quit ");
                System.out.println( " --------------------------------------------- ");

                System.out.print("Chosen : ");
                switch ( inputFromUser.nextInt() )
                {
                    case 1:

                        System.out.print("Enter ID : ");

                        String tempID = inputFromUser.next();

                        if( !mainCompany.searchEmployeeWithID( tempID ) )
                            System.out.println("There is no match-up with this ID.");
                        else
                        {
                            switch (mainCompany.returnEmployeeWithID(tempID).getCurrentPosition() )
                            {
                                case ADMIN:

                                    System.out.println("Report : Logged in as Admin ");
                                    boolean quitProgramAdmin = false;

                                    while( !quitProgramAdmin )
                                    {
                                        System.out.println( " --------------------------------------------- ");
                                        System.out.println( " (1) List    all current branches ");
                                        System.out.println( " (2) List    all current employees ");
                                        System.out.println( " (3) Add     branch");
                                        System.out.println( " (4) Remove  branch with ID");
                                        System.out.println( " (5) Add     new employee");
                                        System.out.println( " (6) Remove  existing employee with ID");
                                        System.out.println( " (7) Change  branch of employee with IDs");
                                        System.out.println( " (8) Exit");
                                        System.out.println( " --------------------------------------------- ");

                                        System.out.print("Chosen : ");
                                        switch ( inputFromUser.nextInt() )
                                        {
                                            case 1:
                                                mainCompany.returnEmployeeWithID(tempID).listBranches();
                                                break;

                                            case 2:
                                                mainCompany.returnEmployeeWithID(tempID).listEmployee();
                                                break;

                                            case 3:

                                                System.out.print("Enter branch ID : ");
                                                String newBranchIDAdd = inputFromUser.next();

                                                if( mainCompany.searchBranchWithID( newBranchIDAdd ) )
                                                    System.out.println("There is one another branch with this unique id !");
                                                else {
                                                    System.out.print("Enter branch Name : ");
                                                    String newBranchNameAdd = inputFromUser.next();

                                                    mainCompany.returnEmployeeWithID(tempID).addBranch(
                                                            new Branch(newBranchIDAdd , newBranchNameAdd , mainCompany));
                                                }

                                                break;

                                            case 4:

                                                System.out.print("Enter branch ID : ");
                                                String newBranchIDRemove = inputFromUser.next();
                                                if ( mainCompany.searchBranchWithID(newBranchIDRemove) )
                                                    mainCompany.returnEmployeeWithID(tempID).removeBranch(newBranchIDRemove);
                                                else
                                                    System.out.println("There is no branch with this id !");

                                                break;

                                            case 5:

                                                System.out.print("Enter employee forename : ");
                                                String newEmployeeForename = inputFromUser.next();

                                                System.out.print("Enter employee surname : ");
                                                String newEmployeeSurname = inputFromUser.next();

                                                System.out.print("Enter employee ID : ");
                                                String newEmployeeID = inputFromUser.next();

                                                if( mainCompany.searchEmployeeWithID(newEmployeeID) )
                                                    System.out.println("There is one another employee with this id !");
                                                else {
                                                    Branch newEmployeeBranch = null;

                                                    System.out.print("Enter employee branch ID : ");
                                                    String newEmployeeBranchID = inputFromUser.next();
                                                    if( !mainCompany.searchBranchWithID(newEmployeeBranchID) )
                                                        System.out.println("There is no branch with this id !");
                                                    else {
                                                        newEmployeeBranch =  mainCompany.returnBranchWithID(newEmployeeBranchID);


                                                        EmployeePositions newEmployeePosition = null;

                                                        boolean employeePositionControl = false;
                                                        while( !employeePositionControl )
                                                        {
                                                            System.out.println( "Chose employee position : ");
                                                            System.out.println( "(1) Make Admin ");
                                                            System.out.println( "(2) Make Branch Employee ");
                                                            System.out.println( "(3) Make Transportation Employee");
                                                            System.out.print("Chosen : ");

                                                            switch ( inputFromUser.nextInt() )
                                                            {
                                                                case 1:
                                                                    newEmployeePosition = EmployeePositions.ADMIN;
                                                                    employeePositionControl = true;
                                                                    break;

                                                                case 2:
                                                                    newEmployeePosition = EmployeePositions.BRANCH_EMPLOYEE;
                                                                    employeePositionControl = true;
                                                                    break;

                                                                case 3:
                                                                    newEmployeePosition = EmployeePositions.TRANSPORTATION_PERSONNEL;
                                                                    employeePositionControl = true;
                                                                    break;

                                                                default:
                                                                    System.out.println(" Invalid Position Input ! ");
                                                                    break;
                                                            }
                                                        }

                                                        mainCompany.returnEmployeeWithID(tempID).addEmployee(
                                                                new Employee( mainCompany , newEmployeeBranch , newEmployeeID,
                                                                        newEmployeeForename,newEmployeeSurname,newEmployeePosition) );
                                                    }
                                                }

                                                break;

                                            case 6:
                                                System.out.print("Enter employee ID : ");
                                                String newEmployeeIDRemove = inputFromUser.next();

                                                if( !mainCompany.searchBranchWithID(newEmployeeIDRemove) )
                                                    System.out.println("There is no employee with this id !");
                                                else {
                                                    if( tempID.equals(newEmployeeIDRemove))
                                                        quitProgramAdmin = true;

                                                    mainCompany.returnEmployeeWithID(tempID).removeEmployee(newEmployeeIDRemove);
                                                }


                                                break;

                                            case 7:
                                                System.out.print("Enter employee ID : ");
                                                String employeeIdForNewBranch = inputFromUser.next();
                                                if( !mainCompany.searchEmployeeWithID(employeeIdForNewBranch) )
                                                    System.out.println("There is no employee with this id !");
                                                else {
                                                    System.out.print("Enter new branch ID : ");
                                                    String branchID = inputFromUser.next();
                                                    if( !mainCompany.searchBranchWithID(branchID) )
                                                        System.out.println("There is no branch with this id !");
                                                    else
                                                        mainCompany.returnEmployeeWithID(tempID).changeBranchOfEmployee(employeeIdForNewBranch,branchID);
                                                }


                                                break;

                                            case 8:
                                                quitProgramAdmin = true;
                                                break;

                                            default:
                                                System.out.println("Invalid choice !");
                                                break;
                                        }

                                    }

                                    break;

                                case BRANCH_EMPLOYEE:
                                    System.out.println("Report : Logged in as Branch Employee ");
                                    boolean quitProgramBranchEmployee = false;

                                    while( !quitProgramBranchEmployee )
                                    {
                                        System.out.println( " --------------------------------------------- ");
                                        System.out.println( " (1) List  current branch shipments");
                                        System.out.println( " (2) Search shipment with tracking-ID in entire company");
                                        System.out.println( " (3) Add       customer");
                                        System.out.println( " (4) Remove    customer");
                                        System.out.println( " (5) Change    status of shipment");
                                        System.out.println( " (6) Edit      other shipment info");
                                        System.out.println( " (7) Exit");
                                        System.out.println( " --------------------------------------------- ");

                                        System.out.print("Chosen : ");
                                        switch ( inputFromUser.nextInt() )
                                        {
                                            case 1:
                                                mainCompany.returnEmployeeWithID(tempID).listCurrentBranchShipments();
                                                break;

                                            case 2:
                                                System.out.print("Enter the tracking-number : ");
                                                String newShipmentGetInfo = inputFromUser.next();

                                                if( !mainCompany.searchShipmentWithTrackingNumber(newShipmentGetInfo) )
                                                    System.out.println("There is no shipment with this tracking-number !");
                                                else
                                                    mainCompany.returnEmployeeWithID(tempID).shipmentInfo(newShipmentGetInfo);

                                                break;

                                            case 3:
                                                System.out.print("Customer's Shipment");
                                                System.out.println("");

                                                System.out.print("Enter the  description : ");
                                                String newShipmentDescription = inputFromUser.next();

                                                System.out.print("Enter the  tracking-number : ");
                                                String newShipmentTrackingNumber = inputFromUser.next();

                                                if( mainCompany.searchShipmentWithTrackingNumber(newShipmentTrackingNumber) )
                                                    System.out.println("There is another shipment with this tracking-number !");
                                                else {

                                                    System.out.print("Enter the  branch-ID : ");
                                                    String newShipmentBranchID = inputFromUser.next();

                                                    if( !mainCompany.searchBranchWithID(newShipmentBranchID) )
                                                        System.out.println("There is no branch with this id !");
                                                    else {

                                                        System.out.print("Enter Customer's forename : ");
                                                        String newShipmentCustomerForename = inputFromUser.next();

                                                        System.out.print("Enter Customer's surname : ");
                                                        String newShipmentCustomerSurname = inputFromUser.next();

                                                        System.out.print("Enter Receiver's forename : ");
                                                        String newShipmentReceiverForename = inputFromUser.next();

                                                        System.out.print("Enter Receiver's surname : ");
                                                        String newShipmentReceiverSurname = inputFromUser.next();

                                                        mainCompany.returnEmployeeWithID(tempID).addCustomer(
                                                                new Shipment(newShipmentDescription,newShipmentTrackingNumber,
                                                                        mainCompany.returnBranchWithID(newShipmentBranchID),
                                                                        new Customer(newShipmentCustomerForename , newShipmentCustomerSurname),
                                                                        new Person( newShipmentReceiverForename , newShipmentReceiverSurname)) );
                                                    }
                                                }

                                                break;

                                            case 4:
                                                System.out.print("Enter the shipment's tracking-number : ");
                                                String newShipmentID = inputFromUser.next();

                                                if( !mainCompany.searchShipmentWithTrackingNumber(newShipmentID) )
                                                    System.out.println("There is no customer with this tracking-number !");
                                                else
                                                    mainCompany.returnEmployeeWithID(tempID).removeCustomer(newShipmentID);

                                                break;

                                            case 5:
                                                boolean quitProgramShipmentStatusEdit = false;

                                                System.out.print("Enter the shipment's tracking-number : ");
                                                String newShipmentID4 = inputFromUser.next();

                                                if( !mainCompany.searchShipmentWithTrackingNumber(newShipmentID4) )
                                                    System.out.println("There is no shipment with this tracking-number !");
                                                else {
                                                    while( !quitProgramShipmentStatusEdit )
                                                    {
                                                        System.out.println( " --------------------------------------------- ");
                                                        System.out.println( " (1) Make In-Branch ");
                                                        System.out.println( " (2) Make In-Transit ");
                                                        System.out.println( " (3) Exit");
                                                        System.out.println( " --------------------------------------------- ");

                                                        System.out.print("Chosen : ");
                                                        switch ( inputFromUser.nextInt() )
                                                        {
                                                            case 1:
                                                                mainCompany.returnShipmentWithTrackingNumber(newShipmentID4).setCurrentStatus( ShipmentStatus.IN_BRANCH );
                                                                break;

                                                            case 2:
                                                                mainCompany.returnShipmentWithTrackingNumber(newShipmentID4).setCurrentStatus( ShipmentStatus.IN_TRANSIT );
                                                                break;

                                                            case 3:
                                                                quitProgramShipmentStatusEdit = true;
                                                                break;
                                                            default:
                                                                System.out.println("Invalid Choice !");
                                                        }
                                                    }
                                                }

                                                break;

                                            case 6:
                                                boolean quitProgramShipmentEdit = false;

                                                System.out.print("Enter the shipment's tracking-number : ");
                                                String newShipmentID3 = inputFromUser.next();

                                                if( !mainCompany.searchShipmentWithTrackingNumber(newShipmentID3) ) {
                                                    System.out.println("There is no shipment with this tracking-number !");
                                                }
                                                else
                                                {
                                                    while( !quitProgramShipmentEdit )
                                                    {
                                                        System.out.println( " --------------------------------------------- ");
                                                        System.out.println( " (1) Change Description ");
                                                        System.out.println( " (2) Change Branch ");
                                                        System.out.println( " (3) Change Tracking Number ");
                                                        System.out.println( " (4) Exit");
                                                        System.out.println( " --------------------------------------------- ");

                                                        System.out.print("Chosen : ");
                                                        switch ( inputFromUser.nextInt() )
                                                        {
                                                            case 1:
                                                                System.out.print("Enter new description : ");
                                                                mainCompany.returnShipmentWithTrackingNumber(newShipmentID3).setDescription( inputFromUser.next() );

                                                                break;

                                                            case 2:
                                                                System.out.print("Enter new branch-ID : ");
                                                                mainCompany.returnShipmentWithTrackingNumber(newShipmentID3)
                                                                        .setCurrentBranch( mainCompany.returnBranchWithID(inputFromUser.next()) );                                                            break;

                                                            case 3:
                                                                System.out.print("Enter new tracking-number : ");
                                                                mainCompany.returnShipmentWithTrackingNumber(newShipmentID3).setTrackingNumber(inputFromUser.next());
                                                                break;

                                                            case 4:
                                                                quitProgramShipmentEdit = true;
                                                                break;
                                                        }
                                                    }
                                                }

                                                break;

                                            case 7:
                                                quitProgramBranchEmployee = true;
                                                break;

                                            default:
                                                System.out.println("Invalid choice !");
                                                break;
                                        }

                                    }
                                    break;

                                case TRANSPORTATION_PERSONNEL:
                                    System.out.println("Report : Logged in as Transportation Personnel ");
                                    boolean quitProgramTransportationEmployee = false;

                                    while( !quitProgramTransportationEmployee ) {

                                        System.out.println(" --------------------------------------------- ");
                                        System.out.println(" (1) Make shipment's status delivered");
                                        System.out.println(" (2) List all shipments which is in-transit ");
                                        System.out.println(" (3) Exit");
                                        System.out.println(" --------------------------------------------- ");

                                        System.out.print("Chosen : ");
                                        switch (inputFromUser.nextInt()) {

                                            case 1:
                                                System.out.print("Enter the shipment's tracking-number : ");
                                                String transportationShipmentID = inputFromUser.next();

                                                if( !mainCompany.searchShipmentWithTrackingNumber(transportationShipmentID) ) {
                                                    System.out.println("There is no shipment with this tracking-number !");
                                                }
                                                else if( mainCompany.returnShipmentWithTrackingNumber(transportationShipmentID).getCurrentStatus()!= ShipmentStatus.IN_TRANSIT)
                                                    System.out.println("This shipment is not in-transit status !");
                                                else {
                                                    mainCompany.returnShipmentWithTrackingNumber(transportationShipmentID).setCurrentStatus( ShipmentStatus.DELIVERED );
                                                    System.out.println("Shipment is delivered !");
                                                }
                                                break;

                                            case 2:
                                                mainCompany.returnEmployeeWithID(tempID).listShipmentWhichIsInTransit();
                                                break;

                                            case 3:
                                                quitProgramTransportationEmployee = true;
                                                break;

                                            default:
                                                break;
                                        }
                                    }

                                    break;

                                default:
                                    System.out.println("Invalid Position !");
                                    break;
                            }
                        }

                        break;

                    case 2:

                        System.out.printf("Welcome to the %s shipment-informing system %n",mainCompany.getCompanyName());
                        System.out.println("-------------------------------------------");

                        System.out.print("Please Enter Tracking-Number : ");
                        String tempTrackingNumber = inputFromUser.next();

                        if(mainCompany.searchShipmentWithTrackingNumber(tempTrackingNumber))
                            mainCompany.shipmentInfoForCustomer(tempTrackingNumber);
                        else
                            System.out.println("There is no shipment with this tracking-number .");

                        break;

                    case 3:
                        System.out.println("Exiting ...");
                        quitProgram = true;
                        break;

                    default:
                        System.out.println("Invalid Choice !");
                        break;
                }
            }

        }
        catch ( Exception ExceptionPacket ) {
            System.out.println( ExceptionPacket.getMessage() );
        }
    }
}