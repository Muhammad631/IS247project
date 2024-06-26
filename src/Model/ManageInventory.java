package Model;

import java.util.List;
public interface ManageInventory {
    void addProduct(Product product);
    void removeProduct(int productID);
    void updateProduct(int productID, Product updatedProduct);
    Product getProduct(int productID);
    List<Product> getAllProducts();
}

