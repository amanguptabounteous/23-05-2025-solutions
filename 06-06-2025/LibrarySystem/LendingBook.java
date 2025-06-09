package LibrarySystem;

import java.time.LocalDate;

public class LendingBook {
    String RecordId;
    Book book;
    Member member;
    LocalDate issueDate;
    LocalDate dueDate;
    LocalDate returnDate;

    public LendingBook(String recordId, Member member, Book book, LocalDate issueDate, LocalDate dueDate) {
        RecordId = recordId;
        this.member = member;
        this.book = book;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.returnDate = null;
    }

}
