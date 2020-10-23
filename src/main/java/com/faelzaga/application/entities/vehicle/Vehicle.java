package main.java.com.faelzaga.application.entities.vehicle;

public class Vehicle {
    private String model;
    private boolean isAdapted;

    public Vehicle(String model, boolean isAdapted){
        this.model = model;
        this.isAdapted = isAdapted;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isAdapted() {
        return isAdapted;
    }

    public void setAdapted(boolean adapted) {
        isAdapted = adapted;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "model='" + model + '\'' +
                '}';
    }
}