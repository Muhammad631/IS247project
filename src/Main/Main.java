package Main;

import Model.Product;
import Model.Order;
import Service.InventoryOperations;
import Exception.ProductNotFoundException;
import java.util.Date;
import java.util.Scanner;
import Service.Inventory;


public class Main {
    public static void main(String[] args) {
        // Initialize the scanner for user input
        Scanner scanner = new Scanner(System.in);
        // Initialize the inventory management system
        InventoryOperations inventory = new Inventory();


        // Check the availability of products based on user input quantity
        System.out.print("Enter product quantity for availability check: ");
        int checkQuantity = scanner.nextInt();
        String availability = (checkQuantity > 0) ? "In Stock" : "Out of Stock";
        System.out.println("Product availability: " + availability);


        // Main loop for the Inventory Management System
        while (true) {
            // Display the menu options to the user
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Update Product");
            System.out.println("4. View Product");
            System.out.println("5. View All Products");
            System.out.println("6. Add Order");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline


            try {
                // Perform actions based on user choice
                switch (choice) {
                    case 1:
                        // Add a new product
                        System.out.print("Enter product ID: ");
                        int productID = scanner.nextInt();
                        scanner.nextLine(); // Consume newline


                        System.out.print("Enter product name: ");
                        String productName = scanner.nextLine();


                        System.out.print("Enter product price: ");
                        double price = scanner.nextDouble();


                        System.out.print("Enter product quantity: ");
                        int productQuantity = scanner.nextInt();


                        Product product = new Product(productID, productName, price, productQuantity);
                        inventory.addProduct(product);
                        System.out.println("Product added: " + product);
                        break;


                    case 2:
                        // Remove an existing product
                        System.out.print("Enter product ID to remove: ");
                        int removeID = scanner.nextInt();
                        inventory.removeProduct(removeID);
                        System.out.println("Product removed with ID: " + removeID);
                        break;


                    case 3:
                        // Update an existing product
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
                        break;


                    case 4:
                        // View a specific product
                        System.out.print("Enter product ID to view: ");
                        int viewID = scanner.nextInt();
                        try {
                            Product viewProduct = inventory.getProduct(viewID);
                            System.out.println("Product details: " + viewProduct);
                        } catch (ProductNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                        break;


                    case 5:
                        // View all products in the inventory
                        System.out.println("All Products in Inventory:");
                        for (Product p : inventory.getAllProducts()) {
                            System.out.println(p);
                        }
                        break;


                    case 6:
                        // Add a new order
                        System.out.print("Enter order ID: ");
                        int orderID = scanner.nextInt();
                        scanner.nextLine(); // Consume newline


                        System.out.print("Enter product ID for the order: ");
                        int orderProductID = scanner.nextInt();


                        System.out.print("Enter order quantity: ");
                        int orderQuantity = scanner.nextInt();


                        Order order = new Order(orderID, orderProductID, orderQuantity, new Date());
                        System.out.println("Order added: " + order);
                        break;


                    case 7:
                        // Exit the program
                        System.out.println("Exiting...");
                        scanner.close();
                        System.exit(0);


                    default:
                        // Handle invalid choices
                        System.out.println("Invalid choice");
                }
            } catch (ProductNotFoundException e) {
                // Handle the case where a product is not found
                System.out.println(e.getMessage());
            }
        }
    }
}
