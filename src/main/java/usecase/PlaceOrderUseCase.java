package usecase;

import entity.model.Order;
import entity.service.CouponPrinterService;
import entity.service.CouponService;
import entity.service.PaymentService;
import entity.service.PaymentService.PaymentException;

public class PlaceOrderUseCase {

    private final PaymentService paymentService;
    private final CouponService couponService;
    private final CouponPrinterService couponPrinterService;

    public PlaceOrderUseCase(
            PaymentService paymentService,
            CouponService couponService,
            CouponPrinterService couponPrinterService) {
        this.paymentService = paymentService;
        this.couponService = couponService;
        this.couponPrinterService = couponPrinterService;
    }

    public void execute(Input input) throws PaymentException {

        var order = input.order;

        paymentService.pay(order.total(), order.getPaymentMethod());

        var coupon = couponService.generate(order);

        couponPrinterService.printCustomerCoupon(coupon);
        couponPrinterService.printKitchenCoupon(coupon);

    }

    public record Input(Order order) { }
}
