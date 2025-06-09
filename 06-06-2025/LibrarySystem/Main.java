package LibrarySystem;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Book book1 = new Book("B1", "The Hobbit", "J.R.R. Tolkien");
        Book book2 = new Book("B2", "1984", "George Orwell");
        Member member1 = new Member("M1", "Aman", "aman@gmail.com");
        Member member2 = new Member("M2", "Sanskar", "sanskarking@gmail.com");


        library.addBook(book1);
        library.addBook(book2);


        library.addMember(member1);
        library.addMember(member2);

        try {
            library.bookIssue("B1", "M1");
            System.out.println("Issued B1 to M1");

            library.bookIssue("B2", "M2");
            System.out.println("Issued B2 to M2");

            library.returnBook("B1", "M1");
            System.out.println("Returned B1 from M1");

        } catch (Exception e) {
            System.out.println("Operation failed: " + e.getMessage());
        }
    }
}
