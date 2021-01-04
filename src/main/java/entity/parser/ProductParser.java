package entity.parser;

import entity.Boots;
import entity.Cloth;
import entity.Product;

public class ProductParser {

    public static Product stringToProduct(String readLine, String productType){
        if(productType.equals("PRODUCT")){
            String[] values = readLine.split("#");
            int id = Integer.parseInt(values[0]);
            String productName = values[1];
            float price = Integer.parseInt(values[2]);
            float weight = Integer.parseInt(values[3]);
            String color = values[4];
            int productCount = Integer.parseInt(values[5]);
            Product product = new Product(id, productName, price, weight, color, productCount);
            return product;
        } else if(productType.equals("CLOTH")){
            String[] values = readLine.split("#");
            int id = Integer.parseInt(values[0]);
            String productName = values[1];
            float price = Integer.parseInt(values[2]);
            float weight = Integer.parseInt(values[3]);
            String color = values[4];
            int productCount = Integer.parseInt(values[5]);
            String size = values[6];
            String material = values[7];
            Product product = new Cloth(id, productName, price, weight, color, productCount, size, material);
            return product;
        } else if(productType.equals("BOOTS")){
            String[] values = readLine.split("#");
            int id = Integer.parseInt(values[0]);
            String productName = values[1];
            float price = Integer.parseInt(values[2]);
            float weight = Integer.parseInt(values[3]);
            String color = values[4];
            int productCount = Integer.parseInt(values[5]);
            int size = Integer.parseInt(values[6]);
            boolean isNaturalSkin = Boolean.parseBoolean(values[7]);
            Product product = new Boots(id, productName, price, weight, color, productCount, size, isNaturalSkin);
            return product;
        }
        return null;
    }
}
