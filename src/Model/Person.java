package Model;


// Abstract class representing a Person
public abstract class Person {
    // Field for the name of the person
    private String name;


    // Constructor to initialize the name of the person
    public Person(String name) {
        this.name = name;
    }


    // Getter for the name field
    public String getName() {
        return name;
    }


    // Setter for the name field
    public void setName(String name) {
        this.name = name;
    }


    // Override toString method to provide a string representation of the Person
    @Override
    public String toString() {
        return "Person [Name=" + name + "]";
    }
}
