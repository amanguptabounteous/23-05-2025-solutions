package LibrarySystem;

public class Member {
    private String memID;
    private String name;
    private String email;

    public Member(String memID, String name, String email) {
        this.memID = memID;
        this.name = name;
        this.email = email;
    }

    public String getMemID() {
        return memID;
    }

    public void setMemID(String memID) {
        this.memID = memID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
