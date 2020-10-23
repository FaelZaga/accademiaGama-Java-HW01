package main.java.com.faelzaga.application.services;

import main.java.com.faelzaga.application.entities.CarPayment;
import main.java.com.faelzaga.application.entities.Invoice;

public class PaymentService {

    private double carPrice;
    private TaxService taxService;
    private TaxService taxFeeService;

    public PaymentService(double carPrice, TaxService taxService, TaxService taxFeeService) {
        this.carPrice = carPrice;
        this.taxService = taxService;
        this.taxFeeService = taxFeeService;
    }

    public void processInvoice(CarPayment carPayment) {
        double tax = 0;
        if (!carPayment.getVehicle().isAdapted()) {
            tax = taxService.tax(carPrice);
        }

        double feeTax = feeTax = taxFeeService.tax(carPrice);

        carPayment.setInvoice(new Invoice(carPrice, tax,feeTax));
    }
}
