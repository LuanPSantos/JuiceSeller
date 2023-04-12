
import entity.model.PaymentMethod;
import entity.model.Product;
import entity.model.Order;
import entity.service.FakeCouponPrinterService;
import entity.service.FakeCouponService;
import entity.service.FakePaymentService;
import entity.service.PaymentService;
import usecase.PlaceOrderUseCase;
import usecase.PlaceOrderUseCase.Input;

import java.time.Instant;

public class Program {

    public static void main(String[] args) throws PaymentService.PaymentException {
        var placeOrderUseCase = new PlaceOrderUseCase(
                new FakePaymentService(),
                new FakeCouponService(),
                new FakeCouponPrinterService()
        );

        var product = new Product("P263-99-acerola laranja", "Acerola com Laranja", 12.98d, 0d);
        var order = new Order(1L, Instant.now(), PaymentMethod.DEBIT_CARD);

        order.add(product, 1);

        placeOrderUseCase.execute(new Input(order));
    }
}
