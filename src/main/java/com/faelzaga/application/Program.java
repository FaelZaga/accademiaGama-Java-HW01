package main.java.com.faelzaga.application;

import main.java.com.faelzaga.application.entities.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Welcome :)!! May I help you? (y/n)");
            String answer = sc.nextLine().toUpperCase();
            while (!answer.equals("Y") && !answer.equals("N")) {
                System.out.println("Please, be more specific");
                answer = sc.nextLine().toUpperCase();
            }
            if (answer.equals("Y")) {
                System.out.println("Nice! What is your name?");
                String clientName = sc.nextLine().toUpperCase();

                //Creating client object in here ------------------------------------------------

                Client client = new Client(clientName);

                //The creation ends here -----------------------------------------------------------

                System.out.printf("Nice to meet you %s! Which car are you looking for?\n", clientName);

                //Creating vehicles objects in here ------------------------------------------------
                Vehicle carA = new NormalVehicle("Duster", "White", 86690.00);
                Vehicle carB = new NormalVehicle("Corolla", "Wine", 102990.00);
                Vehicle carC = new NormalVehicle("Onix", "White", 58590.00);
                Vehicle carD = new AdaptedVehicle("Onix", "Blue", 58590.00);
                Vehicle carE = new AdaptedVehicle("Sandero", "Black", 48990.00);

                Vehicle[] cars = {carA, carB, carC, carD, carE};

                //The creation ends here -----------------------------------------------------------

                System.out.println("---------------------VEHICLES---------------------");
                Integer carId = 0;
                for (Vehicle car : cars) {
                    System.out.println(carId.toString() + " - " + car);
                    carId += 1;
                }
                System.out.println("--------------------------------------------------");
                System.out.print("Type the number: ");
                int answerInt = sc.nextInt();
                while (answerInt > cars.length - 1) {
                    System.out.println("Sorry! No associated car to this number.");
                    System.out.print("Type the number: ");
                    answerInt = sc.nextInt();
                }

                Vehicle vehicleChosen = cars[answerInt];

                System.out.println("Nice choice! You have chosen the next one below:");
                System.out.println("---------------------------------------------------------------------");
                System.out.println(vehicleChosen);

                //Creating employee objects in here -----------------------------------------------

                System.out.println("---------------------LETS-CREATE-THE-MANAGER-NOW---------------------");
                System.out.print("Manager name:");
                sc.nextLine();
                String nameManager = answer = sc.nextLine();
                System.out.print("Manager password:");
                String passwordManager = answer = sc.nextLine();

                Employee employee;
                Manager manager = new Manager(nameManager, passwordManager);

                //The creation ends here -----------------------------------------------------------

                System.out.println("---------------------END-OF-CREATION----------------------");
                System.out.println("Select which employee is talking to you:");
                System.out.println("-------------------------EMPLOYEE-------------------------");
                System.out.printf("1 - intern\n2 - seller\nany - manager\n");
                System.out.println("----------------------------------------------------------");
                System.out.print("Type here: ");
                answerInt = sc.nextInt();
                System.out.println("----------------------------------------------------------");
                switch (answerInt) {
                    case 1:
                        employee = new Intern("Pedro");
                        System.out.printf("Hello!! My name is %s. Since Im an intern, I have no permission to continue this negotiation." +
                                "\nLet me ask my manager for the permission first ok?\n", employee.getName());
                        System.out.println("---------------------YOU-ARE-THE-MANAGER-NOW---------------------");
                        System.out.printf("Do you grant the permission to %s? (y/n)\n", employee.getName());
                        sc.nextLine();
                        answer = sc.nextLine().toUpperCase();
                        while (!answer.equals("Y") && !answer.equals("N")) {
                            System.out.println("Please, be more specific.");
                            answer = sc.nextLine().toUpperCase();
                        }
                        if (answer.equals("Y")) {
                            System.out.println("PASSWORD: ");
                            answer = sc.nextLine();

                            if (manager.authPermission(answer, employee)) {
                                System.out.printf("Permission granted! Lets get this over with! :)\n");
                                break;
                            } else {
                                System.out.println("Wrong password! Since the manager have forgotten the password today.\n" +
                                        "Someone else is going to help you. Hold on...");
                            }
                        } else if (answer.equals("N")) {
                            System.out.println("Seems like we have a lot of problem with this intern.\n" +
                                    "Soon enough someone else is going to help you. Hold on...");
                        }
                    case 2:
                        employee = new Salesman("Maria");
                        System.out.printf("Hello!! My name is %s and Im a seller. Lets continue. ;)\n", employee.getName());
                        break;
                    default:
                        employee = (Manager) manager;
                        System.out.printf("Hello!! My name is %s and Im the manager. Lets continue. ;)\n", employee.getName());
                }
                System.out.println("Select the payment type:");
                System.out.println("---------------------PAYMENT---------------------");
                System.out.printf("1 - in cash\nany - finance\n");
                System.out.println("-------------------------------------------------");
                answerInt = sc.nextInt();
                double carValue;
                if (answerInt == 1) {
                    System.out.println("Ok then! You have chosen in cash ($_$)");

                    client.setInstallment(1);

                    carValue = employee.sell(vehicleChosen, client);

                    System.out.printf("The value you are going to pay is R$ %.2f\n", carValue);
                    System.out.printf("Original - R$ %.2f\n", vehicleChosen.getValue());

                } else {
                    System.out.println("Fine! You have chosen finance");
                    System.out.print("How many installment? ");
                    answerInt = sc.nextInt();
                    System.out.println("Sure! Lets see...");

                    client.setInstallment(answerInt);

                    carValue = employee.sell(vehicleChosen, client);

                    System.out.printf("The value you are going to pay is %dX of R$ %.2f\n", client.getInstallment(), carValue);
                    System.out.printf("Total - R$ %.2f\n", client.getInstallment() * carValue);
                    System.out.printf("Original - R$ %.2f\n", vehicleChosen.getValue());
                }
            } else if (answer.equals("N")) {
                System.out.println("Have a nice day! Bye :D!");
            }

            System.out.println("Thank you and have a nice day! ;)");

            sc.close();
        }catch (InputMismatchException e) {
            System.out.println("Error! Only number allowed");
        }
    }

}
