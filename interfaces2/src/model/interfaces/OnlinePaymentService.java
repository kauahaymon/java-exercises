package model.interfaces;

public interface OnlinePaymentService {
    double paymentFee(Double amount);
    double interest(Double amount, Integer months);
}
