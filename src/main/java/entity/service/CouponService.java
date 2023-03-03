package entity.service;

import entity.model.Coupon;
import entity.model.Order;

public interface CouponService {
    Coupon generate(Order order);
}
