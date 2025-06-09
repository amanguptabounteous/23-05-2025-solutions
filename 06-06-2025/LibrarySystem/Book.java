package LibrarySystem;

public class Book {
    private String bookid;
    private String title;
    private String Author;
    private BookStatus status;

    public Book(String bookid, String title, String author) {
        this.bookid = bookid;
        this.title = title;
        Author = author;
        this.status = BookStatus.AVAIL;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }
}
