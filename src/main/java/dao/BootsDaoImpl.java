package dao;

import api.ProductDao;
import entity.Boots;
import entity.Product;
import enums.Color;
import enums.SkinType;
import javafx.scene.control.Skin;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BootsDaoImpl implements ProductDao {
    private static BootsDaoImpl instance = null;
    private String databaseName = "management";
    private String tableName = "boots";
    private String user = "root";
    private String password = "admin";
    private Connection connection;

    private void init(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + databaseName + "?useSSL=false", user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private BootsDaoImpl() {
        init();
    }

    public static BootsDaoImpl getInstance(){
        if(instance==null){
            instance = new BootsDaoImpl();
        }
        return instance;
    }

    public void saveProduct(Boots product) throws IOException {
        PreparedStatement statement;
        try {
            String query = "insert * into " + tableName + " (productname, price, weight, color, productcount, size, skintype) " +
                    "values (?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, product.getProductName());
            statement.setBigDecimal(2, product.getPrice());
            statement.setBigDecimal(3, product.getWeight());
            statement.setString(4, product.getColor().name() );
            statement.setInt(5, product.getProductCount());
            statement.setInt(6, product.getSize());
            statement.setString(7, product.getSkinType().name());
            statement.execute();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void removeProductById(long productId) throws IOException {
        try {
            PreparedStatement statement = connection.prepareStatement("delete * from " + databaseName + " where ID='" + productId + "'");
            statement.execute();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void removeProductByName(String productName) throws IOException {
        try {
            PreparedStatement statement = connection.prepareStatement("delete * from " + databaseName + " where productname='" + productName + "'");
            statement.execute();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Product> getAllProducts() throws IOException {
        List<Product> products = new ArrayList<Product>();
        try {
            Statement statement = connection.createStatement();
            String query = "select * from " +databaseName;
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                long id = (long)resultSet.getInt("ID");
                String productName = resultSet.getString("productname");
                BigDecimal price = resultSet.getBigDecimal("price");
                BigDecimal weight = resultSet.getBigDecimal("weight");
                Color color = Color.valueOf(resultSet.getString("color"));
                int productCount = resultSet.getInt("productcount");
                int size = resultSet.getInt("size");
                SkinType skinType = SkinType.valueOf(resultSet.getString("skintype"));
                Product boots = new Boots(id, productName, price, weight, color, productCount, size, skinType);
                products.add(boots);
            }
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }

    public Product getProductById(long productId) {
        try {
            Statement statement = connection.createStatement();
            String query = "select * from " +databaseName + " where ID='" + productId + "'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                long id = (long)resultSet.getInt("ID");
                String productName = resultSet.getString("productname");
                BigDecimal price = resultSet.getBigDecimal("price");
                BigDecimal weight = resultSet.getBigDecimal("weight");
                Color color = Color.valueOf(resultSet.getString("color"));
                int productCount = resultSet.getInt("productcount");
                int size = resultSet.getInt("size");
                SkinType skinType = SkinType.valueOf(resultSet.getString("skintype"));
                Product boots = new Boots(id, productName, price, weight, color, productCount, size, skinType);
                return boots;
            }
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public Product getProductByProductName(String productName) {
        try {
            Statement statement = connection.createStatement();
            String query = "select * from " +databaseName + " where productname='" + productName + "'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                long id = (long)resultSet.getInt("ID");
                String name = resultSet.getString("productname");
                BigDecimal price = resultSet.getBigDecimal("price");
                BigDecimal weight = resultSet.getBigDecimal("weight");
                Color color = Color.valueOf(resultSet.getString("color"));
                int productCount = resultSet.getInt("productcount");
                int size = resultSet.getInt("size");
                SkinType skinType = SkinType.valueOf(resultSet.getString("skintype"));
                Product boots = new Boots(id, name, price, weight, color, productCount, size, skinType);
                return boots;
            }
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
