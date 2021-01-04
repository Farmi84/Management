package service;

import api.ProductService;
import entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    List<Product> products;

    public ProductServiceImpl(){
        products = new ArrayList<Product>();
    }

    public ProductServiceImpl(List<Product> products){
        this.products = products;
    }

    public List<Product> getAllProduct() {
        return products;
    }

    public int numberOfProducts() {
        return products.size();
    }

    public Product findProduct(String productName) {
        for(int i = 0; i < products.size(); i++){
            Product product = products.get(i);
            if(product.getProductName().equals(productName)){
                return product;
            }
        }
        return null;
    }

    public boolean isInStock(String productName) {
        Product product = findProduct(productName);
        if(product != null && product.getProductCount() > 0){
            return true;
        } else {
            return false;
        }
    }

    public boolean isExistByName(String productName) {
        for(int i = 0; i < products.size(); i++){
            Product product = products.get(i);
            if(product.getProductName().equals(productName)){
                return true;
            }
        }
        return false;
    }

    public boolean isExistById(long id) {
        for(int i = 0; i < products.size(); i++){
            Product product = products.get(i);
            if(product.getId() == id){
                return true;
            }
        }
        return false;
    }
}
