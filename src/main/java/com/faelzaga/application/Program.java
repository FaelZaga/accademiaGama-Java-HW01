package main.java.com.faelzaga.application;

import main.java.com.faelzaga.application.entities.CarPayment;
import main.java.com.faelzaga.application.entities.client.Client;
import main.java.com.faelzaga.application.entities.employee.Employee;
import main.java.com.faelzaga.application.entities.employee.Intern;
import main.java.com.faelzaga.application.entities.employee.Manager;
import main.java.com.faelzaga.application.entities.employee.Salesman;
import main.java.com.faelzaga.application.entities.vehicle.AdaptedVehicle;
import main.java.com.faelzaga.application.entities.vehicle.NormalVehicle;
import main.java.com.faelzaga.application.services.FeeRateTax;
import main.java.com.faelzaga.application.services.NormalVehicleTax;
import main.java.com.faelzaga.application.services.PaymentService;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("-------------Enter-client-data-------------");
        System.out.print("Name: ");
        String clientName = sc.nextLine();
        System.out.println("---------------Enter-car-data--------------");
        System.out.print("Car model: ");
        String carModel = sc.nextLine();
        System.out.print("Car value: ");
        double carValue = sc.nextDouble();
        System.out.print("Is the car adapted for special people?(y/n) ");
        sc.nextLine();
        String isAdapted = sc.nextLine();

        CarPayment cd;
        if (isAdapted.equalsIgnoreCase("y")) {
            cd = new CarPayment(new Client(clientName),new AdaptedVehicle(carModel));
        }else{
            cd = new CarPayment(new Client(clientName),new NormalVehicle(carModel));
        }

        System.out.println("-------------Enter-manager-data------------");
        System.out.print("Name: ");
        String managerName = sc.nextLine();
        System.out.print("Password: ");
        String managerPass = sc.nextLine();
        System.out.println("------------Enter-employee-data------------");
        System.out.println("----------------occupation-----------------");
        System.out.println("1 - INTERN");
        System.out.println("2 - SALESMAN");
        System.out.println("3 - MANAGER");
        System.out.println("-------------------------------------------");
        System.out.print("Enter a number: ");
        int employeeOcc = sc.nextInt();

        Employee employee;
        String employeeName;
        Manager manager = new Manager(managerName,managerPass);

        switch (employeeOcc) {
            case 2:
                System.out.print("Name: ");
                sc.nextLine();
                employeeName = sc.nextLine();
                employee = new Salesman(employeeName);
                break;
            case 1:
                System.out.print("Name: ");
                sc.nextLine();
                employeeName = sc.nextLine();
                employee = new Intern(employeeName);
                System.out.print("Password: ");
                String pass = sc.nextLine();
                if (manager.authPermission(pass, employee)) {
                    System.out.println("------------PERMISSION-GRANTED-------------");
                    break;
                }else{
                    System.out.println("------------PERMISSION-DENIED--------------");
                }
            default:
                employee = (Employee) manager;
        }

        cd.setEmployee(employee);

        System.out.println("----------------installment----------------");
        System.out.println("IN CASH TYPE: 1");
        System.out.println("FINANCE TYPE: NUMBER OF TIMES");
        System.out.println("-------------------------------------------");
        System.out.print("Enter a number: ");
        int times = sc.nextInt();

        PaymentService rentalService = new PaymentService(carValue,new NormalVehicleTax(), new FeeRateTax(times));

        rentalService.processInvoice(cd);

        System.out.println("-----------INVOICE------------");
        System.out.println("Client Name: "+cd.getClient().getName());
        System.out.println("Salesman Name: "+cd.getEmployee().getName());
        System.out.println("");
        System.out.println("Model: "+cd.getVehicle().getModel());
        System.out.println("Vehicle: "+cd.getVehicle());
        System.out.println("");
        System.out.println("Basic payment: "+String.format("%.2f",cd.getInvoice().getBasicValue()));
        System.out.println("Tax (nml vehicle): "+String.format("%.2f",cd.getInvoice().getTax()));
        System.out.println("Tax (Finance): "+String.format("%.2f",cd.getInvoice().getFeeRateTax()));
        System.out.println("Total payment: "+String.format("%.2f",cd.getInvoice().getTotalValue()));
        System.out.println("-----------------------------");

        sc.close();
    }

}
