package model.services;
    // Agora Esta Classe implementa TaxService
public class BrazilTaxService implements TaxService{
    public double tax(double amount) {
        if (amount <= 100) {
            return amount * 0.2;
        }
        else {
            return amount * 0.15;
        }
    }
}
