package model.services;

import model.interfaces.OnlinePaymentService;

public class PaypalService implements OnlinePaymentService {
    public static Double PAYMENT_FEE = 0.02;
    public static Double INTEREST = 0.01;

    @Override
    public double paymentFee(Double amount) {
        return amount * PAYMENT_FEE;
    }
    @Override
    public double interest(Double amount, Integer months) {
        return amount * INTEREST * months;
    }
}
