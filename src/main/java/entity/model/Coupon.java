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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coupon coupon)) return false;

        if (!pinCode.equals(coupon.pinCode)) return false;
        return order.equals(coupon.order);
    }

    @Override
    public int hashCode() {
        int result = pinCode.hashCode();
        result = 31 * result + order.hashCode();
        return result;
    }
}
