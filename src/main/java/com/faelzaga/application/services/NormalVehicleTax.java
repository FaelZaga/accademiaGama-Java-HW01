package main.java.com.faelzaga.application.services;

public class NormalVehicleTax implements TaxService {

    public double tax(double amount) {
        return amount * 0.15;
    }

}
