package api;

import entity.Product;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    List<Product> getAllProduct() throws IOException;
    int numberOfProducts() throws IOException;
    Product findProduct(String productName) throws IOException;
    boolean isInStock (String productName) throws IOException;
    boolean isExistByName(String productName) throws IOException;
    boolean isExistById(long id) throws IOException;

}
