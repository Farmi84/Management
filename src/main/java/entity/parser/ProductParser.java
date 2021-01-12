package entity.parser;

import entity.Boots;
import entity.Cloth;
import entity.Product;

public class ProductParser {

    public static Product stringToProduct(String readLine) {
        char type = readLine.charAt(0);
        String[] values = readLine.split("#");
        long id = Long.parseLong(values[1]);
        String productName = values[2];
        float price = Float.parseFloat(values[3]);
        float weight = Float.parseFloat(values[4]);
        String color = values[5];
        int productCount = Integer.parseInt(values[6]);

        switch (type) {

            case 'P':

                Product product = new Product(id, productName, price, weight, color, productCount);
                return product;


            case 'C':
                String sizeString = values[7];
                String material = values[8];
                Product cloth = new Cloth(id, productName, price, weight, color, productCount, sizeString, material);
                return cloth;

            case 'B':
                int sizeInt = Integer.parseInt(values[7]);
                boolean isNaturalSkin = Boolean.parseBoolean(values[8]);
                Product boots = new Boots(id, productName, price, weight, color, productCount, sizeInt, isNaturalSkin);
                return boots;

        }
        return null;
    }
}
