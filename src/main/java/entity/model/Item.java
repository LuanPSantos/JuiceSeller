package entity.model;

public class Item {

    private final Product product;
    private Integer amount;

    public Item(Product product, Integer amount) {
        this.product = product;
        this.amount = amount;
    }

    public Double total() {
        return (product.getUnitPrice() - product.getDiscount()) * amount;
    }

    public void increaseAmount(Integer amount) {
        this.amount += amount;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getAmount() {
        return amount;
    }
}
