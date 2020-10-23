package main.java.com.faelzaga.application.entities.vehicle;

public final class AdaptedVehicle extends Vehicle {

    public AdaptedVehicle(String model) {
        super(model,true);
    }

    @Override
    public String toString() {
        return "Adapted";
    }
}
