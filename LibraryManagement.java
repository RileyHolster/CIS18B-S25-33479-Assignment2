import java.util.ArrayList;
import java.util.List;

public class LibraryManagement {
    


    private String username;

    private List<Book> loanedBooks;

    public LibraryManagement(String username) {
        this.username = username;
        this.loanedBooks = new ArrayList<>();
    }

    public String getUsername() {return username; }

    public void setUsername(String username) { this.username = username;}

    public List<Book> getLoanedBooks() { return loanedBooks; }

    public void addBookToLoans(Book book) {
        loanedBooks.add(book);
    }

    public void removeBookFromLoans(String ISBN) { loanedBooks.removeIf(book -> book.getISBN().equals(ISBN)); }


    public Book getBookFromLoans(String ISBN) {
        for (Book book : loanedBooks) {
            if (book.getISBN().equals(ISBN)) {
                return book;
            }
        }
        return null;
    }

    


}
