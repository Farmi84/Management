package api;

import entity.Product;

import java.util.List;

public interface ProductFacade {
    boolean createProduct(Product product);
    boolean removeProduct(String productName);
    List<Product> getAllProducts();
}
