package Library;

import java.util.*;

public class SystemStorage {

     String uniquePassword = "gtu";

    static final int SHELF_PER_CORRIDOR = 3;
    static final int BOOK_PER_SHELF = 10;

    int currentCorridorId;
    int currentShelfId;
    int currentBookId;

    Set<String> bookLocation = null;
    Map< String , Set<String> > bookTitle = null;
    Map< String , Map< String , Set<String> >> bookName = null;

    LinkedList<Book> bookList = new LinkedList<>();

    public SystemStorage() {

        currentCorridorId = 1;
        currentShelfId = 1;
        currentBookId = 0;

    }

    void generateNextBook( Book newBook ) {

        if( currentBookId == BOOK_PER_SHELF ) {
            if( currentShelfId == SHELF_PER_CORRIDOR ) {
                ++currentCorridorId;
                currentShelfId = 1;
            } else {
                ++currentShelfId;
            }
            currentBookId = 1;
        } else {
            ++currentBookId;
        }
        newBook.setLocationOfTheBook(currentBookId ,currentShelfId , currentCorridorId);
    }

    public String getUniquePassword() {
        return uniquePassword;
    }
}
