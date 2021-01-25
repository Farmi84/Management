package entity.parser;

import enums.Color;
import enums.Material;
import enums.SkinType;
import entity.Boots;
import entity.Cloth;
import entity.Product;

import java.math.BigDecimal;

public class ProductParser {

    public static Product stringToProduct(String readLine) {
        char type = readLine.charAt(0);
        String[] values = readLine.split("#");
        long id = Long.parseLong(values[1]);
        String productName = values[2];
        BigDecimal price = new BigDecimal(values[3]);
        BigDecimal weight = new BigDecimal(values[4]);
        Color color = ColorParser.parseColor(values[5]);
        int productCount = Integer.parseInt(values[6]);

        switch (type) {

            case 'P':

                Product product = new Product(id, productName, price, weight, color, productCount);
                return product;


            case 'C':
                String sizeString = values[7];
                Material material = MaterialParser.parseMaterial(values[8]);
                Product cloth = new Cloth(id, productName, price, weight, color, productCount, sizeString, material);
                return cloth;

            case 'B':
                int sizeInt = Integer.parseInt(values[7]);
                SkinType isNaturalSkin = SkinParser.parseSkinType(values[8]);
                Product boots = new Boots(id, productName, price, weight, color, productCount, sizeInt, isNaturalSkin);
                return boots;

        }
        return null;
    }
}
