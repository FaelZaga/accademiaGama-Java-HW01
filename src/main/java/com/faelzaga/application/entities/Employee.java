package main.java.com.faelzaga.application.entities;

import java.util.Random;

public abstract class Employee {
    protected String name;
    protected Boolean salePermission;

    public Employee(String name, Boolean salePermission){
        this.name = name;
        this.salePermission = salePermission;
    }

    public double sell(Vehicle vehicle, Client client) {
        if (client.getInstallment()>1) {
            return vehicle.getValue()*1.0189/client.getInstallment();
        }else{
            return vehicle.getValue()-vehicle.getValue()*0.10;
        }
    }

    public void setSalePermission(Boolean salePermission) {
        this.salePermission = salePermission;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSalePermission() {
        return salePermission;
    }

    @Override
    public String toString() {
        return "Employee{" +
                ", name='" + name + '\'' +
                ", salePermission=" + salePermission +
                '}';
    }
}
