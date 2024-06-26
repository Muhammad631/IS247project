package Main;
import java.util.*;
import Service.Inventory;
import Model.*;

public class Main {
    private static int nextOrderID = 1; // Keeps track of the next order ID
    private static List<Order> orders = new ArrayList<>(); // List to store orders
    private static Scanner scanner = new Scanner(System.in);
    private static Inventory inventory = new Inventory();

    public static void main(String[] args) {
        User user = loginUser(); // Login user

        while (true) {
            displayMenu();

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    removeProduct();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    viewProduct();
                    break;
                case 5:
                    viewAllProducts();
                    break;
                case 6:
                    createOrder();
                    break;
                case 7:
                    viewAllOrders();
                    break;
                case 8:
                    logout(user);
                    break;
                case 9:
                    exitProgram();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nInventory Management System");
        System.out.println("1. Add Product");
        System.out.println("2. Remove Product");
        System.out.println("3. Update Product");
        System.out.println("4. View Product");
        System.out.println("5. View All Products");
        System.out.println("6. Create Order");
        System.out.println("7. View All Orders");
        System.out.println("8. Logout");
        System.out.println("9. Exit");
        System.out.print("Enter your choice: ");
    }

    private static User loginUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        return new User("John Doe", username, password); // Example user, replace with actual authentication logic
    }

    private static void logout(User user) {
        System.out.println("Logging out...");
        scanner.close();
        System.exit(0);
    }

    private static void addProduct() {
        System.out.print("Enter product ID: ");
        int productID = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();

        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter product quantity: ");
        int quantity = scanner.nextInt();

        Product product = new Product(productID, productName, price, quantity);
        inventory.addProduct(product);
        System.out.println("Product added: " + product);
    }

    private static void removeProduct() {
        System.out.print("Enter product ID to remove: ");
        int removeID = scanner.nextInt();
        inventory.removeProduct(removeID);
        System.out.println("Product removed with ID: " + removeID);

    }

    private static void updateProduct() {
        System.out.print("Enter product ID to update: ");
        int updateID = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter new product name: ");
        String newName = scanner.nextLine();

        System.out.print("Enter new product price: ");
        double newPrice = scanner.nextDouble();

        System.out.print("Enter new product quantity: ");
        int newQuantity = scanner.nextInt();

        Product updatedProduct = new Product(updateID, newName, newPrice, newQuantity);
        inventory.updateProduct(updateID, updatedProduct);
        System.out.println("Product updated: " + updatedProduct);
    }

    private static void viewProduct() {
        System.out.print("Enter product ID to view: ");
        int viewID = scanner.nextInt();
        Product viewProduct = inventory.getProduct(viewID);
        if (viewProduct != null) {
            System.out.println("Product details: " + viewProduct);
        } else {
            System.out.println("Product not found with ID: " + viewID);
        }
    }

    private static void viewAllProducts() {
        System.out.println("All Products in Inventory:");
        for (Product p : inventory.getAllProducts()) {
            System.out.println(p);
        }
    }

    private static void createOrder() {
        System.out.print("Enter product ID for the order: ");
        int productID = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter quantity for the order: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Product product = inventory.getProduct(productID);
        if (product != null) {
            Order order = new Order(nextOrderID++, productID, quantity, new Date());
            orders.add(order);
            System.out.println("Order created: " + order);
        } else {
            System.out.println("Product not found with ID: " + productID);
        }
    }

    private static void viewAllOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders found.");
        } else {
            System.out.println("All Orders:");
            for (Order order : orders) {
                System.out.println(order);
            }
        }
    }

    private static void exitProgram() {
        System.out.println("Exiting...");
        scanner.close();
        System.exit(0);
    }
}