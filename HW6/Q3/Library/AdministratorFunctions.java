package Library;

/**
 * Library.Administrator
 */
public interface AdministratorFunctions {


    void addBook( Book newBook );
    boolean deleteBook( Book deletedBook );
    Book updateBookInfo( Book updatedBook );

}
