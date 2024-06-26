package Service;
import java.util.ArrayList;
import Model.ManageInventory;
import java.util.List;
import Model.Product;
public class Inventory implements ManageInventory {
    private List<Product> products;

    public Inventory() {
        products = new ArrayList<>();
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void removeProduct(int productID) {
        products.removeIf(p -> p.getProductID() == productID);
    }

    @Override
    public void updateProduct(int productID, Product updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductID() == productID) {
                products.set(i, updatedProduct);
                return;
            }
        }
    }

    @Override
    public Product getProduct(int productID) {
        for (Product product : products) {
            if (product.getProductID() == productID) {
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }
}