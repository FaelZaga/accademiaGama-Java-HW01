package main.java.com.faelzaga.application.entities;

public class Client {
    public String name;
    public int installment;

    public Client(String name){
        this.name = name;
    }

    public Client(String name, int installment){
        this.name = name;
        this.installment = installment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInstallment() {
        return installment;
    }

    public void setInstallment(int installment) {
        this.installment = installment;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", installment=" + installment +
                '}';
    }
}
