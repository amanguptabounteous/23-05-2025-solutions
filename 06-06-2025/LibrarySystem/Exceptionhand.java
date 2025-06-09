package LibrarySystem;

class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}

class MemberNotFoundException extends Exception {
    public MemberNotFoundException(String message) {
        super(message);
    }
}

class OverdueBookException extends Exception {
    public OverdueBookException(String message) {
        super(message);
    }
}
