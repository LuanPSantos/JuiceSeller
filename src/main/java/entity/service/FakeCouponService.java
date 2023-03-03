package entity.service;

import entity.model.Coupon;
import entity.model.Order;

public class FakeCouponService implements CouponService {

    @Override
    public Coupon generate(Order order) {
        return new Coupon(355, order);
    }
}
