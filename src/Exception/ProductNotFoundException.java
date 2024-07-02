package Exception;


// Custom exception class for handling cases where a product is not found
public class ProductNotFoundException extends Exception {
    // Constructor that accepts a message and passes it to the superclass (Exception)
    public ProductNotFoundException(String message) {
        super(message);
    }
}
