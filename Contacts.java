public class Contacts {
    private String name;
    private String email;
    private Long number;

    // Constructor
    public Contacts(){}
    public Contacts(String newName, String newEmail, Long newNumber) {
        this.name = newName;
        this.email = newEmail;
        this.number = newNumber;
    }

    // Methods
    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    } 

    public Long getNumber() {
        return this.number;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }
    
    public void setNumber(Long newNumber) {
        this.number = newNumber;
    }
}