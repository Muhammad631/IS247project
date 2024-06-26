package Model;
public class User extends Person {
    private String username;
    private String password;
    private boolean loggedIn;

    public User(String name, String username, String password) {
        super(name);
        this.username = username;
        this.password = password;
        this.loggedIn = false;
    }

    // Method to authenticate user login
    public boolean login(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            this.loggedIn = true;
            System.out.println("Login successful.");
            return true;
        } else {
            System.out.println("Login failed. Invalid username or password.");
            return false;
        }
    }

    // Method to logout user
    public void logout() {
        if (loggedIn) {
            this.loggedIn = false;
            System.out.println("Logout successful.");
        } else {
            System.out.println("No user logged in.");
        }
    }

    // Method to check if user is logged in
    public boolean isLoggedIn() {
        return loggedIn;
    }

    // Method to display user information
    public void displayUserInfo() {
        System.out.println("User Information:");
        System.out.println("Name: " + getName());
        System.out.println("Username: " + username);
    }

    @Override
    public String toString() {
        return "User [Name=" + getName() + ", Username=" + username + "]";
    }
}
