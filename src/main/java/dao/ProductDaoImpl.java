package dao;

import api.ProductDao;
import entity.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    String fileName;

    public ProductDaoImpl(String fileName) {
        this.fileName = fileName;
    }

    public void saveProduct(Product product) throws IOException {

        List<Product> allProducts = getAllProducts();
        allProducts.add(product);
        FileWriter fileWriter = new FileWriter(fileName);
        for(int i = 0; i < allProducts.size(); i++){
            fileWriter.write(allProducts.get(i).toString() + "\n");
        }
        fileWriter.close();
    }

    public void saveProducts(List<Product> products) throws IOException {
        List<Product> allProducts = getAllProducts();
        allProducts.addAll(products);
        FileWriter fileWriter = new FileWriter(fileName);
        for(int i = 0; i < allProducts.size(); i++){
            fileWriter.write(allProducts.get(i).toString() + "\n");
        }
        fileWriter.close();
    }

    public void removeProductById(long productId) throws IOException {
        List<Product> allProducts = getAllProducts();
        for(int i = 0; i < allProducts.size(); i++){
            Product product = allProducts.get(i);
            if(product.getId() == productId){
                allProducts.remove(i);
                return;
            }
        }
        FileWriter fileWriter = new FileWriter(fileName);
        for(int i = 0; i < allProducts.size(); i++){
            fileWriter.write(allProducts.get(i).toString() + "\n");
        }
        fileWriter.close();
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
        FileWriter fileWriter = new FileWriter(fileName);
        for(int i = 0; i < allProducts.size(); i++){
            fileWriter.write(allProducts.get(i).toString() + "\n");
        }
        fileWriter.close();
    }

    public List<Product> getAllProducts() throws IOException {
        List<Product> products = new ArrayList<Product>();
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String readLine = bufferedReader.readLine();
        if (readLine != null) {
            while(readLine != null) {
                String[] values = readLine.split("#");
                int id = Integer.parseInt(values[0]);
                String productName = values[1];
                float price = Integer.parseInt(values[2]);
                float weight = Integer.parseInt(values[3]);
                String color = values[4];
                int productCount = Integer.parseInt(values[5]);
                Product product = new Product(id, productName, price, weight, color, productCount);
                products.add(product);
                String readline = bufferedReader.readLine();
            }
            bufferedReader.close();
            return products;
        } else {
            return null;
        }
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
