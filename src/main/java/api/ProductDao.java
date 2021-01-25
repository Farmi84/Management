package api;

import entity.Product;
import enums.ProductSeparators;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ProductDao {

    void removeProductById(long productId) throws IOException;
    void removeProductByName(String productName) throws IOException;
    List<Product> getAllProducts() throws IOException;
    Product getProductById(long productId);
    Product getProductByProductName(String productName);


}
