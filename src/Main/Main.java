package Main;

import Model.Product;
import Service.Inventory;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();

        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Update Product");
            System.out.println("4. View Product");
            System.out.println("5. View All Products");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
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
                    break;

                case 2:
                    System.out.print("Enter product ID to remove: ");
                    int removeID = scanner.nextInt();
                    inventory.removeProduct(removeID);
                    System.out.println("Product removed with ID: " + removeID);
                    break;

                case 3:
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
                    System.out.print("Enter product ID to view: ");
                    int viewID = scanner.nextInt();
                    Product viewProduct = inventory.getProduct(viewID);
                    if (viewProduct != null) {
                        System.out.println("Product details: " + viewProduct);
                    } else {
                        System.out.println("Product not found with ID: " + viewID);
                    }
                    break;

                case 5:
                    System.out.println("All Products in Inventory:");
                    for (Product p : inventory.getAllProducts()) {
                        System.out.println(p);
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}