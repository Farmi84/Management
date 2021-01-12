package entity;

public class Cloth extends Product {
    String size;
    String material;
    final String productType = "C";

    public Cloth(long id, String productName, float price, float weight, String color, int productCount, String size, String material) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return productType + "#" +
                getId() + "#" + getProductName() +
                "#" + getPrice() + "#" + getWeight() +
                "#" + getColor() + "#" + getProductCount() +
                "#" + size + "#" + material + "#";
    }
}
