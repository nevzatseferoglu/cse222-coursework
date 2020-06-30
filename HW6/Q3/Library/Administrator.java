package Library;

import java.util.*;

public class Administrator implements AdministratorFunctions {

    SystemStorage mainSystem;

    Administrator( SystemStorage mainSystem) {
        this.mainSystem = mainSystem;
    }


    @Override
    public void addBook(Book newBook) {

        mainSystem.bookList.add(newBook);

        if (mainSystem.bookName == null || mainSystem.bookName.isEmpty()) {

            mainSystem.bookLocation = new HashSet<>();
            mainSystem.bookLocation.add(newBook.getLocationOfTheBook());

            mainSystem.bookTitle = new HashMap<>();
            mainSystem.bookTitle.put(newBook.getTitleOfTheBook(), mainSystem.bookLocation);

            mainSystem.bookName = new HashMap<String, Map<String, Set<String>>>();
            mainSystem.bookName.put(newBook.getNameOfTheAuthor(), mainSystem.bookTitle);
        } else {
            if (mainSystem.bookName.containsKey(newBook.getNameOfTheAuthor())) {
                if (mainSystem.bookName.get(newBook.getNameOfTheAuthor()).containsKey(newBook.getTitleOfTheBook())) {
                    mainSystem.bookName.get(newBook.getNameOfTheAuthor()).get(newBook.getTitleOfTheBook()).add(newBook.getLocationOfTheBook());
                } else {
                    Set<String> newLocation = new HashSet<>();
                    newLocation.add(newBook.getLocationOfTheBook());

                    mainSystem.bookName.get(newBook.getNameOfTheAuthor()).put(newBook.getTitleOfTheBook(), newLocation);
                }
            } else {

                Set<String> newLocation = new HashSet<>();
                newLocation.add(newBook.getLocationOfTheBook());

                Map<String, Set<String>> newTitle = new HashMap<>();
                newTitle.put(newBook.getTitleOfTheBook(), newLocation);

                mainSystem.bookName.put(newBook.getNameOfTheAuthor(), newTitle);
            }
        }
    }

    @Override
    public boolean deleteBook(Book deletedBook) {

        if (mainSystem.bookName == null || mainSystem.bookName.isEmpty() || deletedBook == null) {
            return false;
        } else if (mainSystem.bookName.containsKey(deletedBook.getNameOfTheAuthor())) {

            if (mainSystem.bookName.get(deletedBook.getNameOfTheAuthor()).containsKey(deletedBook.getTitleOfTheBook())) {
                if (mainSystem.bookName.get(deletedBook.getNameOfTheAuthor()).get(deletedBook.getTitleOfTheBook()).size() == 1) {
                    mainSystem.bookName.get(deletedBook.getNameOfTheAuthor()).remove(deletedBook.getTitleOfTheBook());
                } else {
                    mainSystem.bookName.get(deletedBook.getNameOfTheAuthor()).get(deletedBook.getTitleOfTheBook()).remove(deletedBook.getLocationOfTheBook());
                }
                if (!mainSystem.bookName.containsKey(deletedBook.getNameOfTheAuthor())) {
                    mainSystem.bookName.remove(deletedBook.getNameOfTheAuthor());
                }

                mainSystem.bookList.remove(deletedBook);
                return true;

            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public Book updateBookInfo(Book updatedBook) {

        if (updatedBook == null) {
            return null;
        }

        boolean isLocationMatched = true;

        for (int i = 0 ; i < mainSystem.bookList.size() && isLocationMatched ; ++i) {
            if (mainSystem.bookList.get(i).equals(updatedBook)) {
                isLocationMatched = false;
            }
        }

        if (!isLocationMatched) {

            String authorNameOfTheBook = updatedBook.getNameOfTheAuthor();
            String titleOfTheBook = updatedBook.getTitleOfTheBook();
            String locationOfTheBook = updatedBook.getLocationOfTheBook();
            boolean statusOfTheBook = updatedBook.getStatus();

            boolean menuLoop = true;
            while (menuLoop) {

                System.out.println("(1) Edit author name of the book.");
                System.out.println("(2) Edit title of the book.");
                System.out.println("(3) Edit location of the book.");
                System.out.println("(4) Edit status of the book.");
                System.out.println("(5) Quit");

                System.out.print("Choice : ");
                Scanner scan = new Scanner(System.in);
                String choice = scan.nextLine();

                while (!choice.equals("1")
                        && !choice.equals("2")
                        && !choice.equals("3")
                        && !choice.equals("4")
                        && !choice.equals("5")) {

                    System.out.println("Invalid input.");
                    System.out.print("Choice : ");
                    choice = scan.nextLine();
                }

                switch (choice) {

                    case "1":
                        System.out.print("Enter new author name : ");
                        choice = scan.nextLine();
                        authorNameOfTheBook = choice;
                        break;

                    case "2":
                        System.out.print("Enter new book title : ");
                        choice = scan.nextLine();
                        titleOfTheBook = choice;

                        break;

                    case "3":
                        System.out.print("Enter the new location : ");
                        choice = scan.nextLine();
                        locationOfTheBook = choice;
                        break;

                    case "4":

                        if( statusOfTheBook ) {
                            System.out.println("Status changed from available" +
                                    " to " + "rented !");
                        } else {
                            System.out.println("Status changed from rented" +
                                    " to " + "available !");
                        }
                        statusOfTheBook = !statusOfTheBook;
                        break;

                    case "5":
                        System.out.println("Quiting...");
                        menuLoop = false;
                        break;

                    default:
                        assert true : "Something goes wrong.";

                }
            }

            deleteBook(updatedBook);
            mainSystem.bookList.remove(updatedBook);

            Book likeBook = new Book(mainSystem, authorNameOfTheBook, titleOfTheBook, locationOfTheBook);
            likeBook.setStatus(statusOfTheBook);

            addBook(likeBook);

            return likeBook;
        }
        else {
            System.out.println("There is no book with given property.");
            return updatedBook;
        }
    }
}
