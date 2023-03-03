package usecase;

import entity.model.*;
import entity.service.CouponPrinterService;
import entity.service.CouponService;
import entity.service.PaymentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;

import static entity.model.PaymentMethod.DEBIT_CARD;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class PlaceOrderUseCaseTest {

    @Mock
    private PaymentService paymentService;
    @Mock
    private CouponService couponService;
    @Mock
    private CouponPrinterService couponPrinterService;

    @InjectMocks
    private PlaceOrderUseCase placeOrderUseCase;



    private Order createOrderWithOneItem() {
        var product = new Product("A", "Laranja", 10d, 0d);
        var order = new Order(1L, Instant.now(), DEBIT_CARD);

        order.add(product, 1);

        return order;
    }
}
