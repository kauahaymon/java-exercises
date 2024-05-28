package model.services;

import model.entities.Contract;
import model.entities.Installment;
import model.interfaces.OnlinePaymentService;

import java.time.LocalDate;

public class ContractService {
    OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, Integer months) {
        double basicQuota = contract.getTotalValue() / months;

        for (int i=1; i<=months; i++) {
            LocalDate dueDate = contract.getDate().plusMonths(i);
            double interest = onlinePaymentService.interest(basicQuota, i);
            double paymentFee = onlinePaymentService.paymentFee(basicQuota + interest);
            double quota = basicQuota + interest + paymentFee;

            contract.getInstallmentList().add(new Installment(dueDate, quota));
        }
    }
}
