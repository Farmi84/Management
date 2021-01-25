package entity;

import enums.Color;
import enums.Material;
import enums.ProductSeparators;

import java.math.BigDecimal;

public class Cloth extends Product {
    String size;
    Material material;


    public Cloth(long id, String productName, BigDecimal price, BigDecimal weight, Color color, int productCount, String size, Material material) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public Material getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return ProductSeparators.CLOTH_ID + ProductSeparators.PRODUCT_SEPARATOR.toString() +
                getId() + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + getProductName() + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + getPrice() + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + getWeight() + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + getColor() + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + getProductCount() + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + size + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + material + ProductSeparators.PRODUCT_SEPARATOR.toString();
    }
}
