package dao;

import api.ProductDao;
import entity.Product;
import entity.parser.ProductParser;
import enums.Color;

import java.io.*;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private Connection connection;
    private String databaseName = "management";
    private String user = "root";
    private String password = "admin";
    private String tableName = "products";
    private String fileName = "products.txt";
    private static ProductDaoImpl instance = null;

    private void init() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + databaseName + "?useSSL=false", user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    private ProductDaoImpl() throws IOException {
        init();
    }

    public static ProductDaoImpl getInstance() throws IOException {
        if (instance == null) {
            instance = new ProductDaoImpl();
        }
        return instance;
    }

    public void saveProduct(Product product) {
        PreparedStatement statement;
        try {
            String query = "insert into " + tableName +
                    " (productname, price, weight, color, productcount) " +
                    "values (?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, product.getProductName());
            statement.setBigDecimal(2, product.getPrice());
            statement.setBigDecimal(3, product.getWeight());
            statement.setString(4, product.getColor().name());
            statement.setInt(5, product.getProductCount());
            statement.execute();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    public void removeProductById(long productId) {
        PreparedStatement statement;
        try {
            String query = "delete * from " + databaseName + " where ID='" + productId + "'";
            statement = connection.prepareStatement(query);
            statement.execute();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void removeProductByName(String productName) throws IOException {
        PreparedStatement statement;
        try {
            String query = "delete * from " + databaseName + " where productname='" + productName + "'";
            statement = connection.prepareStatement(query);
            statement.execute();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Product> getAllProducts(){
        List<Product> products = new ArrayList<Product>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = "select * from " + tableName;
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                long id = resultSet.getInt("ID");
                String productName = resultSet.getString("productname");
                BigDecimal price = new BigDecimal(resultSet.getString("price"));
                BigDecimal weight = new BigDecimal(resultSet.getString("weight"));
                Color color =  Color.valueOf(resultSet.getString("color"));
                int productCount = resultSet.getInt("productcount");
                Product product = new Product(id, productName, price, weight, color, productCount);
                products.add(product);
            }
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;

    }

    public Product getProductById(long productId) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = "select * from " + tableName + " where ID='" + productId + "'";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                long id = resultSet.getInt("ID");
                String productName = resultSet.getString("productname");
                BigDecimal price = new BigDecimal(resultSet.getString("price"));
                BigDecimal weight = new BigDecimal(resultSet.getString("weight"));
                Color color =  Color.valueOf(resultSet.getString("color"));
                int productCount = resultSet.getInt("productcount");
                Product product = new Product(id, productName, price, weight, color, productCount);
                return product;
            }
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public Product getProductByProductName(String productName){
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = "select * from " + tableName + " where productname='" + productName + "'";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                long id = resultSet.getInt("ID");
                String name = resultSet.getString("productname");
                BigDecimal price = new BigDecimal(resultSet.getString("price"));
                BigDecimal weight = new BigDecimal(resultSet.getString("weight"));
                Color color =  Color.valueOf(resultSet.getString("color"));
                int productCount = resultSet.getInt("productcount");
                Product product = new Product(id, name, price, weight, color, productCount);
                return product;
            }
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
