package main.java.com.faelzaga.application.entities;

public class Manager extends Employee {
    private String password;

    public Manager(String name, String password){
        super(name,true);
        this.password = password;
    }

    public boolean authPermission(String password, Employee employee) {
        if (this.password.equals(password)) {
            employee.setSalePermission(true);
            return true;
        }
        return false;
    }
}

