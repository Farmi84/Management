package service;

import api.ProductService;
import dao.BootsDaoImpl;
import entity.Boots;
import entity.Cloth;
import entity.Product;
import entity.validator.ProductValidator;
import exception.ProductCountNegativeException;
import exception.ProductNameEmptyException;
import exception.ProductPriceNoPositiveException;
import exception.ProductWeightNoPositiveException;

import java.io.IOException;
import java.util.List;

public class BootsServiceImpl implements ProductService {
    private static BootsServiceImpl bootsServiceImpl = null;
    BootsDaoImpl bootsDao = BootsDaoImpl.getInstance();

    private BootsServiceImpl() throws IOException {
    }

    public static BootsServiceImpl getInstance() throws IOException {

        if (bootsServiceImpl == null) {
            bootsServiceImpl = new BootsServiceImpl();
        }
        return bootsServiceImpl;

    }

    public List<Product> getAllProduct(){
        try {
            return bootsDao.getAllProducts();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer numberOfProducts(){
        try {
            return bootsDao.getAllProducts().size();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Product findProduct(String productName) {
        return bootsDao.getProductByProductName(productName);
    }

    public boolean isInStock(String productName){

        if (bootsDao.getProductByProductName(productName).getProductCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isExistByName(String productName) {
        Product product = null;
        product = bootsDao.getProductByProductName(productName);

        if (product != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isExistById(long id){
        Product product = null;
        product = bootsDao.getProductById(id);

        if (product != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean saveProduct(Boots product){
        try {
            if (ProductValidator.getInstance().isValidate(product)) {
                bootsDao.saveProduct(product);
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
