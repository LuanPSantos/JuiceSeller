package entity.model;

public class Coupon {

    private final Integer pinCode;
    private final Order order;

    public Coupon(Integer pinCode, Order order) {
        this.pinCode = pinCode;
        this.order = order;
    }

    public Long getCouponNumber() {
        return order.getId();
    }

    public Integer getPinCode() {
        return pinCode;
    }

    public Order getSale() {
        return order;
    }
}
