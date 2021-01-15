package entity;

import constant.Color;
import constant.ProductSeparators;
import constant.SkinType;

public class Boots extends Product {
    private int size;
    private SkinType skinType;

    public Boots(long id, String productName, float price, float weight, Color color, int productCount, int size, SkinType skinType) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.skinType = skinType;
    }

    public int getSize() {
        return size;
    }

    public SkinType isNaturalSkin() {
        return skinType;
    }

    @Override
    public String toString() {
        return ProductSeparators.BOOTS_ID + ProductSeparators.PRODUCT_SEPARATOR.toString() +
                getId() + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + getProductName() + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + getPrice() + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + getWeight() + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + getColor() + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + getProductCount() + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + size + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + skinType + ProductSeparators.PRODUCT_SEPARATOR.toString();
    }
}
