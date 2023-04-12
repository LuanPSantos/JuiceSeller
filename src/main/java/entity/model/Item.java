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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item item)) return false;

        if (!product.equals(item.product)) return false;
        return amount.equals(item.amount);
    }

    @Override
    public int hashCode() {
        int result = product.hashCode();
        result = 31 * result + amount.hashCode();
        return result;
    }
}
