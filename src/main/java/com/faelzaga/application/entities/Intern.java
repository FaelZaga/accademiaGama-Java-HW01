package main.java.com.faelzaga.application.entities;

public class Intern extends Employee {

    public Intern(String name){
        super(name,false);
    }

    @Override
    public double sell(Vehicle vehicle, Client client) {
        if (salePermission) {
            salePermission = false;
            return super.sell(vehicle,client);
        }
        return 0;
    }
}

