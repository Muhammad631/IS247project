package Service;


import Model.Supplier;
import java.util.HashMap;
import java.util.Map;


// Class representing the service for managing suppliers
public class SupplierService {
    // Map to hold suppliers with their ID as the key
    private Map<Integer, Supplier> suppliers;


    // Constructor to initialize the suppliers map
    public SupplierService() {
        suppliers = new HashMap<>();
    }


    // Method to add a supplier to the map
    public void addSupplier(Supplier supplier) {
        suppliers.put(supplier.getSupplierID(), supplier);
    }


    // Method to retrieve a supplier from the map by ID
    public Supplier getSupplier(int supplierID) {
        return suppliers.get(supplierID);
    }


    // Method to remove a supplier from the map by ID
    public void removeSupplier(int supplierID) {
        suppliers.remove(supplierID);
    }
}
