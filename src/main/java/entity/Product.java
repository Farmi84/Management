package entity;

import enums.Color;
import enums.ProductSeparators;

import java.math.BigDecimal;

public class Product {
    private long id;
    private String productName;
    private BigDecimal price;
    private BigDecimal weight;
    private Color color;
    private int productCount;

    public Product(long id, String productName, BigDecimal price, BigDecimal weight, Color color, int productCount) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.weight = weight;
        this.color = color;
        this.productCount = productCount;
    }

    public long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public Color getColor() {
        return color;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    @Override
    public String toString() {
        return ProductSeparators.PRODUCT_ID + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + id + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + productName + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + price + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + weight + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + color + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + productCount + ProductSeparators.PRODUCT_SEPARATOR.toString();
    }
}
