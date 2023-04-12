package usecase;

import entity.model.*;
import entity.service.CouponPrinterService;
import entity.service.CouponService;
import entity.service.PaymentService;
import entity.service.PaymentService.PaymentException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import usecase.PlaceOrderUseCase.Input;

import java.time.Instant;

import static entity.model.PaymentMethod.DEBIT_CARD;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

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

    @Test
    void shouldPlaceAnOrder() throws PaymentException {
        // Montagem do cenário
        var order = createOrderWithOneItem();
        var coupon = new Coupon(PIN, order);

        var orderCaptor = ArgumentCaptor.forClass(Order.class);

        doNothing().when(paymentService).pay(eq(order.total()), eq(order.getPaymentMethod()));
        doReturn(coupon).when(couponService).generate(orderCaptor.capture());
        doNothing().when(couponPrinterService).printKitchenCoupon(eq(coupon));
        doNothing().when(couponPrinterService).printCustomerCoupon(eq(coupon));

        // Execução do cenário
        placeOrderUseCase.execute(new Input(order));

        // Validação
        var capturedOrder = orderCaptor.getValue();

        assertEquals(order.getId(), capturedOrder.getId());
        assertEquals(order.getDate(), capturedOrder.getDate());
        assertEquals(order.getPaymentMethod(), capturedOrder.getPaymentMethod());
        assertEquals(order.getItems(), capturedOrder.getItems());

        verify(paymentService, times(ONE)).pay(any(), any());
        verify(couponService, times(ONE)).generate(any());
        verify(couponPrinterService, times(ONE)).printKitchenCoupon(any());
        verify(couponPrinterService, times(ONE)).printCustomerCoupon(any());
    }

    @Test
    void shouldNotPlaceAnOrderDuePaymentException() throws PaymentException {
        // Montagem do cenário
        var order = createOrderWithOneItem();

        doThrow(new PaymentException()).when(paymentService).pay(eq(order.total()), eq(order.getPaymentMethod()));

        // Execução do cenário
        Executable executable = () -> placeOrderUseCase.execute(new Input(order));

        // Validação
        assertThrows(PaymentException.class, executable);

        verify(paymentService, times(ONE)).pay(any(), any());
        verify(couponService, times(ZERO)).generate(any());
        verify(couponPrinterService, times(ZERO)).printKitchenCoupon(any());
        verify(couponPrinterService, times(ZERO)).printCustomerCoupon(any());
    }

    private Order createOrderWithOneItem() {
        var product = new Product(CODE, NAME, PRICE, DISCOUNT);
        var order = new Order(ORDER_ID, Instant.now(), DEBIT_CARD);

        order.add(product, AMOUNT_OF_PRODUCTS);

        return order;
    }

    private final static String CODE = "A";
    private final static String NAME = "Laranja";
    private final static Double PRICE = 10d;
    private final static Double DISCOUNT = 0d;
    private final static Integer PIN = 1;
    private final static Long ORDER_ID = 1L;
    private final static Integer AMOUNT_OF_PRODUCTS = 1;
    private final static Integer ONE = 1;
    private final static Integer ZERO = 0;
}
