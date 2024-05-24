package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

import java.time.Duration;

public class RentalService {
    private Double pricePerHour;
    private Double pricePerDay;

    private BrazilTaxService bts;

    public RentalService(Double pricePerHour, Double pricePerDay, BrazilTaxService bts) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.bts = bts;
    }

    public Double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(Double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public BrazilTaxService getBts() {
        return bts;
    }

    public void setBts(BrazilTaxService bts) {
        this.bts = bts;
    }

    public void processInvoice(CarRental carRental) {
        double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
        double hours = minutes / 60.0;
        double days = hours / 24.0;

        double basicPayment;
        if (hours <= 12.0) {
            basicPayment = pricePerHour * Math.ceil(hours);
        }
        else {
            basicPayment = pricePerDay * Math.ceil(days);
        }

        double tax = bts.tax(basicPayment);
        carRental.setInvoice(new Invoice(basicPayment, tax));
    }
}
