package service;

import api.ProductService;
import dao.ClothDaoImpl;
import entity.Cloth;
import entity.Product;
import entity.validator.ProductValidator;
import exception.ProductCountNegativeException;
import exception.ProductNameEmptyException;
import exception.ProductPriceNoPositiveException;
import exception.ProductWeightNoPositiveException;

import java.io.IOException;
import java.util.List;

public class ClothServiceImpl implements ProductService {
    private static ClothServiceImpl clothServiceImpl = null;
    ClothDaoImpl clothDao = ClothDaoImpl.getInstance();

    private ClothServiceImpl() throws IOException {
    }

    public static ClothServiceImpl getInstance() throws IOException {

        if (clothServiceImpl == null) {
            clothServiceImpl = new ClothServiceImpl();
        }
        return clothServiceImpl;

    }

    public List<Product> getAllProduct(){
        try {
            return clothDao.getAllProducts();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer numberOfProducts(){
        try {
            return clothDao.getAllProducts().size();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Product findProduct(String productName) {
        return clothDao.getProductByProductName(productName);
    }

    public boolean isInStock(String productName) {

        if (clothDao.getProductByProductName(productName).getProductCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isExistByName(String productName){
        Product product = null;
        product = clothDao.getProductByProductName(productName);

        if (product != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isExistById(long id){
        Product product = null;
        product = clothDao.getProductById(id);

        if (product != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean saveProduct(Cloth product) {
        try {
            if (ProductValidator.getInstance().isValidate(product)) {
                clothDao.saveProduct(product);
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
