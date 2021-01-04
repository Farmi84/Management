package dao;

import api.ProductDao;
import entity.Product;
import entity.parser.ProductParser;
import utils.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    String fileName;
    String productType;

    public ProductDaoImpl(String fileName, String productType) throws IOException {
        this.fileName = fileName;
        this.productType = productType;
        FileUtils.createNewFile(fileName);
    }

    public void saveProduct(Product product) throws IOException {

        List<Product> allProducts = getAllProducts();
        allProducts.add(product);
        saveProducts(allProducts);
    }

    public void saveProducts(List<Product> products) throws IOException {
        FileUtils.clearFile(fileName);
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileName, true));
        for (Product product : products) {
            printWriter.write(product.toString() + "\n");
        }
        printWriter.close();
    }

    public void removeProductById(long productId) throws IOException {
        List<Product> allProducts = getAllProducts();
        for(int i = 0; i < allProducts.size(); i++){
            Product product = allProducts.get(i);
            if(product.getId() == productId){
                allProducts.remove(i);
                break;
            }
        }
        saveProducts(allProducts);
    }

    public void removeProductByName(String productName) throws IOException {
        List<Product> allProducts = getAllProducts();
        for(int i = 0; i < allProducts.size(); i++){
            Product product = allProducts.get(i);
            if(product.getProductName().equals(productName)){
                allProducts.remove(i);
                return;
            }
        }
        saveProducts(allProducts);
    }

    public List<Product> getAllProducts() throws IOException {
        List<Product> products = new ArrayList<Product>();
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String readLine = bufferedReader.readLine();
        while(readLine != null) {
            Product product = ProductParser.stringToProduct(readLine, productType);
            products.add(product);
            String readline = bufferedReader.readLine();
        }
        bufferedReader.close();
        return products;

    }

    public Product getProductById(long productId) throws IOException {
        List<Product> allProducts = getAllProducts();
        for(int i = 0; i < allProducts.size(); i++){
            Product product = allProducts.get(i);
            if(product.getId() == productId){
                return product;
            }
        } return null;
    }

    public Product getProductByProductName(String productName) throws IOException {
        List<Product> allProducts = getAllProducts();
        for(int i = 0; i < allProducts.size(); i++){
            Product product = allProducts.get(i);
            if(product.getProductName().equals(productName)){
                return product;
            }
        } return null;
    }
}
