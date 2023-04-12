package entity.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {

    private final Long id;
    private final Instant date;
    private final PaymentMethod paymentMethod;
    private final List<Item> items;

    public Order(Long id, Instant date, PaymentMethod paymentMethod) {
        this.id = id;
        this.date = date;
        this.paymentMethod = paymentMethod;
        this.items = new ArrayList<>();
    }

    public Double total() {

        var total = 0d;
        for (Item item : items) {
            total += item.total();
        }

        return total;
    }

    public void add(Product product, Integer amount) {
        for(Item saleItem : items) {
            if(saleItem.getProduct().getCode().equals(product.getCode())) {
                saleItem.increaseAmount(amount);

                return;
            }
        }

        this.items.add(new Item(product, amount));
    }

    public Long getId() {
        return id;
    }

    public Instant getDate() {
        return date;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(this.items);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;

        return id.equals(order.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
