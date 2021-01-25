package api;

import entity.Product;
import exception.ProductCountNegativeException;
import exception.ProductNameEmptyException;
import exception.ProductPriceNoPositiveException;
import exception.ProductWeightNoPositiveException;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    List<Product> getAllProduct() throws IOException;
    Integer numberOfProducts() throws IOException;
    Product findProduct(String productName) throws IOException;
    boolean isInStock (String productName) throws IOException;
    boolean isExistByName(String productName) throws IOException;
    boolean isExistById(long id) throws IOException;


}
