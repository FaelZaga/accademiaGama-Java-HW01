package main.java.com.faelzaga.application.services;

public class FeeRateTax implements TaxService {
    private int installment;

    public FeeRateTax(int installment) {
        this.installment = installment;
    }

    public double tax(double amount) {
        if (installment > 1) {
            return amount * 0.0189;
        }
        return amount * -0.10;
    }
}
