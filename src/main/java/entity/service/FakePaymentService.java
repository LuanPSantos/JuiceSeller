package entity.service;

import entity.model.PaymentMethod;

public class FakePaymentService implements PaymentService {

    @Override
    public void pay(Double amount, PaymentMethod paymentMethod) {
        System.out.println();
        System.out.println("Pagamento realizado com sucesso!");
        System.out.println("Valor: R$" + amount);
        System.out.println("Forma de pagamento: " + paymentMethod);
        System.out.println();
    }
}
