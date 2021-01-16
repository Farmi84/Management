package service;

import api.ProductService;
import dao.ProductDaoImpl;
import entity.Product;
import entity.validator.ProductValidator;
import exception.ProductCountNegativeException;
import exception.ProductNameEmptyException;
import exception.ProductPriceNoPositiveException;
import exception.ProductWeightNoPositiveException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private static ProductServiceImpl productServiceImpl = null;
    ProductDaoImpl productDao = ProductDaoImpl.getInstance();

    private ProductServiceImpl() throws IOException {
    }

    public static ProductServiceImpl getInstance()  {
        try {
        if(productServiceImpl == null) {
            productServiceImpl = new ProductServiceImpl();
                }
            return productServiceImpl;
            } catch (IOException e) {
                e.printStackTrace();
            }
        return null;
    }

    public List<Product> getAllProduct() throws IOException {
        return productDao.getAllProducts();
    }

    public Integer numberOfProducts() throws IOException {
        return productDao.getAllProducts().size();
    }

    public Product findProduct(String productName) throws IOException {
        return productDao.getProductByProductName(productName);
    }

    public boolean isInStock(String productName) {
        try {
            if (productDao.getProductByProductName(productName).getProductCount() > 0) {
                return true;
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean isExistByName(String productName) {
        Product product = null;
        try {
            product = productDao.getProductByProductName(productName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(product != null){
            return true;
        } else{
            return false;
        }
    }

    public boolean isExistById(long id) {
        Product product = null;
        try {
            product = productDao.getProductById(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(product != null){
            return true;
        } else{
            return false;
        }
    }

    public boolean saveProduct(Product product)  {
        try {
            if(ProductValidator.getInstance().isValidate(product)) {
                productDao.saveProduct(product);
                return true;
            }
        } catch (ProductPriceNoPositiveException e) {
            e.printStackTrace();
        } catch (ProductNameEmptyException e) {
            e.printStackTrace();
        } catch (ProductCountNegativeException e) {
            e.printStackTrace();
        } catch (ProductWeightNoPositiveException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
