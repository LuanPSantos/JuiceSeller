package entity.service;

import entity.model.Coupon;

public interface CouponPrinterService {
    void printCustomerCoupon(Coupon coupon);

    void printKitchenCoupon(Coupon coupon);
}
