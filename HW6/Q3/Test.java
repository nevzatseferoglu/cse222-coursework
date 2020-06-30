import Library.AutomationSystem;
import Library.Book;

import java.util.Scanner;

public class Test {

    /*************  Admin Password : "gtu"   ***************/


    private static Book bookPropertyMenu(boolean isAdd , boolean isDelete, AutomationSystem sys ) {

        Book returnedBook;

        Scanner input = new Scanner(System.in);

        String titleOfTheBook;
        String authorNameOfTheBook;
        String locationOfTheBook;

        if( isAdd ) {

            System.out.println("---------------");
            System.out.println("*Location automatically assigned.");
            System.out.println("*Status automatically assigned.");
            System.out.println();

            System.out.print("Enter the author name : ");
            authorNameOfTheBook = input.nextLine();

            System.out.print("Enter the title :  ");
            titleOfTheBook = input.nextLine();

            returnedBook = new Book( sys.getStorage() , authorNameOfTheBook  ,titleOfTheBook );
        }
        else if( isDelete ){

            System.out.print("Enter the author name : ");
            authorNameOfTheBook = input.nextLine();

            System.out.print("Enter the title :  ");
            titleOfTheBook = input.nextLine();

            System.out.print("Enter the location :  ");
            locationOfTheBook = input.nextLine();

            returnedBook = new Book( sys.getStorage() , authorNameOfTheBook  ,titleOfTheBook , locationOfTheBook );
        }
        else {
            System.out.println("---------------");
            System.out.println("*Status automatically assigned.");
            System.out.println();

            System.out.print("Enter the author name : ");
            authorNameOfTheBook = input.nextLine();

            System.out.print("Enter the title :  ");
            titleOfTheBook = input.nextLine();

            System.out.print("Enter the location :  ");
            locationOfTheBook = input.nextLine();

            returnedBook = new Book( sys.getStorage() , authorNameOfTheBook  ,titleOfTheBook , locationOfTheBook );
        }

        return  returnedBook;
    }

    public static void main( String[] argv ) {

        AutomationSystem gtuLib = new AutomationSystem();
        Scanner input = new Scanner(System.in);

        boolean menuLoop = true;
        while ( menuLoop ) {

            System.out.println("--------------------------------");
            System.out.println("(1) Login as administrator");
            System.out.println("(2) Search by author name");
            System.out.println("(3) Search by title of the book");
            System.out.println("(4) List all book in library");
            System.out.println("(5) Quit");
            System.out.print("Choice : ");

            String choice = input.nextLine();
            while ( !choice.equals("1") &&
                    !choice.equals("2") &&
                    !choice.equals("3") &&
                    !choice.equals("4") &&
                    !choice.equals("5")) {

                System.out.println("Invalid input !");
                System.out.print("Choice : ");
                choice = input.nextLine();
            }


            switch ( choice ) {

                case "1":
                    System.out.println("--------------------------------");
                    System.out.print("Enter the password : ");
                    String password = input.nextLine();

                    if( !password.equals( gtuLib.getStorage().getUniquePassword() )) {
                        System.out.println("**Invalid password !");
                    }
                    else {
                        boolean adminMenu = true;
                        while ( adminMenu ) {
                            Book executedBook;

                            System.out.println("(1) Add book");
                            System.out.println("(2) Delete book");
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
                                    executedBook = bookPropertyMenu( true , false , gtuLib );
                                    gtuLib.getAdmin().addBook(executedBook);
                                    break;

                                case "2":

                                    executedBook = bookPropertyMenu( false , true , gtuLib );

                                    if( gtuLib.getAdmin().deleteBook(executedBook) ) {
                                        System.out.println("**Library.Book has been removed.");
                                    } else {
                                        System.out.println("**There is no book to delete with matched given property.");
                                    }
                                    System.out.println();

                                    break;

                                case "3":

                                    executedBook = bookPropertyMenu( false , true , gtuLib );
                                    gtuLib.getAdmin().updateBookInfo(executedBook);
                                    System.out.println();

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
                    String authorOfTheBook;

                    System.out.print("Enter the name of the author : ");
                    authorOfTheBook = input.nextLine();

                    gtuLib.getUser().searchByAuthorName( authorOfTheBook );

                break;

                case "3":
                    String titleOfTheBook;

                    System.out.print("Enter the title of the book : ");
                    titleOfTheBook = input.nextLine();

                    gtuLib.getUser().searchByBookTitle( titleOfTheBook );

                break;

                case "4":
                    gtuLib.viewAllBooks();
                break;

                case "5":
                    System.out.println("**Quiting...");
                    menuLoop = false;
                break;

                default:
                    assert true : "Something goes wrong :(";
                break;
            }


        }

    }
}
