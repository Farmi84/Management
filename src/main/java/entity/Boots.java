package entity;

public class Boots extends Product {
    private int size;
    private boolean isNaturalSkin;
    final String productType = "C";

    public Boots(long id, String productName, float price, float weight, String color, int productCount, int size, boolean isNaturalSkin) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.isNaturalSkin = isNaturalSkin;
    }

    public int getSize() {
        return size;
    }

    public boolean isNaturalSkin() {
        return isNaturalSkin;
    }

    @Override
    public String toString() {
        return productType + "#" +
                getId() + "#" + getProductName() +
                "#" + getPrice() + "#" + getWeight() +
                "#" + getColor() + "#" + getProductCount() +
                "#" + size + "#" + isNaturalSkin + "#";
    }
}
