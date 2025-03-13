import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryItemFactory {
    


    private Map<String, Book> library;

    private Map<String, LibraryManagement> users;


    public LibraryItemFactory() {
        library = new HashMap<>();
        users = new HashMap<>();
    }


    public void addBook(Book book) {
        library.put(book.getISBN(), book);
    }


    public void removeBook(String ISBN) {
        library.remove(ISBN);
    }

    public Book getBook(String ISBN) {
        return library.get(ISBN);
    }


    public List<Book> searchByTitle(String title) {
        List<Book> searchResults = new ArrayList<>();
        for (Book book : library.values()) {
            if(book.getTitle().contains(title)) {
                searchResults.add(book);
            }
        }
        return searchResults;
    }


    public List<Book> searchByAuthor(String author) {
        List<Book> searchResults = new ArrayList<>();
        for (Book book : library.values()) {
            if(book.getAuthor().contains(author)) {
                searchResults.add(book);
            }
        }
        return searchResults;
    }

    public void addUser(LibraryManagement user) { users.put(user.getUsername(), user); }

    public void removeUser(String username) { users.remove(username); }


    public LibraryManagement getUser(String username) { return users.get(username); }

    public void checkOutBook(String username, String ISBN) {
        LibraryManagement user = users.get(username);
        if (user.getLoanedBooks().size() >= 5) {
            System.out.println("User has reached the maximum number of loaned books!");
        } else {
            Book book = library.get(ISBN);
            user.addBookToLoans(book);
            library.remove(ISBN);
        }
    }


    public void returnBook(String username, String ISBN) {
        LibraryManagement user = users.get(username);
        Book book = user.getBookFromLoans(ISBN);
        library.put(ISBN, book);
        user.getBookFromLoans(ISBN);
    }

    

}
