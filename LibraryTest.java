import java.util.List;

public class LibraryTest {
    


    public static void main(String[] args) {
        LibraryItemFactory lms = new LibraryItemFactory();
        

        Book book1 = new Book("The Catcher in the Rye", "J.D. Salinger", "12345");
        Book book2 = new Book("To Kill a MockingBird", "Harper Lee", "54321");
        Book book3 = new Book("Hunger Games", "Suzanne Collins", "12534");


        lms.addBook(book1);
        lms.addBook(book2);
        lms.addBook(book3);


        System.out.println("Book 1: " + lms.getBook("12345"));
        System.out.println("Book 2: " + lms.getBook("54321"));
        System.out.println("Book 3: " + lms.getBook("12534"));

        lms.removeBook("12345");
        System.out.println("Book 1 removed: " + lms.getBook("12345"));

        List<Book> searchResults = lms.searchByTitle("Mockingbird");
        System.out.println("Search results: " + searchResults);
        

        LibraryManagement user1 = new LibraryManagement("user1");
        lms.addUser(user1);
        System.out.println("User 1 added: " + lms.getUser("user1"));

        lms.checkOutBook("user1", "54321");
        System.out.println("Book 2 checked out: " + lms.getBook("54321"));
        System.out.println("User 1 loaned books: " + user1.getLoanedBooks());


        lms.returnBook("user1", "54321");
        System.out.println("Book 2 returned: " + lms.getBook("54321"));
        System.out.println("User 1 loaned books: " + user1.getLoanedBooks());



        lms.checkOutBook("user1", "12345");
        System.out.println("Book 1 checked out: " + lms.getBook("12345"));
        System.out.println("User 1 loaned books: " + user1.getLoanedBooks());


        lms.returnBook("user1", "12345");
        System.out.println("Book 1 returned: " + lms.getBook("12345"));
        System.out.println("User 1 loaned books: " + user1.getLoanedBooks());


        lms.checkOutBook("user1", "12534");
        System.out.println("Book 3 checked out: " + lms.getBook("12534"));
        System.out.println("User 1 loaned books: " + user1.getLoanedBooks());


        lms.returnBook("user1", "12534");
        System.out.println("Book 3 returned: " + lms.getBook("12534"));
        System.out.println("User 1 loaned books: " + user1.getLoanedBooks());


    }
}
