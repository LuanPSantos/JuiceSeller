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
}
