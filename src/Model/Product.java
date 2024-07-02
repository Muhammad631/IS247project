package Model;


/**
 * Represents a product in the inventory.
 */
public class Product {
    // Fields for product ID, name, price, and quantity
    private int productID;
    private String productName;
    private double price;
    private int quantity;
    // Static variable to keep track of product count
    private static int productCount = 0;


    /**
     * Constructs a new product with the specified details.
     *
     * @param productID    the product ID
     * @param productName  the product name
     * @param price        the product price
     * @param quantity     the product quantity
     */
    public Product(int productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        productCount++; // Increment product count for each new product
    }


    /**
     * Gets the total count of products.
     *
     * @return the total count of products
     */
    public static int getProductCount() {
        return productCount;
    }


    // Getters and Setters
    public int getProductID() {
        return this.productID;
    }


    public void setProductID(int productID) {
        this.productID = productID;
    }


    public String getProductName() {
        return this.productName;
    }


    public void setProductName(String productName) {
        this.productName = productName;
    }


    public double getPrice() {
        return this.price;
    }


    public void setPrice(double price) {
        this.price = price;
    }


    public int getQuantity() {
        return this.quantity;
    }


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    // Override toString method to provide a string representation of the product
    @Override
    public String toString() {
        return "Product [ID=" + this.productID + ", Name=" + this.productName + ", Price=" + this.price + ", Quantity=" + this.quantity + "]";
    }
}
