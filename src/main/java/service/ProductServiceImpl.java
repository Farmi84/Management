package service;

import api.ProductService;
import dao.ProductDaoImpl;
import entity.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private static ProductServiceImpl productServiceImpl = null;
    ProductDaoImpl productDao = new ProductDaoImpl("products.data", "PRODUCT");

    private ProductServiceImpl() throws IOException {
    }

    public static ProductServiceImpl getInstance() throws IOException {
        if(productServiceImpl == null){
            productServiceImpl = new ProductServiceImpl();
        }
        return productServiceImpl;
    }

    public List<Product> getAllProduct() throws IOException {
        return productDao.getAllProducts();
    }

    public int numberOfProducts() throws IOException {
        return productDao.getAllProducts().size();
    }

    public Product findProduct(String productName) throws IOException {
        return productDao.getProductByProductName(productName);
    }

    public boolean isInStock(String productName) throws IOException {
        return productDao.getProductByProductName(productName).getProductCount() > 0;
    }

    public boolean isExistByName(String productName) throws IOException {
        Product product = productDao.getProductByProductName(productName);
        if(product != null){
            return true;
        } else{
            return false;
        }
    }

    public boolean isExistById(long id) throws IOException {
        Product product = productDao.getProductById(id);
        if(product != null){
            return true;
        } else{
            return false;
        }
    }
}
