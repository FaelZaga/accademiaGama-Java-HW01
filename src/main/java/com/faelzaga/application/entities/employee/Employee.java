package main.java.com.faelzaga.application.entities.employee;

public class Employee {
    protected String name;
    protected Boolean salePermission;

    public Employee(String name, Boolean salePermission){
        this.name = name;
        this.salePermission = salePermission;
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
