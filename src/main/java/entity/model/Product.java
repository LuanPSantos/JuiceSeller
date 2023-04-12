package entity.model;

public class Product {
    private final String code;
    private final String name;
    private Double unitPrice;
    private Double discount;

    public Product(String code, String name, Double unitPrice, Double discount) {
        this.code = code;
        this.name = name;
        this.unitPrice = unitPrice;
        this.discount = discount;
    }

    public void updatePrice(Double newUnitPrice) {
        this.unitPrice = newUnitPrice;
    }

    public void updateDiscount(Double newDiscount) {
        this.discount = newDiscount;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public Double getDiscount() {
        return discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;

        if (!code.equals(product.code)) return false;
        if (!name.equals(product.name)) return false;
        if (!unitPrice.equals(product.unitPrice)) return false;
        return discount.equals(product.discount);
    }

    @Override
    public int hashCode() {
        int result = code.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + unitPrice.hashCode();
        result = 31 * result + discount.hashCode();
        return result;
    }
}
