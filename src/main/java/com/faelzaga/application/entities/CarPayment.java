package main.java.com.faelzaga.application.entities;

import main.java.com.faelzaga.application.entities.client.Client;
import main.java.com.faelzaga.application.entities.employee.Employee;
import main.java.com.faelzaga.application.entities.vehicle.Vehicle;

public class CarPayment {
    private Client client;
    private Employee employee;
    private Vehicle vehicle;
    private Invoice invoice;

    public CarPayment(Client client, Vehicle vehicle) {
        this.client = client;
        this.vehicle = vehicle;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
