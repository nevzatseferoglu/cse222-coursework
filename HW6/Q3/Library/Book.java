package Library;

public class Book {

    private SystemStorage mainSystem;

    private String nameOfTheAuthor;
    private String titleOfTheBook;
    private String locationOfTheBook;
    private boolean status;

    private int bookID;
    private int shelfID;
    private int corridorID;

    private void toStringLocation( ) {
        locationOfTheBook = "c" + corridorID +
                "s" + shelfID + "." + bookID;
    }

    public Book(SystemStorage mainSystem,
                String nameOfTheAuthor,
                String titleOfTheBook) {

        this.mainSystem = mainSystem;
        setNameOfTheAuthor(nameOfTheAuthor);
        setTitleOfTheBook(titleOfTheBook);

        mainSystem.generateNextBook(this);

        toStringLocation();
        status = true;
    }

    public Book(SystemStorage mainSystem,
                String nameOfTheAuthor,
                String titleOfTheBook,
                String locationOfTheBook) {

        this.mainSystem = mainSystem;
        setNameOfTheAuthor(nameOfTheAuthor);
        setTitleOfTheBook(titleOfTheBook);
        setLocationOfTheBook(locationOfTheBook);

        status = true;
    }

    public void setLocationOfTheBook(String locationOfTheBook) {
        this.locationOfTheBook = locationOfTheBook;
    }

    public void setLocationOfTheBook( int bookID , int shelfID , int corridorID ) {

        this.bookID = bookID;
        this.shelfID = shelfID;
        this.corridorID = corridorID;

        toStringLocation();

    }

    public void setNameOfTheAuthor(String nameOfTheAuthor) {
        this.nameOfTheAuthor = nameOfTheAuthor;
    }

    public void setTitleOfTheBook(String titleOfTheBook) {
        this.titleOfTheBook = titleOfTheBook;
    }

    public String getLocationOfTheBook() {
        return locationOfTheBook;
    }

    public String getNameOfTheAuthor() {
        return nameOfTheAuthor;
    }

    public String getTitleOfTheBook() {
        return titleOfTheBook;
    }

    public int getBookID() {
        return bookID;
    }

    public int getCorridorID() {
        return corridorID;
    }

    public int getShelfID() {
        return shelfID;
    }

    public SystemStorage getMainSystem() {
        return mainSystem;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public void setCorridorID(int corridorID) {
        this.corridorID = corridorID;
    }

    public void setMainSystem(SystemStorage mainSystem) {
        this.mainSystem = mainSystem;
    }

    public void setShelfID(int shelfID) {
        this.shelfID = shelfID;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus( ) {
        return status;
    }

    @Override
    public boolean equals(Object obj) {

        if( obj == this ) {
            return true;
        }

        if( obj == null ) {
            return false;
        }

        if( !(obj instanceof Book) ) {
            return false;
        }

        return ((Book)obj).getLocationOfTheBook().equals(this.getLocationOfTheBook()) &&
                ((Book)obj).getNameOfTheAuthor().equals(this.getNameOfTheAuthor()) &&
                ((Book)obj).getTitleOfTheBook().equals(this.getTitleOfTheBook());
    }

    @Override
    public int hashCode() {
        return getNameOfTheAuthor().hashCode() +
                37*getTitleOfTheBook().hashCode() +
                97*getLocationOfTheBook().hashCode();
    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();

        str.append("----------------------");
        str.append("\nName of the author : ").append(getNameOfTheAuthor()).append("\n").append("Title of the book : ").append(getTitleOfTheBook())
                .append("\n").append("Location of the book : ").append(getLocationOfTheBook()).append("\n");

        if( getStatus() ) {
            str.append("Current Status : Available").append("\n");
        } else {
            str.append("Current Status : Rented by someone").append("\n");
        }

        return str.toString();
    }
}
