package Model;


import java.util.Date;


// Model class representing an Order
public class Order {
    // Fields for order ID, product ID, quantity, and order date
    private int orderID;
    private int productID;
    private int quantity;
    private Date orderDate;


    // Constructor to initialize the order with given details
    public Order(int orderID, int productID, int quantity, Date orderDate) {
        this.orderID = orderID;
        this.productID = productID;
        this.quantity = quantity;
        this.orderDate = orderDate;
    }


    // Getters and Setters for the fields
    public int getOrderID() {
        return orderID;
    }


    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }


    public int getProductID() {
        return productID;
    }


    public void setProductID(int productID) {
        this.productID = productID;
    }


    public int getQuantity() {
        return quantity;
    }


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public Date getOrderDate() {
        return orderDate;
    }


    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }


    // Override toString method to provide a string representation of the order
    @Override
    public String toString() {
        return "Order [ID=" + orderID + ", Product ID=" + productID + ", Quantity=" + quantity + ", Date=" + orderDate + "]";
    }
}

