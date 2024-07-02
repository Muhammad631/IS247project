package Service;


import Model.Product;
import Exception.ProductNotFoundException;

import java.util.List;


// Interface defining inventory operations
public interface InventoryOperations {
    // Method to add a product to the inventory
    void addProduct(Product product);
    void removeProduct(int productID) throws ProductNotFoundException;
    void updateProduct(int productID, Product updatedProduct) throws ProductNotFoundException;
    Product getProduct(int productID) throws ProductNotFoundException;
    List<Product> getAllProducts();
}

