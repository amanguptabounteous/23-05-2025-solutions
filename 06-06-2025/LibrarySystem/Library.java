package LibrarySystem;

import java.time.LocalDate;
import java.util.ArrayList;

public class Library {
    Repo<Book> bookRepo = new Repo<>();
    Repo<Member> memberRepo = new Repo<>();
    ArrayList<LendingBook> records = new ArrayList<>();

    public void addBook(Book bk){
        bookRepo.add(bk.getBookid(), bk);
    }

    public void removeBook(Book bk){
        bookRepo.remove(bk.getBookid());
    }

    public void addMember(Member mem){
        memberRepo.add(mem.getMemID(), mem);
    }

    public void removeMember(Member mem){
        memberRepo.remove(mem.getMemID());
    }

    public void bookIssue(String bookId, String memId) throws Exception{
        Book bk = bookRepo.get(bookId);
        if(bk==null|| bk.getStatus() == BookStatus.ISSUED){
            throw new BookNotAvailableException("Book is not Available");
        }

        Member mem = memberRepo.get(memId);
        if(mem==null){
            throw new MemberNotFoundException("No such Member");
        }

        for (LendingBook rec : records){
            if(rec.member.getMemID().equals(memId) && rec.returnDate==null
                    && rec.dueDate.isBefore(LocalDate.now())){
                throw new OverdueBookException("This member already has a book overdue");
            }
        }
        bk.setStatus(BookStatus.ISSUED);
        LendingBook newRec = new LendingBook
                (bookId+memId, mem, bk, LocalDate.now(), LocalDate.now().plusDays(20));
    }

    public void returnBook(String bookId, String memberId) {
        for (LendingBook record : records) {
            if (record.book.getBookid().equals(bookId) && record.member.getMemID().equals(memberId) && record.returnDate == null) {
                record.returnDate = LocalDate.now();
                record.book.setStatus(BookStatus.AVAIL);
                break;
            }
        }
    }
}
