package Library;

public class AutomationSystem {

    SystemStorage storage;
    Administrator admin;
    User user;

    public AutomationSystem() {
        storage = new SystemStorage();
        admin = new Administrator(storage);
        user = new User(storage);
    }

    public Administrator getAdmin() {
        return admin;
    }
    public User getUser() {
        return user;
    }

    public SystemStorage getStorage() {
        return storage;
    }

    public void viewAllBooks() {

        System.out.println("======All-Library.Book=======");

        for( Book book : storage.bookList ) {
            System.out.println( book );
        }

        System.out.println("=====================");
    }
}
