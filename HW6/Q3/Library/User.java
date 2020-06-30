package Library;

import java.util.*;

public class User implements UserFunctions{

    private SystemStorage mainSystem;

    User( SystemStorage mainSystem ) {
        this.mainSystem = mainSystem;
    }

    public void setMainSystem(SystemStorage mainSystem) {
        this.mainSystem = mainSystem;
    }

    public SystemStorage getMainSystem() {
        return mainSystem;
    }

    @Override
    public void searchByAuthorName( String authorName ) {

        boolean isBookExist = false;

        if( mainSystem.bookName == null || mainSystem.bookName.isEmpty() ) {
            System.out.println("There is no book written by given author .");
            return;
        }

        for (Map.Entry<String, Map<String, Set<String>>> entryName : mainSystem.bookName.entrySet()) {

            if (entryName.getKey().equals(authorName)) {
                isBookExist = true;
                for (Map.Entry<String, Set<String>> entryTitle : mainSystem.bookName.get(authorName).entrySet()) {
                    System.out.println("Title of the book  : " + entryTitle.getKey());
                }
            }
        }

        if( !isBookExist ) {
            System.out.println("There is no book written by given author .");
        } else {

            String bookName;
            System.out.print("Enter the title : ");

            Scanner scan = new Scanner( System.in );
            bookName = scan.nextLine();

            Set<String> bookSet =  mainSystem.bookName.get(authorName).get(bookName);

            if( bookSet == null ) {
                System.out.println("There is book with given title .");
            }
            else {
                System.out.println("Location of the book : " );

                for ( String entryLocation : bookSet ) {
                    System.out.println(entryLocation);
                }
            }

        }
    }

    @Override
    public void searchByBookTitle( String title ) {

        boolean isTitleExist = false;

        for( Book currentBook : mainSystem.bookList ) {
            if( currentBook.getTitleOfTheBook().equals(title) ) {
                isTitleExist = true;
                System.out.println(currentBook);
            }
        }

        if( !isTitleExist ) {
            System.out.println("Library.Book with given title does not exist.");
        }
    }

}
