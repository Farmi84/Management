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

        if (productServiceImpl == null) {
            try {
                productServiceImpl = new ProductServiceImpl();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return productServiceImpl;

    }

    public List<Product> getAllProduct()  {
        return productDao.getAllProducts();
    }

    public Integer numberOfProducts()  {
        return productDao.getAllProducts().size();
    }

    public Product findProduct(String productName){
        return productDao.getProductByProductName(productName);
    }

    public boolean isInStock(String productName){

        if (productDao.getProductByProductName(productName).getProductCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isExistByName(String productName){
        Product product = null;
        product = productDao.getProductByProductName(productName);

        if (product != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isExistById(long id){
        Product product = null;
        product = productDao.getProductById(id);

        if (product != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean saveProduct(Product product) {
        try {
            if (ProductValidator.getInstance().isValidate(product)) {
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
        }
        return false;
    }
}
