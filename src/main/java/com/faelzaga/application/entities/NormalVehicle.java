package main.java.com.faelzaga.application.entities;

public final class NormalVehicle extends Vehicle {

    public NormalVehicle(String model, String color, double value) {
        super(model,color,value*1.15);
    }

    @Override
    public void setValue(double value) {
        this.value = value*1.15;
    }

    @Override
    public String toString() {
        return "Nml " + super.toString();
    }
}
