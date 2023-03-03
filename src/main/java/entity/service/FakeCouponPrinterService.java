package entity.service;

import entity.model.Coupon;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

public class FakeCouponPrinterService implements CouponPrinterService {

    @Override
    public void printCustomerCoupon(Coupon coupon) {
        System.out.println();
        System.out.println("           VENDA            ");
        System.out.println("----------------------------");
        System.out.println("Cupom: " + coupon.getCouponNumber() + "           Data Hora: " + DateTimeFormatter.ofPattern("dd/MM/yy HH:mm").format(LocalDateTime.ofInstant(coupon.getSale().getDate(), ZoneOffset.systemDefault())) );
        System.out.println("----------------------------");
        System.out.println("ITEM    PROD.             QTD   VL.UNIT   VL.DESC   VL.ITEM");

        AtomicInteger index = new AtomicInteger(1);
        coupon.getSale().getItems().forEach((item) -> {
            System.out.println((index.getAndIncrement()) + "    " + item.getProduct().getName() + "      " + item.getAmount() + " X " + item.getProduct().getUnitPrice() + "   " + item.getProduct().getDiscount() + "   " + item.total());
        });

        System.out.println("TOTAL: R$" + coupon.getSale().total());
        System.out.println(coupon.getSale().getPaymentMethod());
        System.out.println("           SENHA:" + coupon.getPinCode() + "            ");
        System.out.println();
    }

    @Override
    public void printKitchenCoupon(Coupon coupon) {
        System.out.println();
        System.out.println("           PEDIDO            ");
        System.out.println("----------------------------");
        System.out.println("           SENHA:" + coupon.getPinCode() + "            ");
        System.out.println("----------------------------");
        System.out.println("ITEM    PROD.             QTD");

        AtomicInteger index = new AtomicInteger(1);
        coupon.getSale().getItems().forEach((item) -> {
            System.out.println((index.getAndIncrement()) + "    " + item.getProduct().getName() + "      " + item.getAmount());
        });
        System.out.println();
    }
}
