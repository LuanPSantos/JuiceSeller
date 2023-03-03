package usecase;

import entity.model.Order;
import entity.service.CouponPrinterService;
import entity.service.CouponService;
import entity.service.PaymentService;

public class PlaceOrderUseCase {

    private final PaymentService paymentService;
    private final CouponService couponService;
    private final CouponPrinterService couponPrinterService;

    public PlaceOrderUseCase(PaymentService paymentService, CouponService couponService, CouponPrinterService couponPrinterService) {
        this.paymentService = paymentService;
        this.couponService = couponService;
        this.couponPrinterService = couponPrinterService;
    }

    public void execute(Input input) {

        var sale = input.order;

        paymentService.pay(sale.total(), sale.getPaymentMethod());

        var coupon = couponService.generate(sale);

        couponPrinterService.printCustomerCoupon(coupon);
        couponPrinterService.printKitchenCoupon(coupon);

    }

    public record Input(Order order) { }
}
