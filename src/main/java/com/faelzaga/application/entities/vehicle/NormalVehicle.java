package main.java.com.faelzaga.application.entities.vehicle;

public final class NormalVehicle extends Vehicle {

    public NormalVehicle(String model) {
        super(model,false);
    }

    @Override
    public String toString() {
        return "Normal";
    }
}
