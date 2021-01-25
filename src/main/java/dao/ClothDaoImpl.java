package dao;

import api.ProductDao;
import entity.Cloth;
import entity.Product;
import enums.Color;
import enums.Material;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClothDaoImpl implements ProductDao {
    private static ClothDaoImpl instance = null;
    private Connection connection;
    private String databaseName = "management";
    private String user = "root";
    private String password = "admin";
    private String tableName = "cloths";

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

    private ClothDaoImpl() {
        init();
    }

    public static ClothDaoImpl getInstance() {
        if (instance == null) {
            instance = new ClothDaoImpl();
        }
        return instance;
    }

    public void saveProduct(Cloth product) throws IOException {
        PreparedStatement statement;
        try {
            String query = "insert * into " + tableName +
                    " (productname, price, weight, color, productcount, size, material) " +
                    "values (?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, product.getProductName());
            statement.setBigDecimal(2, product.getPrice());
            statement.setBigDecimal(3, product.getWeight());
            statement.setString(4, product.getColor().name());
            statement.setInt(5, product.getProductCount());
            statement.setString(6, product.getSize());
            statement.setString(7, product.getMaterial().name());
            statement.execute();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void removeProductById(long productId) throws IOException {

        try {
            PreparedStatement statement = connection.prepareStatement("delete * from " + tableName + " where ID='" + productId + "'");
            statement.execute();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void removeProductByName(String productName) throws IOException {
        try {
            PreparedStatement statement = connection.prepareStatement("delete * from " + tableName + " where productname='" + productName + "'");
            statement.execute();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Product> getAllProducts() throws IOException {
        List<Product> products = new ArrayList<Product>();
        try {
            Statement statement = null;
            String query = "select * from " + tableName;
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Long id = (long)resultSet.getInt("ID");
                String name = resultSet.getString("productname");
                BigDecimal price = resultSet.getBigDecimal("price");
                BigDecimal weight = resultSet.getBigDecimal("weight");
                Color color = Color.valueOf(resultSet.getString("color"));
                int productCount = resultSet.getInt("productcount");
                String size = resultSet.getString("size");
                Material material = Material.valueOf(resultSet.getString("material"));
                Product cloth = new Cloth(id, name, price, weight, color, productCount, size, material);
                products.add(cloth);
            }
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }

    public Product getProductById(long productId) {
        try {
            Statement statement = null;
            String query = "select * from " + tableName + " where ID='" + productId + "'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Long id = (long)resultSet.getInt("ID");
                String name = resultSet.getString("productname");
                BigDecimal price = resultSet.getBigDecimal("price");
                BigDecimal weight = resultSet.getBigDecimal("weight");
                Color color = Color.valueOf(resultSet.getString("color"));
                int productCount = resultSet.getInt("productcount");
                String size = resultSet.getString("size");
                Material material = Material.valueOf(resultSet.getString("material"));
                Product cloth = new Cloth(id, name, price, weight, color, productCount, size, material);
                return cloth;
            }
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public Product getProductByProductName(String productName) {
        try {
            Statement statement = null;
            String query = "select * from " + tableName + " where productname='" + productName + "'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Long id = (long)resultSet.getInt("ID");
                String name = resultSet.getString("productname");
                BigDecimal price = resultSet.getBigDecimal("price");
                BigDecimal weight = resultSet.getBigDecimal("weight");
                Color color = Color.valueOf(resultSet.getString("color"));
                int productCount = resultSet.getInt("productcount");
                String size = resultSet.getString("size");
                Material material = Material.valueOf(resultSet.getString("material"));
                Product cloth = new Cloth(id, name, price, weight, color, productCount, size, material);
                return cloth;
            }
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
