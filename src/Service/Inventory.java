package Service;


import Model.Product;
import Exception.ProductNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


// Class representing the inventory, implementing InventoryOperations interface
public class Inventory implements InventoryOperations {
    // List to hold all products in the inventory
    private List<Product> products;
    // Stack to keep track of operations performed on the inventory
    private Stack<String> operationHistory;


    // Constructor to initialize the product list and operation history stack
    public Inventory() {
        products = new ArrayList<>();
        operationHistory = new Stack<>();
    }


    // Method to add a product to the inventory
    @Override
    public void addProduct(Product product) {
        products.add(product);
        operationHistory.push("Added product ID: " + product.getProductID());
    }


    // Overloaded method to add a product with default quantity of 0
    public void addProduct(int productID, String productName, double price) {
        Product product = new Product(productID, productName, price, 0);
        addProduct(product);
        operationHistory.push("Added product ID: " + productID + " with default quantity 0");
    }


    // Method to remove a product from the inventory
    // Throws ProductNotFoundException if the product with the given ID is not found
    @Override
    public void removeProduct(int productID) throws ProductNotFoundException {
        boolean removed = products.removeIf(p -> p.getProductID() == productID);
        if (!removed) {
            throw new ProductNotFoundException("Product with ID " + productID + " not found.");
        }
        operationHistory.push("Removed product ID: " + productID);
    }


    // Method to update a product in the inventory
    // Throws ProductNotFoundException if the product with the given ID is not found
    @Override
    public void updateProduct(int productID, Product updatedProduct) throws ProductNotFoundException {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductID() == productID) {
                products.set(i, updatedProduct);
                operationHistory.push("Updated product ID: " + productID);
                return;
            }
        }
        throw new ProductNotFoundException("Product with ID " + productID + " not found.");
    }


    // Method to retrieve a product from the inventory
    // Throws ProductNotFoundException if the product with the given ID is not found
    @Override
    public Product getProduct(int productID) throws ProductNotFoundException {
        return searchProductRecursive(productID, 0);
    }


    // Helper method to search for a product recursively
    private Product searchProductRecursive(int productID, int index) throws ProductNotFoundException {
        if (index >= products.size()) {
            throw new ProductNotFoundException("Product with ID " + productID + " not found.");
        }
        if (products.get(index).getProductID() == productID) {
            return products.get(index);
        }
        return searchProductRecursive(productID, index + 1);
    }


    // Method to get all products in the inventory
    public List<Product> getAllProducts() {
        return products;
    }


    // Method to get the history of operations performed on the inventory
    public Stack<String> getOperationHistory() {
        return operationHistory;
    }
}

