package Model;


// User class that extends the Person class
public class User extends Person {
    // Fields for username and password
    private String username;
    private String password;


    // Constructor to initialize User with name, username, and password
    public User(String name, String username, String password) {
        super(name); // Use of super keyword to call the parent class constructor
        this.username = username;
        this.password = password;
    }


    // Getters and Setters for the fields
    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    // Override toString method to provide a string representation of the User
    @Override
    public String toString() {
        return "User [Name=" + super.getName() + ", Username=" + username + "]"; // Use of super keyword to call parent class method
    }
}
