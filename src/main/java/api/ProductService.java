package api;

import entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();
    int numberOfProducts();
    Product findProduct(String productName);
    boolean isInStock (String productName);
    boolean isExistByName(String productName);
    boolean isExistById(long id);

}
