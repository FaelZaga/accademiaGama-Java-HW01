package main.java.com.faelzaga.application.entities;

public abstract class Vehicle {
    public String model;
    public String color;
    public double value;

    public Vehicle(String model, String color, double value){
        this.model = model;
        this.color = color;
        this.value = value;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return model + " - " +
                "color: " + color +
                " - value: R$ " + value;
    }
}