package Model;


// Class representing a Supplier
public class Supplier {
    // Fields for supplier ID, name, and contact information
    private int supplierID;
    private String name;
    private String contactInfo;


    // Constructor to initialize the supplier with given details
    public Supplier(int supplierID, String name, String contactInfo) {
        this.supplierID = supplierID;
        this.name = name;
        this.contactInfo = contactInfo;
    }


    // Getters and Setters for the fields
    public int getSupplierID() {
        return supplierID;
    }


    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getContactInfo() {
        return contactInfo;
    }


    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }


    // Override toString method to provide a string representation of the Supplier
    @Override
    public String toString() {
        return "Supplier [ID=" + supplierID + ", Name=" + name + ", Contact Info=" + contactInfo + "]";
    }
}

