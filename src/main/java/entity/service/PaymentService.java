package entity.service;

import entity.model.PaymentMethod;

public interface PaymentService {
    void pay(Double amount, PaymentMethod paymentMethod);
}
