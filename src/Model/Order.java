package Model;
import java.util.Date;

public class Order {
    private int orderID;
    private int productID;
    private int quantity;
    private Date orderDate;

    public Order(int orderID, int productID, int quantity, Date orderDate) {
        this.orderID = orderID;
        this.productID = productID;
        this.quantity = quantity;
        this.orderDate = orderDate;
    }

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

    @Override
    public String toString() {
        return "Order [ID=" + orderID + ", Product ID=" + productID + ", Quantity=" + quantity + ", Date=" + orderDate + "]";
    }
}
