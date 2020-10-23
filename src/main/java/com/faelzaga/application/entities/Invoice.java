package main.java.com.faelzaga.application.entities;

public class Invoice {
    private double carValue;
    private double tax;
    private double feeRateTax;

    public Invoice(double carValue, double tax, double feeRateTax) {
        this.carValue = carValue;
        this.tax = tax;
        this.feeRateTax = feeRateTax;
    }

    public double getTotalValue() {
        return carValue + tax + feeRateTax;
    }

    public double getBasicValue() {
        return carValue;
    }

    public void setBasicValue(double basicValue) {
        this.carValue = basicValue;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getFeeRateTax() {
        return feeRateTax;
    }

    public void setFeeRateTax(double feeRateTax) {
        this.feeRateTax = feeRateTax;
    }
}
