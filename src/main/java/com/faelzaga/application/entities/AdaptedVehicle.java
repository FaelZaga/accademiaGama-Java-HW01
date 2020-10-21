package main.java.com.faelzaga.application.entities;

public final class AdaptedVehicle extends Vehicle {

    public AdaptedVehicle(String model, String color, double value) {
        super(model,color,value);
    }

    @Override
    public String toString() {
        return "Adp " + super.toString();
    }
}
